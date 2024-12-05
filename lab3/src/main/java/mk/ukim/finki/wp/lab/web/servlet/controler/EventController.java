package mk.ukim.finki.wp.lab.web.servlet.controler;


import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.service.EventService;
import mk.ukim.finki.wp.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping("")
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        List<Event> events = this.eventService.listAll();
        model.addAttribute("events", this.eventService.listAll());
        return "listEvents";
    }
    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "add-event";
    }
    @PostMapping("/add")
    public String saveEvent(@RequestParam String name, @RequestParam String description, @RequestParam double popularityScore,
                            @RequestParam Long locationId, @RequestParam int numberTickets){
        this.eventService.save(name, description, popularityScore, locationId, numberTickets);
        return "redirect:/events";

    }
    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model) {
        if (eventService.findById(id).stream().findFirst().isPresent()) {
            Event event = eventService.findById(id).stream().findFirst().get();
            List<Location> locations = locationService.findAll();
            model.addAttribute("locations", locations);
            model.addAttribute("event", event);
            return "add-event";
        }
        return "redirect:/events?error=Event not found";
    }
    @PostMapping("/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId, @RequestParam int numberTickets){
        if(this.eventService.findById(eventId).stream().findFirst().isPresent()){
            Event event = this.eventService.findById(eventId).stream().findFirst().get();
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            event.setLocation(this.locationService.findById(locationId).stream().findFirst().get());
            eventService.save(name, description, popularityScore, locationId, numberTickets);
        }
        return "redirect:/events";
    }
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        if(eventService.findById(id).isPresent()){
            this.eventService.deleteById(id);
            return "redirect:/events";
        }
        else{
            return "redirect:/events?error=Event not found";
        }
    }
}
