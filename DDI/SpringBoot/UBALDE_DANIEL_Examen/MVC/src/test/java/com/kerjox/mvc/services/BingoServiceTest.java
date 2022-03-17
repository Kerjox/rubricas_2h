package com.kerjox.mvc.services;

import com.kerjox.mvc.entities.Carton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test-application.properties")
class BingoServiceTest {

	@Value("${bingo.number.balls}")
	private Integer totalBalls;

	@Spy
	private BingoService service;

	@Spy
	private HashSet<Integer> numerosSacadosSpy;

	@Mock
	private HashSet<Integer> numerosAcertadosMock;

	@Mock
	private Carton cartonMock;

	@BeforeEach
	void setUp() {

		this.service.setTotalBolas(totalBalls);
		this.service.setCarton(cartonMock);
		this.service.setNumerosSacados(numerosSacadosSpy);

		when(cartonMock.getNumeros()).thenReturn(numerosAcertadosMock);

	}

	@Test
	void autoPlay() {

		service.setCarton(new Carton());
		assertEquals(0, service.getCarton().getNumerosAcertados());
		service.autoPlay();
		assertEquals(15, service.getCarton().getNumerosAcertados());
	}

	@Test
	void play() {

		assertFalse(service.isStop());
		doNothing().when(service).checkWin();
		doNothing().when(cartonMock).aumentarNumerosAcertados();

		when(numerosAcertadosMock.contains(any(Integer.class))).thenReturn(false);
		service.play();
		verify(cartonMock, times(0)).aumentarNumerosAcertados();
		verify(service, times(0)).checkWin();

		when(numerosAcertadosMock.contains(any(Integer.class))).thenReturn(true);
		service.play();
		verify(cartonMock, times(1)).aumentarNumerosAcertados();
		verify(service, times(1)).checkWin();
	}

	@Test
	void playWhenStop() {

		service.setStop(true);
		service.play();
		verify(service, times(0)).sacarBola();
	}

	@Test
	void checkWin() {

		assertFalse(service.isStop());
		service.checkWin();
		assertFalse(service.isStop());

		when(cartonMock.getNumerosAcertados()).thenReturn(15);
		service.checkWin();
		assertTrue(service.isStop());
	}

	@Test
	void sacarBola() {

		assertEquals(0, service.getNumerosSacados().size());
		Integer bola1 = service.sacarBola();
		assertEquals(1, service.getNumerosSacados().size());
		verify(numerosSacadosSpy, times(1)).add(any(Integer.class));

		Integer bola2 = service.sacarBola();
		assertEquals(2, service.getNumerosSacados().size());
		verify(numerosSacadosSpy, atLeast(2)).add(any(Integer.class));
		assertNotEquals(bola1, bola2);
	}

	@Test
	void noBolaIsRepeted() {

		assertEquals(0, service.getNumerosSacados().size());

		for (int i = 0; i < totalBalls; i++) {

			service.sacarBola();
		}

		verify(numerosSacadosSpy, atLeast(110)).add(any(Integer.class));
		assertEquals(totalBalls, service.getNumerosSacados().size());

	}
}