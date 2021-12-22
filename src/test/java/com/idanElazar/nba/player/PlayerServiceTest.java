package com.idanElazar.nba.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayersRepository playersRepository;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerService =new BasketBallPlayerService(playersRepository);
    }

    @AfterEach
    void tearDown() {
        if(playersRepository.existsByName("Idan Elazar"))
        {
            playersRepository.deleteByName("Idan Elazar");
        }
    }

    @Test
    void canGetPlayersList() {
        //when
        playerService.getPlayersList();
        //then
        verify(playersRepository).findAll() ;


    }

    @Test
    void canAddPlayer() {
        //given
        BasketballPlayer player = new BasketballPlayer(
                "7","Idan Elazar","1.83","90","some collage","1993","Ramat-Gan","Israel",null);
        //when
        playerService.addPlayer(player);
        //then
        ArgumentCaptor<BasketballPlayer> basketballPlayerArgumentCaptor =
                ArgumentCaptor.forClass(BasketballPlayer.class);
        //verify the repository was called with save. and we capture the aactual player that was passed.
        verify(playersRepository).save(basketballPlayerArgumentCaptor.capture());

        BasketballPlayer capturedPlayer = basketballPlayerArgumentCaptor.getValue();
        assertThat(capturedPlayer).isEqualTo(player);
    }

    @Test
    void willThrowWhenPlayerNameExists() {
        //given
        BasketballPlayer player = new BasketballPlayer(
                "7","Idan Elazar","1.83","90","some collage","1993","Ramat-Gan","Israel",null);
        given(playersRepository.existsByName(player.getName())).willReturn(true);
        //when
        //then
        assertThatThrownBy(()->playerService.addPlayer(player)).isInstanceOf(IllegalStateException.class).
                hasMessageContaining("Player with name "+player.getName() + " already exists");

        verify(playersRepository,never()).save(any());
    }

    @Test
    @Disabled
    void deletePlayer() {
    }
}