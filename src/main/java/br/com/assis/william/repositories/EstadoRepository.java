package br.com.assis.william.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.assis.william.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer>{

}
