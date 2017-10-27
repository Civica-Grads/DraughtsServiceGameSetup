package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.display.StringBufferBoardRenderer;
import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.model.Game;
import com.civica.grads.boardgames.model.GameBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameSetupController {

    
    @Autowired
    private Game defaultDraughtsGame;

    
    @RequestMapping("/")
    @ResponseBody
    String renderBoard() throws GameException {
        
        StringBufferBoardRenderer boardRender = new StringBufferBoardRenderer();
        boardRender.render((GameBoard) defaultDraughtsGame.getBoard());
        
        String pageHtml = String.format("<html><body><pre>%s</pre></body></html>", boardRender.asString());
        
        return pageHtml ;
    }
    
  
}