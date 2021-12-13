package com.idanElazar.nba.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "players")
public class PlayerController{

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<BasketballPlayer> getPlayersList()
    {
        return playerService.getPlayersList();
    }

    @GetMapping(path = "{playerName}")
    public BasketballPlayer getPlayersList(@PathVariable ("playerName") String name)
    {
        return playerService.getPlayer(name);
    }

    @PostMapping
    public void savePlayer(@RequestBody BasketballPlayer basketballPlayer)
    {
        playerService.addPlayer(basketballPlayer);
    }

    @DeleteMapping(path = "{playerName}")
    public void deletePlayer(@PathVariable("playerName") String name) // get variable from path
    {
        playerService.deletePlayer(name);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") String name, // get variable from path
            @RequestParam(required = false) String height,
            @RequestParam(required = false) String weight,
            @RequestParam(required = false) String collage,
            @RequestParam(required = false) String born,
            @RequestParam(required = false) String birth_city,
            @RequestParam(required = false) String birth_state)
    {
        playerService.updatePlayer(name,height,weight,collage,born,birth_city,birth_state);
    }

}
