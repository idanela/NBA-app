package com.idanElazar.nba.stats;

import com.idanElazar.nba.player.BasketballPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stats")
public class StatsController {
    private  StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping(path = "{clubId}")
    public List<BasketballPlayer> getPlayersWithSameTeam(@PathVariable("clubId") String clubId)
    {
        return statsService.getPlayerWithSameTeam(clubId);
    }

    @GetMapping
    public List<BasketballPlayer> getSameConferencePlayers(@RequestParam(required = true) String conference )
    {
        return  statsService.getSameConferencePlayers(conference);
    }


}
