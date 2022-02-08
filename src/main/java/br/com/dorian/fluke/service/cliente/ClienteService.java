package br.com.dorian.fluke.service.cliente;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.dorian.fluke.model.cliente.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);

	Page<Cliente> findAll(Pageable pageable);

	Optional<Cliente> findById(UUID id);

	void delete(Cliente cliente);

	boolean existsByCpf(String cpf);
}
