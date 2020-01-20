package com.vinnijr.gestaocontatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinnijr.gestaocontatos.model.Contato;
import com.vinnijr.gestaocontatos.service.ContatoService;

@RestController
@RequestMapping("/gestao_contato")
@CrossOrigin(origins = "*")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> cadastrarContato(@RequestBody Contato contato) {
		return new ResponseEntity<Contato>(contatoService.cadastrar(contato), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contato>> listar() {
		List<Contato> contato = (List<Contato>) contatoService.buscarTodos();
		return new ResponseEntity<List<Contato>>(contato, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> alterar(@RequestBody Contato contato) {
		return new ResponseEntity<Contato>(contatoService.cadastrar(contato), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<Contato> excluir(@PathVariable Long id) {
		contatoService.excluir(id);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}
	
	/**
	 * Lista paginada
	 * */
    @GetMapping("/listar-paginado/{page}/{size}")
    public Page<Contato> search(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return contatoService.buscaPaginada(page, size);

    }




}
