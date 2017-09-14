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
        SeatingClass seatingClass[] = SeatingClass.values();
        LocalDate today = LocalDate.now();

        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("Hyderabad", "Pune",1,
               LocalDate.of(2017, 9, 8),"Economy"));
        //model.addAttribute("searchCriteria", new SearchCriteria());
        model.addAttribute("seatingClass", seatingClass);
        //model.addAttribute("today", today);

        return "flightSearch";

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) {

        if(searchCriteria.getSource().isEmpty() || searchCriteria.getDestination().isEmpty() ) {
            model.addAttribute("error", "Invalid Source or Destination");
            return "flightSearch";
        }
        else {
            if(searchCriteria.getSeatingClass().isEmpty()) {
                model.addAttribute("error", "Select Travel class");
                return "flightSearch";
            }

        }

            List<Flight> availableFlights = flightSearchService.search(searchCriteria);
            model.addAttribute("searchResults", availableFlights);

            return "resultFlights";

    }
}
