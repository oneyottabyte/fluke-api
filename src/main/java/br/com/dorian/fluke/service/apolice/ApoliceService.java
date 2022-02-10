package br.com.dorian.fluke.service.apolice;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.dorian.fluke.model.apolice.Apolice;

public interface ApoliceService {
	
	Apolice save(Apolice apolice);

	Page<Apolice> findAll(Pageable pageable);

	Optional<Apolice> findById(UUID id);

	void delete(Apolice apolice);

}
