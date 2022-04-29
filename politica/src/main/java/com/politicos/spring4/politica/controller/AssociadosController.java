package com.politicos.spring4.politica.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.politicos.spring4.politica.model.Associados;
import com.politicos.spring4.politica.model.Partidos;
import com.politicos.spring4.politica.servico.AssociadosServ;
import com.politicos.spring4.politica.servico.PartidosServ;

@Controller
@RequestMapping("/associados")
public class AssociadosController {
	
	@Autowired
	private AssociadosServ associadoServ;
	
	@Autowired 
	private PartidosServ partidoServ;
	
	
	@GetMapping
	public ModelAndView getAssociados() {
		
		ModelAndView mv = new ModelAndView("associadosTemplate");
		
		mv.addObject("associado", new Associados());
		mv.addObject("associados", associadoServ.getAssociados());
		mv.addObject("partido", partidoServ.getPartidos());                   
		
		return mv;
	}
	@GetMapping("/removerAssociado")
	public String removerAssociado(@RequestParam Long idAssociado) {
		
		Associados associado = associadoServ.getAssociadosById(idAssociado);
		associadoServ.remover(associado);
		
		return "redirect:/associados";
		
		
	}
	
	@GetMapping("/editarAssociado")
	public ModelAndView editarAssociado(@RequestParam Long idAssociado) {
		
		ModelAndView mv = new ModelAndView("associadoEdit");
		
		Associados associados = associadoServ.getAssociadosById(idAssociado);
		mv.addObject("associados", associados);
		mv.addObject("partido", partidoServ.getPartidos());
		
		return mv;
	}
	

	
	@PostMapping
	public String salvar(@ModelAttribute Associados associados) {
		
		associadoServ.salvar(associados);
		
		return "redirect:/associados";
	}
	
	@PostMapping("/detalhes/associarPartido")
	public String associarPartido(@ModelAttribute Partidos partidos, @RequestParam Long id) {
	
		System.out.println(partidos);
	
		System.out.println(id);
	
	
	Associados associados = associadoServ.getAssociadosById(id);
	partidos = partidoServ.getPartidosById(partidos.getId());
		
		
	//associados.add(partidosResult);
	associadoServ.salvar(associados);
		
	return "redirect:/associados/detalhes/" + id;
		
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView getPartidoDetalhes(@PathVariable Long id) {
		
		Associados associados = associadoServ.getOne(id);
		ModelAndView mv = new ModelAndView("detalhesAssociado");
		mv.addObject("associados", associados);
		
		List<Partidos> partidosNaoAssociados = partidoServ.getPartidos();
		
		
		partidosNaoAssociados.remove(associados.getPartidos());
		mv.addObject("partidos", partidosNaoAssociados);
		
		return mv;
		
	}
	
		
	}
