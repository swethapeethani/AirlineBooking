package airline.Repository;

import airline.Model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    FlightInformation flightInformation1 = new FlightInformation();
    //TravelClass travelClass1 = new TravelClass(100);

    public HashMap<String , TravelClass> travelClassMap1 = new HashMap<String , TravelClass>();
    public HashMap<String , TravelClass> travelClassMap2 = new HashMap<String , TravelClass>();
    public HashMap<String , TravelClass> travelClassMap3 = new HashMap<String , TravelClass>();




    public ArrayList<Flight> getFlights(){

        travelClassMap1.put("Economy",new TravelClass(100,80));
        travelClassMap1.put("First",new TravelClass(20,10));
        travelClassMap1.put("Business",new TravelClass(10,10));

        travelClassMap2.put("Economy",new TravelClass(100,80));
        travelClassMap2.put("First",new TravelClass(20,10));
        travelClassMap2.put("Business",new TravelClass(10,10));

        travelClassMap3.put("Economy",new TravelClass(100,80));
        travelClassMap3.put("First",new TravelClass(20,10));
        travelClassMap3.put("Business",new TravelClass(10,10));

        flights.add(new Flight("Spice Jet", new FlightInformation("HYD", "PUN", 100,
                java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER, 6)), travelClassMap1)));

        flights.add(new Flight("Airbus ", new FlightInformation("HYD","PUN", 150,
                java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER,6)), travelClassMap2)));

        flights.add(new Flight("Indigo", new FlightInformation("BLR", "CHN", 120,
                java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER,10)), travelClassMap3)));

        return flights;
    }

}
