package br.com.dorian.fluke.controller.v1.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class ClienteForm {
	
	@NotNull @NotEmpty @Size(min=2, max=130)
    private String nomeCompleto;
	@NotNull @NotEmpty @Size(min=11, max=11)
    private String cpf;
	@NotNull @NotEmpty @Size(min=2, max=40)
    private String cidade;
	@NotNull @NotEmpty @Size(min=2,max=2)
    private String uf;
}
