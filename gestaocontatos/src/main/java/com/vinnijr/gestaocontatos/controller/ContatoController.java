package com.vinnijr.gestaocontatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinnijr.gestaocontatos.model.Contato;
import com.vinnijr.gestaocontatos.repository.ContatoRepository;

@RestController
@RequestMapping("/")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;

	
	@RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> cadastrarContato(@RequestBody Contato contato) {
		return new ResponseEntity<Contato>(contatoRepository.save(contato), HttpStatus.CREATED);
	}


}
