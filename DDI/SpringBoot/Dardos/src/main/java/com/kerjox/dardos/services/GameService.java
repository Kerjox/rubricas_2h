package com.kerjox.dardos.services;

import com.kerjox.dardos.entities.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

	private int activePlayer;
	private List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void initGame(int numPlayers) {

		this.players = initPlayers(numPlayers);
	}

	private List<Player> initPlayers(int numPlayers) {

		List<Player> players = new ArrayList<>();

		for (int i = 1; i <= numPlayers; i++) {

			players.add(new Player("Player" + i));
		}

		this.activePlayer = 0;

		return players;
	}

	public boolean play() {

		Player player = players.get(activePlayer);

		if (activePlayer == players.size() - 1) {

			activePlayer = 0;
		}

		return player.tirar();
	}

	public Player getActivePlayer() {

		return players.get(activePlayer);
	}
}
