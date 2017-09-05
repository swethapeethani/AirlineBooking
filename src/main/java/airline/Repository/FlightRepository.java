package airline.Repository;

import airline.Model.Flight;
import airline.Model.FlightInformation;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights(){

        flights.add(new Flight("Spice Jet", new FlightInformation("HYD", "PUN", 10, java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER, 6)))));
        flights.add(new Flight("Airbus A319 V2", new FlightInformation("HYD","PUN", 20,java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER,6)))));
        flights.add(new Flight("Airbus A321", new FlightInformation("BLR", "CHN", 5, java.util.Optional.of(LocalDate.of(2017, Month.SEPTEMBER,10)))));
/*
        flights.add(new Flight("Spice Jet", new FlightInformation("HYD", "PUN", 10, LocalDate.of(2017, Month.SEPTEMBER,6))));
        flights.add(new Flight("Airbus A319 V2", new FlightInformation("HYD","PUN", 20,LocalDate.of(2017, Month.SEPTEMBER,6))));
        flights.add(new Flight("Airbus A321", new FlightInformation("BLR", "CHN", 5, LocalDate.of(2017, Month.SEPTEMBER,10))));
 */
        return flights;
    }

}
