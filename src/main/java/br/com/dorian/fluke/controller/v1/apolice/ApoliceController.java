package br.com.dorian.fluke.controller.v1.apolice;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import br.com.dorian.fluke.service.cliente.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/apolices")
@Tag(name = "Apolices", description = "CRUD de Apolice")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Operation(summary = "Cadastro de Apólices. Cliente deve ser criado antes.")
	@PostMapping
    public ResponseEntity<Object> saveApolice(@RequestBody @Valid ApoliceDTO dto){
		if(!clienteService.existsByCpf(dto.getCliente().getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Cliente ainda não foi cadastrado!");
        }
		Apolice apoliceCriada = clienteService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.save(apoliceCriada));
    }
	
	@Operation(summary = "Listagem de todos as Apolices.")
    @GetMapping
    public ResponseEntity<Page<Apolice>> getAllApolices(@PageableDefault(page = 0, size = 5, sort = "fimVigencia", direction = Sort.Direction.ASC) @Parameter(hidden = true) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.findAll(pageable));
    }
    
	@Operation(summary = "Remove uma apólice.")
	@DeleteMapping("/{numeroApolice}")
    public ResponseEntity<Object> deleteApolice(@PathVariable UUID numeroApolice){
    	Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        apoliceService.delete(apoliceOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apolice deletado com successo.");
    }

	@Operation(summary = "Atualiza uma apólice.")
    @PutMapping("/{numeroApolice}")
    public ResponseEntity<Object> updateApolice(@PathVariable UUID numeroApolice, @RequestBody @Valid ApoliceDTO dto){
        Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        var apolice = new Apolice();
        apolice.setNumeroApolice(apoliceOptional.get().getNumeroApolice());
        apolice = apoliceService.toApolice(dto, apolice);
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.save(apolice));
    }
	
}
