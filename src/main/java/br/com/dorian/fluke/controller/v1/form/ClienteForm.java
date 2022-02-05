package br.com.dorian.fluke.controller.v1.form;

import java.util.List;
import java.util.stream.Collectors;

import br.com.dorian.fluke.model.cliente.Cliente;
import lombok.Getter;

@Getter
public class ClienteForm {
	
    private String nomeCompleto;
    private String cpf;
    private String cidade;
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
