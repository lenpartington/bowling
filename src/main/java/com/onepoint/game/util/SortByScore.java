package com.onepoint.game.util;

import java.util.Comparator;

import com.onepoint.game.domain.player.Player;

public class SortByScore implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o2.getPlayerScore() - o1.getPlayerScore();
	}

}
