package com.kerjox.dardos.controller;

import com.kerjox.dardos.entities.Player;
import com.kerjox.dardos.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DardosController {

	@Autowired
	private GameService gameService;

	@GetMapping("/")
	public ModelAndView index() {

		gameService.initGame();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("players", gameService.getPlayers());
		mv.setStatus(HttpStatus.OK);
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView play() {

		ModelAndView mv = new ModelAndView();

		Player player;

		do {

			try {

				player = gameService.getActivePlayer();
			} catch (NullPointerException e) {

				e.printStackTrace();
				mv.setViewName("redirect:/");
				mv.setStatus(HttpStatus.FAILED_DEPENDENCY);
				return mv;
			}

			gameService.play(player);
		} while (!player.isWinner());

		mv.setViewName("index");
		mv.addObject("players", gameService.getPlayers());
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
}
