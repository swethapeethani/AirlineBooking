package airline.Repository;

import airline.Model.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class FlightRepository implements IFlightRepository {

    private ArrayList<Flight> flights = new ArrayList<>();

    private HashMap<String , TravelClass> travelClassMap1 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap2 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap3 = new HashMap<>();

    @Override
    public ArrayList<Flight> getFlights(){

        travelClassMap1.put("Economy",new Economy(100,80,6000,0.0));
        travelClassMap1.put("First",new First(20,10,10000,0.0));
        travelClassMap1.put("Business",new Business(10,10, 30000,0.0));

        travelClassMap2.put("Economy",new Economy(100,40,8000,0.0));
        travelClassMap2.put("First",new First(0,0,0,0.0));
        travelClassMap2.put("Business",new Business(10,10, 32000,0.0));

        travelClassMap3.put("Economy",new Economy(100,5,7000,0.0));
        travelClassMap3.put("First",new First(20,10,18000,0.0));
        travelClassMap3.put("Business",new Business(0,0,0,0.0));

        Airplane BNG001 = new Airplane("BNG001","Boeing-737", travelClassMap1 );
        Airplane AB001 = new Airplane("AB001","AirBus-319", travelClassMap2 );
        Airplane AB002 = new Airplane("AB002","AirBus-321",travelClassMap3);

        flights.add(new Flight("F1-BNG", "F1", "HYD", "BLR", LocalDate.of(2017,9,27), BNG001));
        flights.add(new Flight("F2-AB1", "F2", "HYD", "BLR", LocalDate.of(2017,9,24), AB001));
        flights.add(new Flight("F3-AB2", "F3", "HYD", "BLR", LocalDate.of(2017,9,25), AB002));
        flights.add(new Flight("F4-AB1", "F4", "HYD", "BLR", LocalDate.of(2017,9,19), AB001));

        flights.add(new Flight("F5-BNG", "F5", "BLR", "CHN", LocalDate.of(2017,9,20), BNG001));
        flights.add(new Flight("F6-AB2", "F6", "BLR", "CHN",LocalDate.of(2017,9,21), AB002));
        flights.add(new Flight("F7-AB2", "F7", "BLR", "CHN", LocalDate.of(2017,9,22), AB002));

        flights.add(new Flight("F8-BNG", "F8", "CHN", "HYD", LocalDate.of(2017,9,20), BNG001));

        flights.add(new Flight("F9-BNG", "F9", "HYD", "PUN", LocalDate.of(2017,9,27), BNG001));
        flights.add(new Flight("F10-AB1", "F10", "HYD", "PUN", LocalDate.of(2017,9,25), AB001));
        flights.add(new Flight("F11-AB2", "F11", "HYD", "PUN", LocalDate.of(2017,9,25), AB002));

        flights.add(new Flight("F12-BNG", "F12", "CHN", "HYD", LocalDate.of(2017,9,27), BNG001));

        flights.add(new Flight("F13-AB1", "F13", "PUN", "BLR", LocalDate.of(2017,9,25), AB001));
        flights.add(new Flight("F14-AB2", "F14", "PUN", "BLR", LocalDate.of(2017,9,25), AB002));
        flights.add(new Flight("F15-AB2", "F15", "PUN", "BLR", LocalDate.of(2017,9,23), AB002));


        return flights;
    }

}
