package com.vinnijr.gestaocontatos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinnijr.gestaocontatos.model.Contato;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long>{

}
