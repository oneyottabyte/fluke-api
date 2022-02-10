package br.com.dorian.fluke.controller.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ApoliceDTO {
	
	private Long numeroApolice;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	private String placaVeiculo;
	private BigDecimal valor;

}
