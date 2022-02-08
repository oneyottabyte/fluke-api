package br.com.dorian.fluke.controller.v1.cliente;

import java.util.Optional;
import java.util.UUID;

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

import br.com.dorian.fluke.controller.v1.form.ClienteForm;
import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.service.cliente.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteForm form){
        if(clienteService.existsByCpf(form.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Cpf já está em uso!");
        }
        var cliente = new Cliente();
        BeanUtils.copyProperties(form, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> getAllClientes(@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") UUID id){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id){
    	Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletedo com successo.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClienteForm form){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var cliente = new Cliente();
        BeanUtils.copyProperties(form, cliente);
        cliente.setId(clienteOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

}
