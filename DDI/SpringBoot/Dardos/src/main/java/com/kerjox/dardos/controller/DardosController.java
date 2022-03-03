package com.kerjox.dardos.controller;

import com.kerjox.dardos.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DardosController {

	@Autowired
	private GameService gameService;

	@GetMapping("/")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView();
		gameService.initGame();
		mv.setViewName("index");
		mv.addObject("players", gameService.getPlayers());
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView play() {

		ModelAndView mv = new ModelAndView();

		while (true) {

			if (gameService.play()) break;
		}

		mv.setViewName("index");
		mv.addObject("players", gameService.getPlayers());

		return mv;
	}
}
