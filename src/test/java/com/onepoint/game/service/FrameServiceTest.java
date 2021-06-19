package com.onepoint.game.service;

import org.junit.jupiter.api.Test;

import com.onepoint.game.domain.player.Player;
import com.onepoint.game.exception.InvalidSequenceException;

class FrameServiceTest {

	@Test
	void testPlayFrame() throws InvalidSequenceException {
		FrameService service = new FrameService();
		Player player = new Player("Len");
		service.playFrame(player);

	}

}
