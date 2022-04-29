package com.politicos.spring4.politica.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="associados")
public class Associados implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAssociado;
	
	
	@Column(name = "nome")
	private String nome;
	

	@Column(name = "cargo")
	private String cargo;
	

	@Column(name = "sexo")
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name = "ID_PARTIDOS")
	private Partidos partido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataNascimento;
	

	
	public Associados() {
		
	}

	public Associados(String nome, String cargo, String sexo,
			LocalDateTime dataNascimento) {
		this.nome = nome;
		this.cargo = cargo;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}



	public Associados(String nome, String cargo,
			  String sexo, Partidos partido, LocalDateTime dataNascimento) {
		this.nome = nome;
		this.cargo = cargo;
		this.sexo = sexo;
		this.partido = partido;
		this.dataNascimento = dataNascimento;
	}


	
	public Partidos getPartidos() {
		return partido;
	}

	public void setPartidos(Partidos partidos) {
		this.partido = partidos;
	}
	
	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Associados [idAssociado=" + idAssociado + ", nome=" + nome + ", cargo=" + cargo + ", sexo=" + sexo
				+ ", partidos=" + partido.getNome() + ", dataNascimento=" + dataNascimento + "]";
	}

	public void add(Partidos partidosResult) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
