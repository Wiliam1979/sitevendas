package br.com.assis.william.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.assis.william.domain.Pedido;
import br.com.assis.william.repositories.PedidoRepository;
import br.com.assis.william.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo; 
	
	public Pedido find(Integer id) {
		Optional<Pedido>obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo:" +Pedido.class.getName()));
			
		
	}

}
