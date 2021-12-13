package com.idanElazar.nba.club;

import com.idanElazar.nba.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "clubs")
public class ClubController {

    private final ClubService clubService;
    private final PlayerService playerService;

    @Autowired
    public ClubController(ClubService clubService,PlayerService playerService) {
        this.clubService = clubService;
        this.playerService = playerService;
    }

    @GetMapping
    public List<Club> getMultiClubs()
    {
        return clubService.getMultiClubs();
    }

    @GetMapping(path = "{clubId}")
    public Club getClub(@PathVariable("clubId") String clubId)
    {
        return clubService.getClub(clubId);
    }
    @PostMapping
    public void addNewClub(@RequestBody Club club)
    {
        clubService.addNewClub(club);
    }

    @DeleteMapping(path = "{clubId}")
    public void deleteClub(@PathVariable("clubId") String clubId)
    {
        clubService.deleteClub(clubId);
    }

    @PutMapping(path = "{clubId}")
    public void updateClub(@PathVariable("clubId") String clubId,
                           @RequestParam (required = false)String clubName,
                           @RequestParam (required = false)String simpleName,
                           @RequestParam (required = false)String location)
    {
        Club club = clubService.getClub(clubId);
        playerService.updateAllPlayersInTheClub(club,clubName,simpleName,location);
        clubService.updateClub(clubId,clubName,simpleName,location);
    }
}
