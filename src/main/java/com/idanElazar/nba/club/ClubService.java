package com.idanElazar.nba.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getMultiClubs()
    {
        return this.clubRepository.findAll();
    }


    public Club getClub(String clubId) {
        return this.clubRepository.findById(clubId).orElseThrow(()->new IllegalStateException("Club with the abbreviation of "+clubId+" does not exists"));
    }

    public void addNewClub(Club club) {
        if(!clubRepository.existsById(club.getAbbreviation()))
        {
            this.clubRepository.save(club);
        }
        else
        {
            throw new IllegalStateException("A club with the abbreviation "+club.getAbbreviation()+" already exists");
        }
    }

    public void deleteClub(String clubId) {
       if(!clubRepository.existsById(clubId))
       {
           throw new IllegalStateException("A club with the abbreviation "+clubId+" not exists");
       }

       clubRepository.deleteById(clubId);
    }

    public void updateClub(String clubId, String clubName, String simpleName, String location) {
        Club club = clubRepository.findById(clubId).orElseThrow(()->new IllegalStateException("club with te abbreviation "+ clubId+ " does not exists"));
        boolean hasChanged = false;
        if(clubName!=null&& !clubName.isEmpty()&& !clubName.equals(club.getTeamName()))
        {
            club.setTeamName(clubName);
            hasChanged = true;
        }
        if(simpleName!= null && !simpleName.isEmpty() && !simpleName.equals(club.getSimpleName()))
        {
            club.setSimpleName(simpleName);
            hasChanged = true;

        }
        if(location!=null && !location.isEmpty() && !location.equals(club.getSimpleName()))
        {
            club.setLocation(location);
            hasChanged = true;
        }

        if(hasChanged)
        {
            clubRepository.save(club);
        }
    }
}
