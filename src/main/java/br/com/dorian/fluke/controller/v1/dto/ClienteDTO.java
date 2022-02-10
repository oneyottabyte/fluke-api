package br.com.dorian.fluke.controller.v1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class ClienteDTO {
	
	@NotNull 
	@NotEmpty(message = "Nome Completo é uma informação obrigatória") 
	@Size(min=2, max=130)
    private String nomeCompleto;
	
	@NotNull 
	@NotEmpty(message = "CPF é uma informação obrigatória") 
	@Size(min=11, max=11)
    private String cpf;
	
	@NotNull 
	@NotEmpty(message = "Nome da cidade é uma informação obrigatória") 
	@Size(min=2, max=40)
    private String cidade;
	
	@NotNull 
	@NotEmpty(message = "Sigla UF do estado é uma informação obrigatória") 
	@Size(min=2,max=2)
    private String uf;
}
