package br.com.dorian.fluke.service.apolice.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dorian.fluke.controller.v1.form.ApoliceForm;
import br.com.dorian.fluke.exception.ResourceNotFoundException;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.repository.apolice.ApoliceRepository;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApoliceServiceImpl implements ApoliceService{
	
	private ApoliceRepository apoliceRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<Apolice> getAllApolices() {
		return apoliceRepository.findAll();
	}

	@Override
	public Apolice findById(Long id) {
		return apoliceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado!"));
	}

	@Override
	public Apolice createApolice(ApoliceForm form) {
		Apolice apolice = modelMapper.map(form, Apolice.class);
		return apoliceRepository.save(apolice);
	}

	@Override
	public Apolice updateCliente(Long id, ApoliceForm form) {
		Apolice apolice = modelMapper.map(form, Apolice.class);
		apolice.setId(id);
		return apoliceRepository.save(apolice);
	}

	@Override
	public ResponseEntity<?> deletarApolice(Long id) {
		Optional<Apolice> optional = apoliceRepository.findById(id);		
		if(optional.isPresent()) {
			apoliceRepository.deleteById(id);
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.notFound().build();
	}
}
