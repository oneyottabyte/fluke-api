package br.com.dorian.fluke.model.apolice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_apolice")
public class Apolice implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID numeroApolice;
	
	@Column @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicioVigencia;
	
	@Column @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fimVigencia;
	
	@Column(length = 7) @NotNull
	private String placaVeiculo;
	
	@Column @NotNull
	private BigDecimal valorApolice;
	
}
