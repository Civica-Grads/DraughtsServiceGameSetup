package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.display.StringBufferBoardRenderer;
import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.model.Board;
import com.civica.grads.boardgames.model.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameSetupController {

    
    @Autowired
    private Game defaultDraughtsGame;

    
    @RequestMapping("/GameSetup")
    @ResponseBody
    String renderBoard() throws GameException {
        
        StringBufferBoardRenderer boardRender = new StringBufferBoardRenderer();
        boardRender.render(defaultDraughtsGame.getBoard());
        
        String pageHtml = String.format("<html><body><pre>%s</pre></body></html>", boardRender.asString());
        
        return pageHtml ;
    }
    
  
}