package br.com.dorian.fluke.model.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente", uniqueConstraints={@UniqueConstraint(columnNames={"cpf"})})
public class Cliente {
    
	@Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nome")
    private String nomeCompleto;

	@Column(name = "cpf")
    private String cpf;
    
	@Column(name = "cidade")
    private String cidade;
    
	@Column(name = "uf")
    private String uf;
}