package br.com.dorian.fluke.controller.v1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.dorian.fluke.model.cliente.Cliente;
import lombok.Getter;

@Getter
public class ClienteDTO {
	
	private Long id;
    private String nomeCompleto;
    private String cpf;
    private String cidade;
    private String uf;
	
    public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.cidade = cliente.getCidade();
		this.uf = cliente.getUf();
	}
    
    public static List<ClienteDTO> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
}
