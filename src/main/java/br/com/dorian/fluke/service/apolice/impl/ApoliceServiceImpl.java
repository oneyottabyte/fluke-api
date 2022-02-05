package br.com.dorian.fluke.service.apolice.impl;

import java.util.List;

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
	public List<Apolice> getAllApolices() {
		return apoliceRepository.findAll();
	}
}
