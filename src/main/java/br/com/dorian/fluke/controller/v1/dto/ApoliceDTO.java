package br.com.dorian.fluke.controller.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dorian.fluke.model.apolice.Apolice;
import lombok.Getter;

@Getter
public class ApoliceDTO {
	
	private Long id;
	private Long numeroApolice;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	private String placaVeiculo;
	private BigDecimal valor;
	private String clienteNome;
	
	public ApoliceDTO(Apolice apolice) {
		this.id = apolice.getId();
		this.numeroApolice = apolice.getNumeroApolice();
		this.inicioVigencia = apolice.getInicioVigencia();
		this.fimVigencia = apolice.getFimVigencia();
		this.placaVeiculo = apolice.getPlacaVeiculo();
		this.valor = apolice.getValor();
	}
	
	public static List<ApoliceDTO> converter(List<Apolice> apolices) {
		return apolices.stream().map(ApoliceDTO::new).collect(Collectors.toList());
	}








}
