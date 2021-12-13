package com.idanElazar.nba.player;

import com.idanElazar.nba.club.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketBallPlayerService implements PlayerService {
    final private PlayersRepository playerRepository;

    @Autowired
    public BasketBallPlayerService(PlayersRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<BasketballPlayer> getPlayersList() {
        return playerRepository.findAll();
    }

    @Override
    public BasketballPlayer getPlayer(String name) {
        BasketballPlayer basketballPlayerToReturn = playerRepository.findPlayerByName(name).orElseThrow(()->new IllegalStateException("Player with the name: "+ name + " Does not exists."));

        return basketballPlayerToReturn;
    }

    @Override
    public void addPlayer(BasketballPlayer basketballPlayer) {
        playerRepository.save(basketballPlayer);
    }

    @Override
    public  void updatePlayer
            (String name, String height, String weight,
             String collage, String born, String birth_city,
             String birth_state) {
        BasketballPlayer basketballPlayer = playerRepository.findPlayerByName(name).orElseThrow(()->new IllegalStateException("Player with the name: "+ name + " Does not exists."));
        boolean hasChanged = false;
        hasChanged = basketballPlayer.checkAndSetPlayersProperties(weight,height,collage,born,birth_city,birth_state);
        if(hasChanged)
        {
            playerRepository.save(basketballPlayer);
        }
    }

    @Override
    public void deletePlayer(String name) {

        if(!playerRepository.existsByName(name))
        {
            throw new IllegalStateException("Player with the name: "+ name + " Does not exists.");
        }

        this.playerRepository.deleteByName(name);
    }

    @Override
    public void updateAllPlayersInTheClub(Club club, String clubName, String simpleName, String location) {
       List<BasketballPlayer> players = playerRepository.findAll().stream().filter(player->player.getClub().getAbbreviation().equals(club.getAbbreviation())).collect(Collectors.toList());
       boolean hasChanged = false;
       for(BasketballPlayer player:players)
       {
           if(clubName!=null && !clubName.isEmpty() && !clubName.equals(club.getTeamName())) {
               player.getClub().setTeamName(clubName);
               hasChanged = true;
           }
           if(simpleName!=null && !simpleName.isEmpty() && !simpleName.equals(club.getSimpleName())) {
               player.getClub().setSimpleName(simpleName);
               hasChanged = true;
           }
           if(location!=null && !location.isEmpty() && !location.equals(club.getLocation())) {
               player.getClub().setLocation(location);
               hasChanged = true;
           }
           if (hasChanged)
           {
               playerRepository.save(player); ///create duplicate for a reason.
           }
       }
    }

}
