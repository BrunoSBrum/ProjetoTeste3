package com.politicos.spring4.politica.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.politicos.spring4.politica.model.Partidos;
import com.politicos.spring4.politica.servico.PartidosServ;

@Controller
@RequestMapping("/partidos")
public class PartidosController {
	
	@Autowired
	private PartidosServ serv;
	
	@GetMapping
	public ModelAndView getPartidos() {
		ModelAndView mv = new ModelAndView("partidosTemplate");
		mv.addObject("partidos", serv.getPartidos());
		
		return mv;
	}
	
	@GetMapping("/{id}/associados")
	public ModelAndView getPartidoDetalhes(@PathVariable(name = "id") Long id) {
		
		Partidos partidos = serv.getPartidosById(id);
		ModelAndView mv = new ModelAndView("detalhesPartido");
		mv.addObject("partidos", partidos);
		
		return mv;
	}
	
	@PostMapping
	@Transactional
	public String salvar(@ModelAttribute Partidos partidos) {
		serv.salvar(partidos);
		
		return "redirect:/partidos";
	}
	
	

}
