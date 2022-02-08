package br.com.dorian.fluke.controller.v1.cliente;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dorian.fluke.controller.v1.dto.ClienteDTO;
import br.com.dorian.fluke.controller.v1.form.ClienteForm;
import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.service.cliente.ClienteService;
import br.com.dorian.fluke.util.config.ValidadorCPF;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> listClientes() {
		List<Cliente> clientes = clienteService.getAllClientes();
		return ClienteDTO.converter(clientes);
	}
	
	@GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		return clienteService.toDTO(cliente);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		if(!ValidadorCPF.isValid(form.getCpf())) {
			return ResponseEntity.badRequest().body(null);
		}
		Cliente cliente = clienteService.createCliente(form);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody @Valid ClienteForm form) {
		Cliente cliente = clienteService.updateCliente(id, form);
		return ResponseEntity.ok(new ClienteDTO(cliente));
	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return clienteService.deletarCliente(id);	
	}
}
