package com.vinnijr.gestaocontatos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinnijr.gestaocontatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	@Query("FROM Contato c")
	Page<Contato> buscaPaginada(Pageable pageable);
	
	 

}
