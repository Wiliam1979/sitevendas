package br.com.assis.william.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.assis.william.domain.Cliente;
import br.com.assis.william.repositories.ClienteRepository;
import br.com.assis.william.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo; 
	
	public Cliente find(Integer id) {
		Optional<Cliente>obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo:" +Cliente.class.getName()));
			
		
	}

}
