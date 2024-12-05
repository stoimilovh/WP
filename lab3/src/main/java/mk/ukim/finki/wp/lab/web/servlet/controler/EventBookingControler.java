package mk.ukim.finki.wp.lab.web.servlet.controler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.service.EventBookingService;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingControler {
    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingControler(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @GetMapping
    private String getEventBookingPage(){
        return "bookingConfirmation";
    }
    @PostMapping
    private String bookEvent(@RequestParam String name, @RequestParam String event, @RequestParam Long id,
                             @RequestParam int numTickets, HttpServletRequest request){
        EventBooking booking = eventBookingService.placeBooking(event, name, request.getRemoteAddr(), numTickets);
        eventService.minusTickets(numTickets, id);
        return "redirect:/eventBooking";
    }
}
