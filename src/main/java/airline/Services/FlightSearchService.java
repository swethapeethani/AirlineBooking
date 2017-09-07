package airline.Services;

import airline.Model.Flight;
import airline.Model.FlightInformation;
import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import airline.Model.TravelClass;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class FlightSearchService {

    FlightInformation flightInformation;
    FlightRepository flightRepository;
    Flight flight1;
    TravelClass travelClass;

    public List<Flight> search(SearchCriteria searchCriteria){

        flightRepository = new FlightRepository();

        flight1 = new Flight();

        List<Flight> flights = flightRepository.getFlights();
        //System.out.println(" I am in Search Criteria");

        System.out.println(searchCriteria.getSource());
        System.out.println(searchCriteria.getDestination());
        System.out.println(searchCriteria.getParsedDate());
        System.out.println(searchCriteria.getDateString());
        //for(Flight fli : flights) {
         //   System.out.println(fli.getFlightInformation().getSource());
        //}
        return flights.stream()
                .filter(flight -> flight.getFlightInformation().getSource().equals(searchCriteria.getSource()))
                .filter(flight -> flight.getFlightInformation().getDestination().equals(searchCriteria.getDestination()))
                .filter(flight -> flight.getFlightInformation().getAvailableSeats() >= searchCriteria.getNumberOfPassengers())
                //.filter(flight -> flight.getFlightInformation().getDate().isEqual(searchCriteria.getDate()))
                //.filter(flight -> flight.getFlightInformation().getDate().isEqual(searchCriteria.getParsedDate()))
                .filter(flight -> flight.getFlightInformation().getDate().equals(searchCriteria.getParsedDate()))

                //.filter(flight -> flight.getFlightInformation().getTravelClassMap().containsKey())
                .collect(Collectors.toList());

    }

    public boolean checkSeatAvailabiltyByClass(Flight flight, SearchCriteria searchCriteria) {
        return flight.getFlightInformation().getSeatsByTravelClass(searchCriteria.getSeatingClass()) >= searchCriteria.getNumberOfPassengers();
    }

    /*
    <option th:each="SeatingClass : ${SeatingClass}"
                   th:value="${dropSeatingClass}"
                   th:text="${SeatingClass}">

           </option>
     */
}
