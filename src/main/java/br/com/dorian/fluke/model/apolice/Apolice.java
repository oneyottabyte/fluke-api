package br.com.dorian.fluke.model.apolice;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.dorian.fluke.model.cliente.Cliente;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_apolice")
public class Apolice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Long numeroApolice;
	@NotNull
	private LocalDate inicioVigencia;
	@NotNull
	private LocalDate fimVigencia;
	@NotNull
	private String placaVeiculo;
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@JoinColumn(name = "id_cliente")
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private Cliente cliente;
}
