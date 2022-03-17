package com.kerjox.mvc.controllers;

import com.kerjox.mvc.services.BingoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BingoController {

	@Autowired
	BingoService service;

	@GetMapping("/")
	public ModelAndView index() {

		return getModelAndView();
	}

	@GetMapping("/play")
	public ModelAndView play(){

		service.play();

		return getModelAndView();
	}

	protected ModelAndView getModelAndView() {

		var mv = new ModelAndView("index");
		mv.addObject("carton", service.getCarton());
		mv.addObject("numerosSacados", service.getNumerosSacados());
		mv.addObject("lastNumber", service.getLastNumber());

		return mv;
	}
}
