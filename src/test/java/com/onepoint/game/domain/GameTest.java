package com.onepoint.game.domain;

import org.junit.jupiter.api.Test;

import com.onepoint.game.domain.player.Player;

class GameTest {

	@Test
	void testAddPlayer() {
		Game game = new Game();
		assert game.getPlayers().size() == 0;
		Player player = new Player();
		game.addPlayers(player);
		assert game.getPlayers().size() == 1;
	}

}
