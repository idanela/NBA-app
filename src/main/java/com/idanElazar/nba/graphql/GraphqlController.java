package com.idanElazar.nba.graphql;

import com.idanElazar.nba.player.BasketballPlayer;
import com.idanElazar.nba.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphqlController {

    private final PlayerService playerService;

    @Autowired
    public GraphqlController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    List<BasketballPlayer> players()
    {
        return playerService.getPlayersList() ;
    }

    @QueryMapping
    BasketballPlayer playerByName(@Argument String name)
    {
        return playerService.getPlayer(name);
    }

    @MutationMapping
   String changeWeight (@Argument String name,@Argument  String weight)
    {
        BasketballPlayer player = playerService.getPlayer(name);
        Integer newWeight = Integer.valueOf(player.getWeight())+ Integer.valueOf(weight);
        playerService.updatePlayer(player.getName(),null,newWeight.toString(),null,null,null,null);
        return newWeight.toString();
    }








}
