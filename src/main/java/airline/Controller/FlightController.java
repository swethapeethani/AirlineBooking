package airline.Controller;

import airline.Model.*;
import airline.Services.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import airline.Repository.CityRepository;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Controller
public class FlightController {

    @Autowired
    private FlightSearchService flightSearchService;

    private Flight flight;
    private SearchCriteria searchCriteria;

    @RequestMapping(value = {"/AirlineBooking", "/"}, method = RequestMethod.GET)
    public String vapasiAirlines(Model model) {

        CityRepository cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();

        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("Hyderabad", "Pune",1,
                LocalDate.of(2017, 9, 8),"Economy"));
        model.addAttribute("seatingClass", Arrays.asList(SeatingClass.values()));

        return "flightSearch";

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) {

        if(searchCriteria.getSource().isEmpty() || searchCriteria.getDestination().isEmpty() ) {
            model.addAttribute("error", "Invalid Source or Destination");
            return "flightSearch";
        }
        else {
            if(searchCriteria.getSeatingClass().isEmpty() || searchCriteria.getDepartureDate().equals(null)  ) {
                model.addAttribute("error", "Invalid date or Travel class");
                return "flightSearch";
            }

        }

            List<Flight> availableFlights = flightSearchService.search(searchCriteria);
            //System.out.println("size of available flights :" + availableFlights.size());
            model.addAttribute("searchResults", availableFlights);

            return "resultFlights";

    }
}
