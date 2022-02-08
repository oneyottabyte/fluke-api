package br.com.dorian.fluke.service.cliente;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.dorian.fluke.controller.v1.dto.ClienteDTO;
import br.com.dorian.fluke.controller.v1.form.ClienteForm;
import br.com.dorian.fluke.model.cliente.Cliente;

public interface ClienteService {
	
	List<Cliente> getAllClientes();
	
	Cliente createCliente(ClienteForm form);
	
	Cliente updateCliente(Long id, ClienteForm form);
	
	Cliente toCliente(ClienteForm form);
	
	Cliente findById(Long id);
	
	ResponseEntity<?> deletarCliente(Long id);

	ClienteDTO toDTO(Cliente cliente);
}
