package br.com.dorian.fluke.controller.v1.report;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorian.fluke.controller.v1.dto.ApoliceDetalhadaDTO;
import br.com.dorian.fluke.model.apolice.Apolice;
import br.com.dorian.fluke.service.apolice.ApoliceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/report")
@Tag(name = "Consulta Apolice", description = "Consulta de uma Apólice por número")
public class ReportApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@Operation(summary = "Para fazer a consulta informe o número da Apólice")
    @GetMapping("/{numeroApolice}")
    public ResponseEntity<Object> getOneApolice(@PathVariable(value = "numeroApolice") UUID numeroApolice){
        Optional<Apolice> apoliceOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrado.");
        }
        ApoliceDetalhadaDTO dto = apoliceService.detalharApolice(apoliceOptional);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
