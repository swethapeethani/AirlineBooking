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

    //public HashMap<String , HashMap<String , TravelClass>> airplaneMap = new HashMap<String , HashMap<String , TravelClass>>();

    private HashMap<String , TravelClass> travelClassMap1 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap2 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap3 = new HashMap<>();

    @Override
    public ArrayList<Flight> getFlights(){

        travelClassMap1.put("Economy",new TravelClass(100,80,6000));
        travelClassMap1.put("First",new TravelClass(20,10,12000));
        travelClassMap1.put("Business",new TravelClass(10,10, 30000));

        travelClassMap2.put("Economy",new TravelClass(100,50,8000));
        travelClassMap2.put("First",new TravelClass(0,0,0));
        travelClassMap2.put("Business",new TravelClass(10,10, 32000));

        travelClassMap3.put("Economy",new TravelClass(100,80,7000));
        travelClassMap3.put("First",new TravelClass(20,10,18000));
        travelClassMap3.put("Business",new TravelClass(0,0,0));

        Airplane BNG001 = new Airplane("BNG001","Boeing-737", travelClassMap1 );
        Airplane AB001 = new Airplane("AB001","AirBus-319", travelClassMap2 );
        Airplane AB002 = new Airplane("AB002","AirBus-321",travelClassMap3);

        /*airplaneMap.put("Boeing-737",travelClassMap1);
        airplaneMap.put("AirBus-319",travelClassMap2);
        airplaneMap.put("AirBus-321",travelClassMap3);*/

        flights.add(new Flight("Emirates", "EMR001", "HYD", "BLR", LocalDate.of(2017,9,14), BNG001,0,0));
        flights.add(new Flight("Indigo", "IND001", "HYD", "BLR", LocalDate.of(2017,9,16), AB001,0,0));
        flights.add(new Flight("SpiceJet", "SJ001", "HYD", "BLR", LocalDate.of(2017,9,18), AB002,0,0));
        flights.add(new Flight("JetAirways", "JA001", "HYD", "CHN", LocalDate.of(2017,9,18), AB001,0,0));
        flights.add(new Flight("IndianAirlines", "IA001", "BLR", "CHN", LocalDate.of(2017,9,20), BNG001,0,0));
        flights.add(new Flight("KingFisher", "KF001", "BLR", "CHN",LocalDate.of(2017,9,20), AB002,0,0));
        flights.add(new Flight("AirIndia", "AI001", "PUN", "BLR", LocalDate.of(2017,9,13), AB002,0,0));
        flights.add(new Flight("AirAsia", "AA001", "CHN", "HYD", LocalDate.of(2017,9,13), BNG001,0,0));

        return flights;
    }

}
