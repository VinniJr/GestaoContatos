package com.vinnijr.gestaocontatos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = -6605419715324059895L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_contato")
	private Long id;

	@Column(name = "nome_contato")
	@NotBlank(message = "Nome é um campo obrigatorio")
	private String nome;

	@Column(name = "valor")
	@NotBlank(message = "valor é um campo obrigatorio")
	private String valor;

	@Column(name = "observacao")
	private String obs;

	@Column(name = "canal")
	@Enumerated(EnumType.STRING)
	private Canal canal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
