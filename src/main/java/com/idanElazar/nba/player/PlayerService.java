package com.idanElazar.nba.player;

import com.idanElazar.nba.club.Club;

import java.util.List;

public interface PlayerService {
    List<BasketballPlayer> getPlayersList();

    BasketballPlayer getPlayer(String name);

    void addPlayer(BasketballPlayer basketballPlayer);

    void updatePlayer
            (String name, String height, String weight,
             String collage, String born, String birth_city,
             String birth_state);

    void deletePlayer(String name);

    void updateAllPlayersInTheClub(Club clubId, String clubName, String simpleName, String location);
}
