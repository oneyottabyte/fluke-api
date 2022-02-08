package br.com.dorian.fluke.controller.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ApoliceDTO {
	
	private Long id;
	private Long numeroApolice;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	private String placaVeiculo;
	private BigDecimal valor;

}
