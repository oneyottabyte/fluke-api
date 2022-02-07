package br.com.dorian.fluke.controller.v1.apolice;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.controller.v1.form.ApoliceForm;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ApoliceDTO> listApolices() {
		List<Apolice> apolices =  apoliceService.getAllApolices();
		return ApoliceDTO.converter(apolices);
	}
	
	@GetMapping("/{id}")
	public ApoliceDTO findById(@PathVariable Long id) {
		Apolice apolice = apoliceService.findById(id);
		ApoliceDTO dto = modelMapper.map(apolice, ApoliceDTO.class);
		return dto; 
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<ApoliceDTO> createCliente(@RequestBody @Valid ApoliceForm form,
			UriComponentsBuilder uriBuilder) {
		Apolice apolice = apoliceService.createApolice(form);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(apolice.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApoliceDTO(apolice));
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<ApoliceDTO> update(@PathVariable Long id, @RequestBody @Valid ApoliceForm form) {
		Apolice apolice = apoliceService.updateCliente(id, form);
		return ResponseEntity.ok(new ApoliceDTO(apolice));

	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return apoliceService.deletarApolice(id);	
	}
	
}
