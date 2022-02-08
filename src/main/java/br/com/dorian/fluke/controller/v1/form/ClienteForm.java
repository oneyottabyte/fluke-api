package br.com.dorian.fluke.controller.v1.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class ClienteForm {
	
	@NotNull @NotEmpty @Size(max=130)
    private String nomeCompleto;
	@NotNull @NotEmpty @Size(max=15)
    private String cpf;
	@NotNull @NotEmpty @Size(max=40)
    private String cidade;
	@NotNull @NotEmpty @Size(max=2)
    private String uf;
}
