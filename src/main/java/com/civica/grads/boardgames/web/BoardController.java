package com.civica.grads.boardgames.web;

import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    
    @Autowired
    private Board board;

    
    @RequestMapping("/json")
    Board getBoard() throws GameException {
        

        return board ;
    }
    
    

}