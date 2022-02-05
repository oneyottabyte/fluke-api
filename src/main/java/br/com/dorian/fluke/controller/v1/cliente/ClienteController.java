package br.com.dorian.fluke.controller.v1.cliente;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> listClientes() {
		List<Cliente> clientes =  clienteService.getAllClientes();
		return ClienteDTO.converter(clientes);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> createCliente(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteService.createCliente(form);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id,	@RequestBody @Valid ClienteForm form) {
		Cliente cliente = clienteService.updateCliente(id, form);
		return ResponseEntity.ok(new ClienteDTO(cliente));
	
}
}
