package com.kerjox.dardos.services;

import com.kerjox.dardos.entities.Player;
import com.kerjox.dardos.modes.Mode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class GameServiceTest {

	@Spy
	private GameService service;

	@MockBean
	private Mode mode;

	@Mock
	private List<Player> playersMock;

	@Mock
	private Player playerMock;

	@BeforeEach
	void setUp() {

		service.setMode(mode);
		service.setNumPlayers(2);
		service.setPlayers(playersMock);

		when(mode.getMaxPoints()).thenReturn(301);
	}

	@Test
	void initPlayers() {

		service.initPlayers();

		verify(playersMock, times(2)).add(any(Player.class));
	}

	@Test
	void initGame() {

		// Test Exception

		service.setNumPlayers(0);

		assertThrows(RuntimeException.class, () -> {

			service.initGame();
		});

		service.setNumPlayers(2);
		service.initGame();

		doNothing().when(service).initPlayers();
		verify(service, times(1)).initPlayers();

		assertEquals(0, service.getIndexActivePlayer());
	}

	@Test
	void play() {

		service.setActivePlayer(0);
		when(playersMock.size()).thenReturn(2);

		service.play(playerMock);

		verify(playerMock, times(1)).tirar();
		assertNotEquals(0, service.getIndexActivePlayer());

		service.play(playerMock);

		assertEquals(0, service.getIndexActivePlayer());
	}

	@Test
	void getActivePlayer() {

		var player1 = new Player("PlayerMock", mode);
		service.setActivePlayer(1);

		when(playersMock.get(1)).thenReturn(player1);

		var player2 = service.getActivePlayer();

		assertSame(player1, player2);
	}

	@Test
	void getPlayers() {

		var players = service.getPlayers();

		assertSame(playersMock, players);
	}
}