package com.idanElazar.nba.club;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Document(collection = "teams")
public class Club {

    @Id
    private String abbreviation;
    private String teamName;
    private String simpleName;
    private String location;
    private String conference;

    public Club(String abbreviation, String teamName, String simpleName, String location,String conference) {
        this.abbreviation = abbreviation;
        this.teamName = teamName;
        this.simpleName = simpleName;
        this.location = location;
        this.conference = conference;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(abbreviation, club.abbreviation) &&
                Objects.equals(teamName, club.teamName) &&
                Objects.equals(simpleName, club.simpleName) &&
                Objects.equals(location, club.location) &&
                Objects.equals(conference, club.conference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, teamName, simpleName, location, conference);
    }

    @Override
    public String toString() {
        return "Club{" +
                "abbreviation='" + abbreviation + '\'' +
                ", teamName='" + teamName + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", location='" + location + '\'' +
                ", conference='" + conference + '\'' +
                '}';
    }
}
