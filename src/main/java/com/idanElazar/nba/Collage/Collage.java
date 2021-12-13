package com.idanElazar.nba.Collage;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "collages")
public class Collage {

    @Id
    private String name;
    private List<String> sports;

    public Collage(String name, List<String> sports) {
        this.name = name;
        this.sports = sports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    public void addSport(String sport)
    {
        this.sports.add(sport);
    }

    public void removeSport(String sport) {
        this.sports.remove(sport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collage collage = (Collage) o;
        return Objects.equals(name, collage.name) &&
                Objects.equals(sports, collage.sports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sports);
    }

    @Override
    public String toString() {
        return "Collage{" +
                "name='" + name + '\'' +
                ", sports=" + sports +
                '}';
    }


}
