package br.com.dorian.fluke.controller.v1.cliente;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import br.com.dorian.fluke.controller.v1.dto.ClienteDTO;
import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.service.cliente.ClienteService;
import br.com.dorian.fluke.util.cpf.CpfValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "CRUD de Clientes")
@Schema(hidden = true)
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Operation(summary = "Cadastro de cliente. Todos os dados são obrigatórios.")
	@PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDTO dto){
        if(clienteService.existsByCpf(dto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Cpf já está em uso!");
        }
        if(!CpfValidator.isValid(dto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Cpf Invalido!");
        }
        var cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

	@Operation(summary = "Listagem de todos os clientes.")
    @GetMapping
    public ResponseEntity<Page<Cliente>> getAllClientes(@PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) @Parameter(hidden = true) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
    }

	@Operation(summary = "Consulta de cliente pelo CPF.")
	@Schema(hidden = true)
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "cpf") String cpf){
        Optional<Cliente> clienteOptional = clienteService.findByCpf(cpf);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional);
    }

	@Operation(summary = "Remove um cliente pelo CPF.")
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteCliente(@PathVariable String cpf){
    	Optional<Cliente> clienteOptional = clienteService.findByCpf(cpf);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com successo.");
    }

	@Operation(summary = "Atualiza um cliente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO dto){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        if(!CpfValidator.isValid(dto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF Invalido!");
        }

        var cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        cliente.setId(clienteOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

}
