package br.com.dorian.fluke.model.apolice;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import br.com.dorian.fluke.model.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_apolice")
public class Apolice {
	@Id
	private String id;
	@NotNull
	private Long codigo;
	@NotNull
	private LocalDate inicioVigencia;
	@NotNull
	private LocalDate fimVigencia;
	@NotNull
	private String placaVeiculo;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Cliente cliente;
}
