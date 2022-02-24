package com.kerjox.ahorcado.controllers;

import com.kerjox.ahorcado.services.AhorcadoService;
import com.kerjox.ahorcado.utils.AhorcadoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class AhorcadoController {

	@Autowired
	AhorcadoService ahorcadoService;

	@GetMapping("/")
	public ModelAndView index() {
		ahorcadoService.initGame();
		return getIndex();
	}

	@GetMapping(value = "/checkLetter")
	public ModelAndView checkLetter(@RequestParam("letter") char letter) {

		ahorcadoService.checkLetter(letter);
		return getIndex();
	}

	@GetMapping("/error")
	public String error() {

		return "error";
	}

	private ModelAndView getIndex() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("consonant", AhorcadoUtils.getAlphabet(false));
		modelAndView.addObject("alphabet", AhorcadoUtils.getAlphabet());
		modelAndView.addObject("ahorcado", ahorcadoService.getAhorcado());
		modelAndView.setViewName("index");

		return modelAndView;
	}
}
