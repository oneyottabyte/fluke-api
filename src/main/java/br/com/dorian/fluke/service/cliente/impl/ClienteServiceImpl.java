package br.com.dorian.fluke.service.cliente.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.repository.cliente.ClienteRepository;
import br.com.dorian.fluke.service.cliente.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
	@Override
	@Transactional
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	@Override
	public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }
}
