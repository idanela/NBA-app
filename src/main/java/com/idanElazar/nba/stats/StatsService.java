package com.idanElazar.nba.stats;

import com.idanElazar.nba.club.Club;
import com.idanElazar.nba.club.ClubService;
import com.idanElazar.nba.player.BasketballPlayer;
import com.idanElazar.nba.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private final PlayerService playerService;
    private final ClubService clubService;

    @Autowired
    public StatsService(PlayerService playerService, ClubService clubService) {
        this.playerService = playerService;
        this.clubService = clubService;
    }

    public List<BasketballPlayer> getPlayerWithSameTeam(String clubId) {
          Club club = clubService.getClub(clubId);
        List<BasketballPlayer> players = playerService.getPlayersList();
        return players.stream().filter((player)->player.getClub().equals(club)).collect(Collectors.toList());
    }

    public List<BasketballPlayer> getSameConferencePlayers(String conference) {
        String checkedConference = conference.toLowerCase();
        if(!checkedConference.equals("west") && !checkedConference.equals("east"))
        {
            throw new IllegalStateException("There are only to conferences: east and west.");
        }
        List<Club> sameConferenceClubs = clubService.getMultiClubs().stream().filter((club -> club.getConference().equals(checkedConference))).collect(Collectors.toList());
        return playerService.getPlayersList().stream().filter(player -> sameConferenceClubs.contains(player.getClub())).collect(Collectors.toList());
    }
}
