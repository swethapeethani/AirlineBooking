package airline.Repository;

import airline.Model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<>();

    //public HashMap<String , HashMap<String , TravelClass>> airplaneMap = new HashMap<String , HashMap<String , TravelClass>>();

    private HashMap<String , TravelClass> travelClassMap1 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap2 = new HashMap<>();
    private HashMap<String , TravelClass> travelClassMap3 = new HashMap<>();




    public ArrayList<Flight> getFlights(){
        travelClassMap1.put("Economy",new TravelClass(100,80));
        travelClassMap1.put("First",new TravelClass(20,10));
        travelClassMap1.put("Business",new TravelClass(10,10));

        travelClassMap2.put("Economy",new TravelClass(100,80));
        //travelClassMap2.put("First",new TravelClass(20,10));
        travelClassMap2.put("Business",new TravelClass(10,10));

        travelClassMap3.put("Economy",new TravelClass(100,80));
        travelClassMap3.put("First",new TravelClass(20,10));
        //travelClassMap3.put("Business",new TravelClass(10,10));

        Airplane BNG001 = new Airplane("BNG001","Boeing-737", travelClassMap1 );
        Airplane AB001 = new Airplane("AB001","AirBus-319", travelClassMap2 );
        Airplane AB002 = new Airplane("AB002","AirBus-321",travelClassMap3);

        /*airplaneMap.put("Boeing-737",travelClassMap1);
        airplaneMap.put("AirBus-319",travelClassMap2);
        airplaneMap.put("AirBus-321",travelClassMap3);*/

        flights.add(new Flight("Emirates", "EMR001", "HYD", "BLR", LocalDate.of(2017,9,11), BNG001));
        flights.add(new Flight("Indigo", "IND001", "HYD", "BLR", LocalDate.of(2017,9,11), BNG001));
        flights.add(new Flight("SpiceJet", "SJ001", "HYD", "CHN", LocalDate.of(2017,9,15), AB001));
        flights.add(new Flight("JetAirways", "JA001", "HYD", "CHN", LocalDate.of(2017,9,18), AB001));
        flights.add(new Flight("IndianAirlines", "IA001", "BLR", "CHN", LocalDate.of(2017,9,13), BNG001));
        flights.add(new Flight("KingFisher", "KF001", "BLR", "CHN",LocalDate.of(2017,9,12), AB002));
        flights.add(new Flight("AirIndia", "AI001", "PUN", "BLR", LocalDate.of(2017,9,13), AB002));
        flights.add(new Flight("AirAsia", "AA001", "CHN", "HYD", LocalDate.of(2017,9,13), BNG001));

        return flights;
    }

}
