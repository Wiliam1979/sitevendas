package br.com.assis.william;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.assis.william.domain.Categoria;
import br.com.assis.william.repositories.CategoriaRepository;

@SpringBootApplication
public class SitevendasApplication implements CommandLineRunner {

	  @Autowired
	 private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SitevendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
