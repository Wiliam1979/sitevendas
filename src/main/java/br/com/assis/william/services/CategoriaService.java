package br.com.assis.william.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.assis.william.domain.Categoria;
import br.com.assis.william.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria>obj=repo.findById(id);
		return obj.orElse(null);
		
	}

}
