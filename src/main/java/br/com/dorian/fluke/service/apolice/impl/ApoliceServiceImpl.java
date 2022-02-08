package br.com.dorian.fluke.service.apolice.impl;

import org.springframework.stereotype.Service;

import br.com.dorian.fluke.repository.apolice.ApoliceRepository;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApoliceServiceImpl implements ApoliceService{
	
	private ApoliceRepository apoliceRepository;
	

}
