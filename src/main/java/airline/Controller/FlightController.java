package airline.Controller;

import airline.Model.Flight;
import airline.Services.FlightSearchService;
import org.springframework.boot.SpringApplication;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import airline.Model.City;
import airline.Model.SearchCriteria;
import airline.Repository.CityRepository;
import airline.Repository.FlightRepository;
import airline.Services.FlightSearchService;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }


    private CityRepository cityServices;
    private Flight flight;
    private SearchCriteria searchCriteria;

    //@Autowired
    private FlightSearchService flightSearchService;
    private FlightRepository flightRepository;

    @RequestMapping(value = "/AirlineBooking", method = RequestMethod.GET)
    public String welcomeMessage(Model model) {

        CityRepository cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("Hyderabad", "Pune",1, LocalDate.of(2017,9,5)));
        //System.out.println(searchCriteria.getSource());
        return "flightSearch";

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) {

        flightSearchService = new FlightSearchService();
        List<Flight> availableFlights = flightSearchService.search(searchCriteria);
        System.out.println("size of available flights :" + availableFlights.size());
        model.addAttribute("searchResults", availableFlights);

        return "resultFlights";

    }
}
