package com.vinnijr.gestaocontatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    
    public Page<Contato> buscaPaginada(
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nome");

        return contatoRepository.buscaPaginada(
                pageRequest);
    }


    public Page<Contato> obtemTodosOrdenados() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nome");
        return new PageImpl<>(
        		contatoRepository.findAll(), 
                pageRequest, size);
    }



}
