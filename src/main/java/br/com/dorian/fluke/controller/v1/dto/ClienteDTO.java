package br.com.dorian.fluke.controller.v1.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	private UUID id;
    private String nomeCompleto;
    private String cpf;
    private String cidade;
    private String uf;
}
