package com.vinnijr.gestaocontatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinnijr.gestaocontatos.model.Contato;
import com.vinnijr.gestaocontatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	public Contato cadastrar(Contato contato) {
		return contatoRepository.save(contato);
	}

	public List<Contato> buscarTodos() {
		return (List<Contato>) contatoRepository.findAll();
	}
	
    public void excluir(Long id){
    	contatoRepository.deleteById(id);
    }
    
    public Optional<Contato> buscarPorId(Long id) {
    	Optional<Contato> optionalContato = contatoRepository.findById(id);
		return optionalContato;
    }



}
