package br.com.dorian.fluke.service.cliente.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.model.cliente.Cliente;
import br.com.dorian.fluke.repository.cliente.ClienteRepository;
import br.com.dorian.fluke.service.cliente.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional
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
	@Transactional
	public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }
	@Override
	public Optional<Cliente> findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public Apolice create(ApoliceDTO dto) {
		Apolice apolice = new Apolice();
		apolice.setInicioVigencia(dto.getInicioVigencia());
		apolice.setFimVigencia(dto.getFimVigencia());
		apolice.setPlacaVeiculo(dto.getPlacaVeiculo());
		apolice.setValorApolice(dto.getValor());
		Optional<Cliente> clienteOptional = findByCpf(dto.getCliente().getCpf());
		apolice.setCliente(clienteOptional.get());
		return apolice;
	}
	
}
