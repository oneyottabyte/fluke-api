package br.com.dorian.fluke.controller.v1.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class ApoliceDetalhadaDTO {
	private UUID numeroApolice;
	private String placaVeiculo;
	private BigDecimal valorApolice;
	private String vencimento;
}
