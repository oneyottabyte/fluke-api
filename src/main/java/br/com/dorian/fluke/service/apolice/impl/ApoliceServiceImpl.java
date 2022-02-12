package br.com.dorian.fluke.service.apolice.impl;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.controller.v1.dto.ApoliceDetalhadaDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.repository.apolice.ApoliceRepository;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import br.com.dorian.fluke.util.expiration.CheckExpiration;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApoliceServiceImpl implements ApoliceService{
	
	private final ApoliceRepository apoliceRepository;

	@Override
	@Transactional
	public Apolice save(Apolice apolice) {
		return apoliceRepository.save(apolice);
	}

	@Override
	public Page<Apolice> findAll(Pageable pageable) {
		return apoliceRepository.findAll(pageable);
	}

	@Override
	public Optional<Apolice> findByNumeroApolice(UUID numeroApolice) {
		return apoliceRepository.findByNumeroApolice(numeroApolice);
	}

	@Override
	@Transactional
	public void delete(Apolice apolice) {
		apoliceRepository.delete(apolice);
	}

	@Override
	@Transactional 
	public ApoliceDetalhadaDTO detalharApolice(Optional<Apolice> apoliceOptional) {
		ApoliceDetalhadaDTO dto = new ApoliceDetalhadaDTO();
        dto.setNumeroApolice(apoliceOptional.get().getNumeroApolice());
        dto.setPlacaVeiculo(apoliceOptional.get().getPlacaVeiculo());
        dto.setValorApolice(apoliceOptional.get().getValorApolice());
        dto.setVencimento(CheckExpiration.isExpiration(apoliceOptional.get().getFimVigencia()));
        return dto;
	}

	@Override
	public Apolice toApolice(ApoliceDTO dto, Apolice apolice) {
        apolice.setInicioVigencia(dto.getInicioVigencia());
      	apolice.setFimVigencia(dto.getFimVigencia());
      	apolice.setPlacaVeiculo(dto.getPlacaVeiculo());
      	apolice.setValorApolice(dto.getValor());
		return apolice;
	}


}
