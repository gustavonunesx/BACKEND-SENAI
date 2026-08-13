package com.steam.games.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.steam.games.dto.GameDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/games")
public class GameController {

    private Map<Long, GameDto> gameMap = new HashMap<>();
    private Long nextId = 1L;

    @GetMapping()
    public List<GameDto> getGames() {
        return new ArrayList<>(gameMap.values());
    }

    @PostMapping()
    public GameDto createGame(@RequestBody GameDto gameDto) {
        gameDto.setId(nextId++);
        gameMap.put(gameDto.getId(), gameDto);
        return gameDto;
    }
    

  
    
    

    
}
