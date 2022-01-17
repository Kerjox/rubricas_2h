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

	public void setAhorcadoService(AhorcadoService ahorcadoService) {
		this.ahorcadoService = ahorcadoService;
	}

	@GetMapping("/")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("index");
		modelAndView.addObject("alphabet", AhorcadoUtils.getAlphabet());
		modelAndView.addObject("ahorcado", ahorcadoService.getAhorcado());
		return modelAndView;
	}

	@RequestMapping(value = "/checkLetter", params = {"letter"}, method = RequestMethod.GET)
	public ModelAndView checkLetter(@RequestParam("letter") char letter) {

		ahorcadoService.checkLetter(letter);
		System.out.printf("Letra %s", letter);
		System.out.println(ahorcadoService.getWord());
		System.out.println(ahorcadoService.getWordToShow());
		System.out.println(Arrays.toString(ahorcadoService.getWordMask()));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("alphabet", AhorcadoUtils.getAlphabet());
		modelAndView.setViewName("index");
		modelAndView.addObject("ahorcado", ahorcadoService.getAhorcado());

		return modelAndView;
	}

	@GetMapping("/error")
	public String error() {

		return "error";
	}
}