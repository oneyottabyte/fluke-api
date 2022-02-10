package br.com.dorian.fluke.service.apolice.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.repository.apolice.ApoliceRepository;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApoliceServiceImpl implements ApoliceService{
	
	private ApoliceRepository apoliceRepository;

	@Override
	public Apolice save(Apolice apolice) {
		return apoliceRepository.save(apolice);
	}

	@Override
	public Page<Apolice> findAll(Pageable pageable) {
		return apoliceRepository.findAll(pageable);
	}

	@Override
	public Optional<Apolice> findById(UUID id) {
		return apoliceRepository.findById(id);
	}

	@Override
	public void delete(Apolice apolice) {
		apoliceRepository.delete(apolice);
	}
	
	

}
