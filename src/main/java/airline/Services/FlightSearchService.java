package airline.Services;

import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {

    public FlightSearchService() {

    }

    private FlightRepository flightRepository = new FlightRepository();

    private Predicate<Flight> isFlightAvailableForSourceDestination(String source, String destination){

        return x -> x.isFlightAvailableForSourceDestination(source, destination);

    }

    private Predicate<Flight> isFlightAvailableForDepartureDate( LocalDate departureDate) {

        return x -> x.isFlightAvailableForDepartureDate(departureDate);

    }

    private Predicate<Flight> isFlightAvailableForTravelClass(String travelClassName, int numberOfPassengers){

        return x -> x.isFlightAvailableForTravelClass(travelClassName, numberOfPassengers);

    }


    public List<Flight> search(SearchCriteria searchCriteria) {

        List<Flight> flights = flightRepository.getFlights();

        return flights.stream()
                .filter(isFlightAvailableForSourceDestination(searchCriteria.getSource(),searchCriteria.getDestination()))
                .filter(isFlightAvailableForDepartureDate(searchCriteria.getParsedDate()))
                .filter(isFlightAvailableForTravelClass(searchCriteria.getSeatingClass(),searchCriteria.getNumberOfPassengers()))
                .collect(Collectors.toList());


    }

}
