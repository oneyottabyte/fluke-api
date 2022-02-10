package br.com.dorian.fluke.controller.v1.apolice;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDTO;
import br.com.dorian.fluke.controller.v1.form.ApoliceForm;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@PostMapping
    public ResponseEntity<Object> saveApolice(@RequestBody @Valid ApoliceForm form){

        var apolice = new Apolice();
        BeanUtils.copyProperties(form, apolice);
        return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.save(apolice));
    }
    @GetMapping
    public ResponseEntity<Page<Apolice>> getAllApolices(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneApolice(@PathVariable(value = "id") UUID id){
        Optional<Apolice> apoliceOptional = apoliceService.findById(id);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        var dto = new ApoliceDTO();
        BeanUtils.copyProperties(apoliceOptional, dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteApolice(@PathVariable UUID id){
    	Optional<Apolice> apoliceOptional = apoliceService.findById(id);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        apoliceService.delete(apoliceOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apolice deletedo com successo.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateApolice(@PathVariable UUID id, @RequestBody @Valid ApoliceForm form){
        Optional<Apolice> apoliceOptional = apoliceService.findById(id);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        var apolice = new Apolice();
        BeanUtils.copyProperties(form, apolice);
        apolice.setNumeroApolice(apoliceOptional.get().getNumeroApolice());
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.save(apolice));
    }
	
}
