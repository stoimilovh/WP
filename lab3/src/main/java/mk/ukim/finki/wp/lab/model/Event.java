package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    private double popularityScore;
    @ManyToOne
    private Location location;
    private int numberTickets;

    public Event(Long Id, String name, String description, double popularityScore, Location location, int numberTickets) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
        this.numberTickets = numberTickets;
    }

    public Event() {

    }

    public int getNumberTickets() {
        return numberTickets;
    }

    public void setNumberTickets(int num) {
        this.numberTickets = this.numberTickets - num;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
