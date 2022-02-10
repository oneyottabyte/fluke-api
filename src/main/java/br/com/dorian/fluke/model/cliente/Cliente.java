package br.com.dorian.fluke.model.cliente;

import java.io.Serializable;
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
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
	@Column(nullable = false, length = 130)
    private String nomeCompleto;

	@Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
	@Column(nullable = false, length = 40)
    private String cidade;
    
	@Column(nullable = false, length = 2)
    private String uf;
}