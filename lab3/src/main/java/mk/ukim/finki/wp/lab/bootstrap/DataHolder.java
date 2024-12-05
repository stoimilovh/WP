package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static final List<Event> events=new ArrayList<>(10);
    public static final List<Location> locations=new ArrayList<>(10);
    public DataHolder() {
        //Locations
        locations.add(new Location("Gradski Park", "Karpos", "100000", "Park"));
        locations.add(new Location("Boris Trajkovski", "Karpos", "10000", "Sala"));
        locations.add(new Location("Jane Sandanski", "Aerodrom", "10000", "Sala"));
        locations.add(new Location("Arena Filip II", "Centar", "100000", "Arena"));
        locations.add(new Location("Univerzalna Sala", "Karpos", "3000", "Sala"));
        locations.add(new Location("MNT", "Centar", "1000", "Teatar"));

        //Events
        events.add(new Event((long) (Math.random()*100), "Karolina Gocheva", "Koncert", 10, locations.get(1), 100));
        events.add(new Event((long) (Math.random()*100),"Tose Proeski", "Festival", 10, locations.get(5), 100));
        events.add(new Event((long) (Math.random()*100),"Vlatko Stefanovski", "Nastap", 9, locations.get(1), 100));
        events.add(new Event((long) (Math.random()*100),"The Rolling Stones", "Koncert", 10, locations.get(3), 100));
        events.add(new Event((long) (Math.random()*100),"Pink Floyd", "Nastap", 10, locations.get(2), 100));
        events.add(new Event((long) (Math.random()*100),"Bijelo Dugme", "Koncert", 9, locations.get(5), 100));
        events.add(new Event((long) (Math.random()*100),"Riblja Corba", "Koncert", 10, locations.get(1), 100));
        events.add(new Event((long) (Math.random()*100),"Crvena Jabuka", "Festival", 7, locations.get(4), 100));
        events.add(new Event((long) (Math.random()*100),"Galija", "Festival", 8, locations.get(3), 100));
        events.add(new Event((long) (Math.random()*100),"Prljavo Kazalista", "Festival", 10, locations.get(2), 100));
    }
}
