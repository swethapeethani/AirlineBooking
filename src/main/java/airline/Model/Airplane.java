package airline.Model;

import org.springframework.web.servlet.HandlerAdapter;

import java.util.HashMap;

public class Airplane {

    private String airplaneID;
    private String airplaneName;
    private HashMap<String, TravelClass> travelClassMap;

    public  Airplane(String airplaneID, String airplaneName,HashMap<String, TravelClass> travelClassMap ){

        this.airplaneID = airplaneID;
        this.airplaneName = airplaneName;
        this.travelClassMap = travelClassMap;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public HashMap<String, TravelClass> getTravelClassMap() {
        return travelClassMap;
    }


}
