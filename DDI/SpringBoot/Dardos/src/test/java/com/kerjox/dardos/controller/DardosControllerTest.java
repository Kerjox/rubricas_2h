package com.kerjox.dardos.controller;

import com.kerjox.dardos.entities.Player;
import com.kerjox.dardos.modes.Mode;
import com.kerjox.dardos.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(DardosController.class)
class DardosControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GameService service;

	@MockBean
	private Mode mode;

	private List<Player> players;

	@BeforeEach
	void setUp() {

		players = new ArrayList<>();

		players.add(new Player("Player 1", mode));
		players.add(new Player("Player 2", mode));

		when(mode.getMaxPoints()).thenReturn(301);
		when(service.getPlayers()).thenReturn(players);
	}

	@Test
	void index() throws Exception {

		var result = mvc.perform(get("/")).andReturn();

		var response = result.getResponse();
		var mv = result.getModelAndView();

		// Response status 200 Ok
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		// Test ModelAndView
		assertNotNull(mv);
		assertEquals("index", mv.getViewName());

		var players = (List<Player>) mv.getModel().get("players");
		assertSame(service.getPlayers(), players);
	}

	@Test
	void playWithNoPlayers() throws Exception {

		when(service.getActivePlayer()).thenThrow(NullPointerException.class);

		var result = mvc.perform(get("/play")).andReturn();
		var response = result.getResponse();
		var mv = result.getModelAndView();

		// Response status 424 FAILED_DEPENDENCY
		assertEquals(HttpStatus.FAILED_DEPENDENCY.value(), response.getStatus());

		// Check redirect
		assertNotNull(mv);
		assertEquals("redirect:/" , mv.getViewName());
	}

	@Test
	void playWinnerPlayer() throws Exception {

		when(service.getActivePlayer()).thenReturn(players.get(0));
		players.get(0).setWinner(true);

		var result = mvc.perform(get("/play")).andReturn();
		var response = result.getResponse();
		var mv = result.getModelAndView();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		// Test ModelAndView
		assertNotNull(mv);
		assertEquals("index", mv.getViewName());
	}
}