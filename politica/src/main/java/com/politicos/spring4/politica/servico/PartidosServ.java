package com.politicos.spring4.politica.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politicos.spring4.politica.model.Partidos;
import com.politicos.spring4.politica.repository.PartidoRepository;

@Service
public class PartidosServ {
	
	
	@Autowired
	private PartidoRepository partidoRepository;

	public void salvar(Partidos partidos) {
		partidoRepository.save(partidos);
	}
	
	public List<Partidos> getPartidos(){
		return partidoRepository.findAll();
	}

	public Partidos getPartidosById(Long id) {
		return partidoRepository.findById(id).get();
	}
	
}
