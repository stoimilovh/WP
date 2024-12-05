package mk.ukim.finki.wp.lab.service.Impl;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.repository.LocationRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text){
        return eventRepository.searchEvents(text);
    }

    @Override
    public Optional<Event> findById(Long Id){
        return eventRepository.findAll().stream().filter(event -> event.getId().equals(Id)).findFirst();
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId, int numberTickets){
        Location location = this.locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found with ID: " + locationId));
        return this.eventRepository.saveEvent(name, description, popularityScore, location, numberTickets);
    }
    @Override
    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }

    @Override
    public void minusTickets(int numTickets, Long id){
        Event minus = eventRepository.findAll().stream().filter(event -> event.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Event Not Found"));
        //Event minus = this.eventRepository.findAll().stream().filter(event -> event.getName().equals(eventName)).findFirst().orElseThrow(() -> new RuntimeException("Event Not Found"));

        //return this.eventRepository.findAll().stream().filter(event -> event.getName().equals(eventName)).findFirst();

        eventRepository.minusTickets(numTickets, minus);
    }
}
