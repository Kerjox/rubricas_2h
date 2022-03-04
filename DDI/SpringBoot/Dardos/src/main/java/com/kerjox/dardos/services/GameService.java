package com.kerjox.dardos.services;

import com.kerjox.dardos.entities.Player;
import com.kerjox.dardos.modes.Mode;
import jdk.jfr.Unsigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

	@Autowired
	private Mode mode;
	@Value("${app.numPlayers}")
	@Unsigned
	private Integer numPlayers;
	private Integer activePlayer;
	private List<Player> players;

	public void setNumPlayers(Integer numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Integer getIndexActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Integer activePlayer) {
		this.activePlayer = activePlayer;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void initGame() {

		if (numPlayers <= 0) {

			throw new RuntimeException("Players can not be 0 ot below 0");
		}

		initPlayers();

		this.activePlayer = 0;
	}

	protected void initPlayers() {

		for (int i = 1; i <= numPlayers; i++) {

			players.add(new Player("Player " + i, mode));
		}
	}

	public void play(Player player) {

		player.tirar();

		activePlayer++;
		if (activePlayer == players.size()) {

			activePlayer = 0;
		}
	}

	public Player getActivePlayer() {

		return players.get(activePlayer);
	}
}
