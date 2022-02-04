package br.com.dorian.fluke.controller.v1.apolice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@GetMapping
	public List<ApoliceDTO> listApolices() {
		List<Apolice> apolices =  apoliceService.getAllApolices();
		return ApoliceDTO.converter(apolices);
	}
	
}
