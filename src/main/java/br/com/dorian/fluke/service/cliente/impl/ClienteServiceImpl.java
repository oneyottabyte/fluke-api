package br.com.dorian.fluke.service.cliente.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.controller.v1.form.ClienteForm;
import br.com.dorian.fluke.exception.ResourceNotFoundException;
import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.repository.cliente.ClienteRepository;
import br.com.dorian.fluke.service.cliente.ClienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente createCliente(ClienteForm form) {
		Cliente cliente = toCliente(form);
		return clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente updateCliente(Long id, ClienteForm form) {
		Cliente cliente = findById(id);
		cliente = toCliente(form);
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente toCliente(ClienteForm form) {
		return modelMapper.map(form, Cliente.class);
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
	}

	@Override
	public ResponseEntity<?> deletarCliente(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);		
		if(optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.notFound().build();	
	}
}
