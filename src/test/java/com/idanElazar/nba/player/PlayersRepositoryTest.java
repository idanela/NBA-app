package com.idanElazar.nba.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataMongoTest
class PlayersRepositoryTest {

    @Autowired
    private PlayersRepository underTest;


    @AfterEach
    void tearDown() {
        if(underTest.existsByName("Idan Elazar"))
        {
            underTest.deleteByName("Idan Elazar");
        }
    }

    @Test
    void itShouldCheckIfPlayerExistsByName() {
        //given
        BasketballPlayer player = new BasketballPlayer(
                "7","Idan Elazar","1.83","90","some collage","1993","Ramat-Gan","Israel",null);

        underTest.save(player);
        //when
        boolean exists = underTest.existsByName("Idan Elazar");
        //then
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfPlayerNotExistsByName() {
        //when
        boolean exists = underTest.existsByName("Cristiano Ronaldo");
        //then
        assertThat(exists).isFalse();
    }
}