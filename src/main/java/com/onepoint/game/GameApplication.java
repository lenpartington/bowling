package com.onepoint.game;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onepoint.game.domain.Game;
import com.onepoint.game.domain.ball.SequenceBall;
import com.onepoint.game.domain.player.Player;
import com.onepoint.game.exception.InvalidSequenceException;
import com.onepoint.game.service.GameService;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) throws InvalidSequenceException {
		Player mike = new Player("Mike");
		mike.setBall(new SequenceBall(args));
		Player john = new Player("John");
		GameService service = new GameService();
		Game game = service.startNewGame();
		service.addPlayer(john, game);
		service.addPlayer(mike, game);
		service.playGame(game);

	}

}
