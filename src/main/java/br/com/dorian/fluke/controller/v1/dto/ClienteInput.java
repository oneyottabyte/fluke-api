package br.com.dorian.fluke.controller.v1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class ClienteInput {
	@NotNull 
	@NotEmpty(message = "CPF é uma informação obrigatória") 
	@Size(min=11, max=11)
    private String cpf;

}
