package br.com.dorian.fluke.controller.v1.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ApoliceForm {
	
	@NotNull 
	private LocalDate inicioVigencia;
	@NotNull
	private LocalDate fimVigencia;
	@NotNull @NotEmpty @Size(max = 10)
	private String placaVeiculo;
	@NotNull
	private BigDecimal valor;
	@NotNull @NotEmpty @Size(max = 15)
	private String clienteCpf;

}
