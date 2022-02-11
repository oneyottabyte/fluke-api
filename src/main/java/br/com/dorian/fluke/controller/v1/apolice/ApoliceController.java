package br.com.dorian.fluke.controller.v1.apolice;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.controller.v1.dto.ApoliceDetalhadaDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
    public ResponseEntity<Object> saveApolice(@RequestBody @Valid ApoliceDTO dto){
		Apolice apolice = new Apolice();
		modelMapper.map(dto, apolice);
		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.save(apolice));
    }
	
    @GetMapping
    public ResponseEntity<Page<Apolice>> getAllApolices(@PageableDefault(page = 0, size = 5, sort = "fimVigencia", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.findAll(pageable));
    }

    @GetMapping("/{numeroApolice}")
    public ResponseEntity<Object> getOneApolice(@PathVariable(value = "numeroApolice") UUID numeroApolice){
        Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        ApoliceDetalhadaDTO dto = apoliceService.detalharApolice(apoliceOptional);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    
	@DeleteMapping("/{numeroApolice}")
    public ResponseEntity<Object> deleteApolice(@PathVariable UUID numeroApolice){
    	Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        apoliceService.delete(apoliceOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apolice deletado com successo.");
    }

    @PutMapping("/{numeroApolice}")
    public ResponseEntity<Object> updateApolice(@PathVariable UUID numeroApolice, @RequestBody @Valid ApoliceDTO dto){
        Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        var apolice = new Apolice();
        apolice.setNumeroApolice(apoliceOptional.get().getNumeroApolice());
        apolice.setInicioVigencia(dto.getInicioVigencia());
      	apolice.setFimVigencia(dto.getFimVigencia());
      	apolice.setPlacaVeiculo(dto.getPlacaVeiculo());
      	apolice.setValorApolice(dto.getValor());
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.save(apolice));
    }
	
}
