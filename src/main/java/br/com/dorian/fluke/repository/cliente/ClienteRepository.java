package br.com.dorian.fluke.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dorian.fluke.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	boolean existsByCpf(String cpf);
}
