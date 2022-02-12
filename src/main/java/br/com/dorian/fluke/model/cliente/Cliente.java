package br.com.dorian.fluke.model.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dorian.fluke.model.apolice.Apolice;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(nullable = false, length = 130)
    private String nomeCompleto;

	@Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
	@Column(nullable = false, length = 40)
    private String cidade;
    
	@Column(nullable = false, length = 2)
    private String uf;
 
	@OneToMany()
	@JsonIgnore
	private List<Apolice> apolices = new ArrayList();

	
}

	