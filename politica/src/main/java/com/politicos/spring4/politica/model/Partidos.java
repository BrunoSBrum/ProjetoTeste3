package com.politicos.spring4.politica.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Partidos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String nome;
	
	
	private String sigla;
	
	
	private String ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDateTime dataFundacao;

	@OneToMany
	@JoinColumn(name = "ID_PARTIDOS")
	private List<Associados> associados;
	
	
	
	public Partidos() {
		
	}

	public Partidos(  String nome,   String sigla,
			  String ideologia, LocalDateTime dataFundacao) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setAssociados(List<Associados> associados) {
		this.associados = associados;
	}
	public List<Associados> getAssociados() {
		return associados;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDateTime getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDateTime dataFundacao) {
		this.dataFundacao = dataFundacao;
	}


	public void setNome(String nome2) {
		this.nome = nome2;
		
	}

	@Override
	public String toString() {
		return "Partidos [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", ideologia=" + ideologia
				+ ", dataFundacao=" + dataFundacao + ", associados=" + associados + "]";
	}

	public void add(Partidos partidosResult) {
	
		
	}

	

	



	
}
