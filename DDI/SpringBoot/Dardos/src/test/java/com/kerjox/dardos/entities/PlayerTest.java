package com.kerjox.dardos.entities;

import com.kerjox.dardos.modes.Mode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PlayerTest {

	@MockBean
	private Mode mode;

	@Spy
	private Player player;

	@Mock
	private List<Tirada> tiradasMock;

	@BeforeEach
	void setUp() {

		player.setMode(mode);
		when(mode.getMaxPoints()).thenReturn(301);
	}

	@Test
	@DisplayName("Tirada Normal")
	void tirar() {

		player.setPuntos(0);
		player.setTiradas(tiradasMock);
		player.tirar();

		assertNotEquals(0, player.getPuntos());
		assertEquals(2, player.getIdTirada());
		verify(tiradasMock, times(1)).add(any(Tirada.class));
	}

	@Test
	@DisplayName("Exceed max Points")
	void tirarExceedMaxPoints() {

		player.setPuntos(354);
		player.setTiradas(tiradasMock);
		player.tirar();

		assertEquals(2, player.getIdTirada());
		verify(tiradasMock, times(0)).add(any(Tirada.class));
	}

}