package com.politicos.spring4.politica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.politicos.spring4.politica.model.Associados;
import com.politicos.spring4.politica.repository.AssociadoRepository;

@Service
public class AssociadosServ {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	
	public List<Associados> getAssociados(){
		
		return associadoRepository.findAll();
	}
	
	
	public void salvar(Associados associados) {
		associadoRepository.save(associados);
	}

	
	
	public Associados getAssociadosById(Long idAssociado) {
		
		return associadoRepository.findById(idAssociado).get();
	}


	public Associados getOne(Long id) {
		
		return associadoRepository.getOne(id);
	}
	
	public void remover(Associados associados) {
		associadoRepository.delete(associados);
	}

	
}
