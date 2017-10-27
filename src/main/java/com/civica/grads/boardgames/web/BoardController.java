
package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.enums.Difficulty;
import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.exceptions.GameSetupException;
import com.civica.grads.boardgames.interfaces.Board;
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
    Board createBoard(@RequestParam String gameType) throws GameException {

        return createBoard(BoardType.valueOf(gameType));
    }

    
    
    
    private Board createBoard(BoardType boardType) throws GameSetupException {
        return createGame(boardType).getBoard();
    }




    private Game createGame(BoardType boardType) throws GameSetupException {
        Player whitePlayer = new HumanPlayer("Ryan");
        Player blackPlayer = new DraughtsAIPlayer("Hamza", Difficulty.EASY);
        Player[] players = {whitePlayer, blackPlayer };

        return new DraughtsGame(boardType, players);
    }

}
