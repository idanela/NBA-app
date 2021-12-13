package com.idanElazar.nba.player;

import com.idanElazar.nba.club.Club;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlayersRepository extends MongoRepository<BasketballPlayer,String> {
    Optional<BasketballPlayer> findPlayerByName(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
}
