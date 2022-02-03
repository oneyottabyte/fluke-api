package br.com.dorian.fluke.service.cliente.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.repository.cliente.ClienteRepository;
import br.com.dorian.fluke.service.cliente.ClienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

}
