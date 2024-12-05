package mk.ukim.finki.wp.lab.service;
import  mk.ukim.finki.wp.lab.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
        List<Event> listAll();
        List<Event> searchEvents(String text);
        Optional<Event> findById(Long Id);

        Optional<Event> save(String name, String description, double popularityScore, Long locationId, int numberTickets);

        void deleteById(Long id);

        public void minusTickets(int numTickets, Long id);
}
