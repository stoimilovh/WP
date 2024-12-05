package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;
    @OneToMany(mappedBy = "location")
    private List<Event> eventList;

    public Location(String name, String address, String capacity, String description) {   //, List<Event> eventList
        this.id = (long) (Math.random()*100);
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        //this.eventList = eventList;
    }

    public Location() {

    }
}
