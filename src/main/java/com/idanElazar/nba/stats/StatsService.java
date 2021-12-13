package com.idanElazar.nba.stats;

import com.idanElazar.nba.club.Club;
import com.idanElazar.nba.club.ClubService;
import com.idanElazar.nba.player.BasketballPlayer;
import com.idanElazar.nba.player.BasketBallPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private final BasketBallPlayerService basketBallPlayerService;
    private final ClubService clubService;

    @Autowired
    public StatsService(BasketBallPlayerService basketBallPlayerService, ClubService clubService) {
        this.basketBallPlayerService = basketBallPlayerService;
        this.clubService = clubService;
    }

    public List<BasketballPlayer> getPlayerWithSameTeam(String clubId) {
          Club club = clubService.getClub(clubId);
        List<BasketballPlayer> players = basketBallPlayerService.getPlayersList();
        return players.stream().filter((player)->player.getClub().equals(club)).collect(Collectors.toList());
    }

    public List<BasketballPlayer> getSameConferencePlayers(String conference) {
        String checkedConference = conference.toLowerCase();
        if(!checkedConference.equals("west") && !checkedConference.equals("east"))
        {
            throw new IllegalStateException("There are only to conferences: east and west.");
        }
        List<Club> sameConferenceClubs = clubService.getMultiClubs().stream().filter((club -> club.getConference().equals(checkedConference))).collect(Collectors.toList());
        return basketBallPlayerService.getPlayersList().stream().filter(basketballPlayer -> sameConferenceClubs.contains(basketballPlayer.getClub())).collect(Collectors.toList());
    }
}
