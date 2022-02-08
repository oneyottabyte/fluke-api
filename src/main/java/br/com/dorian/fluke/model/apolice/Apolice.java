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

import lombok.Data;

@Data
@Entity
@Table(name = "tb_apolice")
public class Apolice implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID numeroApolice;
	
	 @Column(nullable = false)
	private LocalDate inicioVigencia;
	
	@Column(nullable = false)
	private LocalDate fimVigencia;
	
	@Column(nullable = false, length = 7)
	private String placaVeiculo;
	
	@Column(nullable = false)
	private BigDecimal valorApolice;
	
}
