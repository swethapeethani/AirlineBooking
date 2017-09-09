package airline.Services;

import airline.Model.Flight;

public class SeatAvailabilityService {
    FlightSearchService flightSearchService;

    public boolean seatAvailabiltyByClass(Flight flight, String className, int numberOfPassengers){

        if (flight.getAirplane().getTravelClassMap().containsKey(className) ){

            flight.setAvailableSeats(flight.getAirplane().getTravelClassMap().get(className).getAvailableSeats());
            return (flight.getAirplane().getTravelClassMap().get(className).getAvailableSeats() >= numberOfPassengers);

        }
        else
            return false;

    }

}
