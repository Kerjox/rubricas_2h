package com.kerjox.dardos.services;

import com.kerjox.dardos.entities.Player;
import com.kerjox.dardos.modes.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GameService {

	@Autowired
	private Mode mode;

	private int activePlayer;
	private LinkedList<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void initGame(int numPlayers) {

		this.players = initPlayers(numPlayers);
	}

	private LinkedList<Player> initPlayers(int numPlayers) {

		LinkedList<Player> players = new LinkedList<>();

		for (int i = 1; i <= numPlayers; i++) {

			players.add(new Player("Player " + i, mode));
		}

		this.activePlayer = 0;

		return players;
	}

	public void play() {

		Player player = players.get(activePlayer);

		player.tirar();
		if (player.isWinner()) return;

		activePlayer++;
		if (activePlayer > players.size() - 1) {

			activePlayer = 0;
		}

	}

	public Player getActivePlayer() {

		return players.get(activePlayer);
	}
}
