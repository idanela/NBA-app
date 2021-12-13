package com.idanElazar.nba.Collage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "collages")
public class CollageController {

    private final CollageService collageService;

    @Autowired
    public CollageController(CollageService collageService) {
        this.collageService = collageService;
    }


    @GetMapping
    public List<Collage> getCollages()
    {
        return this.collageService.getInstitutions();
    }
    @GetMapping(path = "{collageName}")
    public Collage getPlayersList(@PathVariable ("collageName") String name)
    {
        return collageService.getInstitution(name);
    }

    @PostMapping
    public void addCollage(@RequestBody Collage collage)
    {
        this.collageService.addInstitution(collage);
    }

    @DeleteMapping(path="{collageId}")
    public void deleteCollage(@PathVariable ("collageId") String collageId)
    {
        this.collageService.DeleteInstitution(collageId);
    }

    @PutMapping(path = "{collageId}")
    public void updateCollage(
            @PathVariable("collageId") String collageId,
             @RequestParam(required = true) boolean add,
            @RequestParam(required = false) List<String> toUpdate)
    {
        this.collageService.updateInstitution(collageId,add,toUpdate);
    }
}
