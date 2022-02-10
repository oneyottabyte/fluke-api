package br.com.dorian.fluke.controller.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApoliceDTO {
	
	@NotNull(message = "Data do Inicio da Vigencia da apolice é uma informação obrigatória") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate inicioVigencia;
	
	@NotNull(message = "Data do Fim da Vigencia da apolice é uma informação obrigatória") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fimVigencia;
	
	@NotBlank(message = "Placa do Veiculo é uma informação obrigatória") 
	@Size(min= 7,max = 7)
	private String placaVeiculo;
	
	@NotNull(message = "Valor da Apolice é uma informação obrigatória")
	private BigDecimal valor;
}

