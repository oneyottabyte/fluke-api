package br.com.dorian.fluke.controller.v1.form;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.dorian.fluke.model.cliente.Cliente;
import lombok.Getter;

@Getter
public class ClienteForm {
	
	@NotNull @NotEmpty @Size(max=90)
    private String nomeCompleto;
	@NotNull @NotEmpty @Size(max=15)
    private String cpf;
	@NotNull @NotEmpty @Size(max=40)
    private String cidade;
	@NotNull @NotEmpty @Size(max=2)
    private String uf;
	
    
    public ClienteForm() {
	}

	public ClienteForm(Cliente cliente) {
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.cidade = cliente.getCidade();
		this.uf = cliente.getUf();
	}
    
    public static List<ClienteForm> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteForm::new).collect(Collectors.toList());
	}



}
