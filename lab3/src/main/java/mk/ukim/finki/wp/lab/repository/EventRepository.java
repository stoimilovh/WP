package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepository {

    public EventRepository() {

    }

    public List<Event> findAll() {
        return DataHolder.events.stream().toList();
    }

    public List<Event> searchEvents(String text){
        return DataHolder.events.stream().filter(event -> event.getName().contains(text)||event.getDescription().contains(text)).collect(Collectors.toList());
    }

    public Optional<Event> saveEvent(String name, String description, double popularityScore, Location location, int numberTickets){
        if (location == null) {
            throw new IllegalArgumentException();
        }
        Event event = new Event((long) (Math.random()*100), name, description, popularityScore, location, numberTickets);
        DataHolder.events.removeIf(event1 -> event1.getName().equals(name));
        DataHolder.events.add(event);
        return Optional.of(event);
    }

    public void deleteById(Long id) {
        DataHolder.events.removeIf(e -> e.getId().equals(id));
    }
    public void minusTickets(int tickets, Event minus){
        Event event = (Event) DataHolder.events.stream().filter(e -> e.getId().equals(minus.getId()));
        event.setNumberTickets(tickets);
    }
}
