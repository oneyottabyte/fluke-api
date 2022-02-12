package br.com.dorian.fluke.service.cliente;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.model.cliente.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);

	Page<Cliente> findAll(Pageable pageable);

	Optional<Cliente> findById(Long id);

	void delete(Cliente cliente);

	boolean existsByCpf(String cpf);

	Optional<Cliente> findByCpf(String cpf);

	Apolice create(ApoliceDTO dto);
}
