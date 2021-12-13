package com.idanElazar.nba.Collage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollageService {

    private final CollageRepository collageRepository;

    @Autowired
    public CollageService(CollageRepository collageRepository) {
        this.collageRepository = collageRepository;
    }

    public List<Collage> getInstitutions() {
        return collageRepository.findAll();
    }

    public Collage getInstitution(String name) {

        Collage collage = collageRepository.findById(name).orElseThrow(()->new IllegalStateException("Player with the name: "+ name + " Does not exists."));

        return collage;
    }

    public void addInstitution(Collage collage) {
        collageRepository.save(collage);
    }

    public void DeleteInstitution(String collageId) {
        Collage collage = collageRepository.findById(collageId).orElseThrow(()->new IllegalStateException("There is no collage called " + collageId));
        collageRepository.delete(collage);
    }

    public void updateInstitution(String collageId, boolean add, List<String> toUpdate) {
        Collage collage = collageRepository.findById(collageId).orElseThrow(()->new IllegalStateException("There is no collage called " + collageId));
        boolean isUpdated = false;
        List<String> collageSports = collage.getSports();
        if(add)
        {
            isUpdated = addSports(toUpdate, collage, collageSports);
        }
        else
        {
            isUpdated = removeSports(toUpdate, collage, collageSports);
        }

        if(isUpdated)
        {
            collageRepository.save(collage);
        }
    }

    private boolean removeSports(List<String> toUpdate, Collage collage, List<String> collageSports) {
       boolean isUpdated = false;
        for (String sport: toUpdate) {
            if(collageSports.contains(sport))
            {
                collage.removeSport(sport);
                isUpdated = true;
            }
        }
        return isUpdated;
    }

    private boolean addSports(List<String> toUpdate, Collage collage, List<String> collageSports) {
        boolean isUpdated = false;
        for (String sport: toUpdate) {
            if(!collageSports.contains(sport))
            {
                collage.addSport(sport);
                isUpdated = true;
            }
        }
        return isUpdated;
    }


}
