import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import airline.Services.FlightSearchService;
import java.time.LocalDate;

import airline.Services.IFlightSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:Test/beans.xml"})
@ContextConfiguration( classes ={FlightSearchService.class, FlightRepository.class}, loader = AnnotationConfigContextLoader.class)
public class SearchServiceTest{

    @Autowired
    private IFlightSearchService searchService;

    @Test
    public void showFlightsFromHYDtoBLRWithOutDate(){
        SearchCriteria searchCriteria = new SearchCriteria("HYD","BLR",1, null,"Economy");
        assertEquals(searchService.search(searchCriteria).size(),4);
    }

    @Test
    public void showFlightsWhenDestinationIsNullAndDateNull() {
       SearchCriteria searchCriteria = new SearchCriteria("HYD", null, 5, null,"Economy");
        assertEquals(searchService.search(searchCriteria).size(),4);
    }

    @Test
    public void showFlightsWhenSourceIsNullon25th() {
       SearchCriteria searchCriteria = new SearchCriteria(null, "BLR", 5, LocalDate.of(2017, 9, 25), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 1);
    }

    @Test
    public void showFlightFromHYDtoBLRfor80PassengersAndDateNull(){
       SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 80, null,"Economy");
        assertEquals(searchService.search(searchCriteria).size(),1);

    }
    //number of passengers is more than available seats
    @Test
    public void showFlightFromHYDtoBLRfor150Passengers() {
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 150, LocalDate.of(2017, 9, 27), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 0);
    }
    //When the departure date is prior to the current date,
    // list all the flights between the selected source and destination starting from todays date
    @Test
    public void showFlightHYDtoBLRon19Sep(){
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 4, LocalDate.of(2017,9,19),"Economy");
        assertEquals(searchService.search(searchCriteria).size(),1);
    }
    @Test
    public void showFlightHYDtoBLRon25SepWithSeatingClassAsNull(){
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 3, LocalDate.of(2017,9,25), null);
        assertEquals(searchService.search(searchCriteria).size(),1);
    }
    //If number of passengers is 0, take default value as 1
    @Test
    public void showFlightFromHYDtoBLRfor0PassengersOn25th() {
        //IFlightSearchService searchService = new FlightSearchService();
        SearchCriteria searchCriteria = new SearchCriteria("HYD", "BLR", 0, LocalDate.of(2017, 9, 25), "Economy");
        assertEquals(searchService.search(searchCriteria).size(), 1);
    }

}