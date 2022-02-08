package br.com.dorian.fluke.controller.v1.apolice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.service.apolice.ApoliceService;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	
}
