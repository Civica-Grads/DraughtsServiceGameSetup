
package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.enums.Difficulty;
import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.exceptions.GameSetupException;
import com.civica.grads.boardgames.model.Board;
import com.civica.grads.boardgames.model.Game;
import com.civica.grads.boardgames.model.draughts.DraughtsGame;
import com.civica.grads.boardgames.model.draughts.DraughtsGame.BoardType;
import com.civica.grads.boardgames.model.player.HumanPlayer;
import com.civica.grads.boardgames.model.player.Player;
import com.civica.grads.boardgames.model.player.draughts.DraughtsAIPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    //    @Autowired
    //    private Board board;

    @RequestMapping("/create")

    private Game createGame(@RequestParam String gameType,@RequestParam String humanPlayer,@RequestParam String AIPlayer,
    		@RequestParam String AIDifficulty) throws GameSetupException {
    	Player whitePlayer = new HumanPlayer(humanPlayer);
        Player blackPlayer = new DraughtsAIPlayer(AIPlayer, Difficulty.valueOf(AIDifficulty));
        Player[] players = {whitePlayer, blackPlayer };
    	
    	
    	
        return new DraughtsGame(BoardType.valueOf(gameType), players);
    }

}
