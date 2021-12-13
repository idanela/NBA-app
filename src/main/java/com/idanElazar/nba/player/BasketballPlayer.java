package com.idanElazar.nba.player;

import com.idanElazar.nba.club.Club;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Document(collection = "players")
public class BasketballPlayer {
    @Id
    private String id;
    private String name;
    private String height;
    private String weight;
    private String collage;
    private String born;
    private String birth_city;
    private String birth_state;
    private Club club;

    public BasketballPlayer(String id, String name, String height, String weight, String collage, String born, String birth_city, String birth_state,Club club) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.collage = collage;
        this.born = born;
        this.birth_city = birth_city;
        this.birth_state = birth_state;
        this.club = club;
    }

    public BasketballPlayer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getBirth_city() {
        return birth_city;
    }

    public void setBirth_city(String birth_city) {
        this.birth_city = birth_city;
    }

    public String getBirth_state() {
        return birth_state;
    }

    public void setBirth_state(String birth_state) {
        this.birth_state = birth_state;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketballPlayer that = (BasketballPlayer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(collage, that.collage) &&
                Objects.equals(born, that.born) &&
                Objects.equals(birth_city, that.birth_city) &&
                Objects.equals(birth_state, that.birth_state) &&
                Objects.equals(club, that.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height, weight, collage, born, birth_city, birth_state, club);
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", collage='" + collage + '\'' +
                ", born='" + born + '\'' +
                ", birth_city='" + birth_city + '\'' +
                ", birth_state='" + birth_state + '\'' +
                ", club=" + club +
                '}';
    }

    public boolean checkAndSetPlayersProperties
            (String weight, String height, String collage, String born, String birth_city, String birth_state) {
        boolean hasChanged = false;
        if (height != null && height.matches("[0-9]+"))
        {
            this.setHeight(height);
            hasChanged = true;
        }
        if (weight != null && weight.matches("[0-9]+"))
        {
            this.setWeight(weight);
            hasChanged = true;
        }
        if(collage != null &&!collage.isEmpty())
        {
            this.setCollage(collage);
            hasChanged = true;
        }
        if (born != null && born.matches("[0-9]+"))
        {
            this.setBorn(born);
            hasChanged = true;
        }
        if(birth_city != null &&!birth_city.isEmpty())
        {
            this.setBirth_city(birth_city);
            hasChanged = true;
        }
        if(birth_state != null && !birth_state.isEmpty())
        {
            this.setBirth_state(birth_state);
            hasChanged = true;
        }
        return hasChanged;
    }
}
