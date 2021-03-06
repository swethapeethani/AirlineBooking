package airline.Controller;

import airline.Model.*;
import airline.Services.IFlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import airline.Repository.CityRepository;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class FlightController {

    @Autowired
    private IFlightSearchService IFlightSearchService;

    private Flight flight;
    private SearchCriteria searchCriteria;

    @RequestMapping(value = {"/AirlineBooking", "/"}, method = RequestMethod.GET)
    public String vapasiAirlines(Model model) {

        CityRepository cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        SeatingClass seatingClass[] = SeatingClass.values();

        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("HYD", "BLR",1,
               null,"Economy"));
        model.addAttribute("seatingClass", seatingClass);
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
            List<FlightView> availableFlights = IFlightSearchService.getFlightsView(searchCriteria);
            model.addAttribute("searchResults", availableFlights);

            return "resultFlights";

    }
}
