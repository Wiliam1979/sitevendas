package br.com.assis.william.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.assis.william.domain.Cliente;
import br.com.assis.william.dto.ClienteDTO;
import br.com.assis.william.repositories.ClienteRepository;
import br.com.assis.william.services.exceptions.DataIntegrityException;
import br.com.assis.william.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo; 
	
	public Cliente find(Integer id) {
		Optional<Cliente>obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo:" +Cliente.class.getName()));
			
		
	}
	
	  public Cliente update(Cliente obj) {
	    	Cliente newObj = find(obj.getId());
	    	updateDate(newObj, obj);
	    	return repo.save(newObj);
	    }
	    
	    public void delete(Integer id) {
	    	try {   
	    	
	    	find(id);
	    	repo.deleteById(id);
	    	} catch(DataIntegrityViolationException e) {
	    		throw new DataIntegrityException("Não e possivel excluir porque há entidade relacionadas");
	    		
	    	}
	    	
	    }
		public List<Cliente> findAll() {
			
			return repo.findAll();
		}
		
		public Page<Cliente>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
					orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Cliente fromDTO(ClienteDTO objDto) {
			return new Cliente(objDto.getId(),objDto.getNome(), objDto.getEmail(),null, null);
		}
		
		private void updateDate(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}

}
