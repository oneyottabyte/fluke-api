package br.com.dorian.fluke.service.apolice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.dorian.fluke.controller.v1.form.ApoliceForm;
import br.com.dorian.fluke.model.apolice.Apolice;

public interface ApoliceService {

	List<Apolice> getAllApolices();

	Apolice findById(Long id);

	Apolice createApolice(ApoliceForm form);

	Apolice updateApolice(Long id, ApoliceForm form);

	ResponseEntity<?> deletarApolice(Long id);

}
