package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.enums.Difficulty;
import com.civica.grads.boardgames.exceptions.GameSetupException;
import com.civica.grads.boardgames.model.GameBoard;
import com.civica.grads.boardgames.model.Game;
import com.civica.grads.boardgames.model.draughts.DraughtsGame;
import com.civica.grads.boardgames.model.draughts.DraughtsGame.BoardType;
import com.civica.grads.boardgames.model.player.AIPlayer;
import com.civica.grads.boardgames.model.player.HumanPlayer;
import com.civica.grads.boardgames.model.player.Player;
import com.civica.grads.boardgames.model.player.draughts.DraughtsAIPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class GameSetupMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameSetupMicroServiceApplication.class, args);
    }
    

    @Bean
    Game defaultDraughtsGame() throws GameSetupException
    {
    	Player whitePlayer = new HumanPlayer("Ryan");
    	Player blackPlayer = new DraughtsAIPlayer("Hamza",Difficulty.EASY);
    	Player[] players= {whitePlayer , blackPlayer};
    	
    	return new DraughtsGame(BoardType.BRAZILIAN,players);
    	
    
    			
    }
    
}
