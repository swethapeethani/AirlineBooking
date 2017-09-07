package airline.Model;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class FlightInformation {

    private String source;
    private String destination;
    private int availableSeats;
    private Optional<LocalDate> date;
    private HashMap<String, TravelClass> travelClassMap;


    public FlightInformation(){

    }

    public FlightInformation( String sourceName, String destinationName, int availableSeats, Optional<LocalDate> date, HashMap<String,TravelClass> travelClassMap){
        this.source = sourceName;
        this.destination = destinationName;
        this.availableSeats = availableSeats;
        this.date = date;
        this.travelClassMap = travelClassMap;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    public Optional<LocalDate> getDate() { return date; }

    public void setDate(Optional<LocalDate> date) {

        this.date = date;
    }
    public HashMap<String, TravelClass> getTravelClassMap() {
        return travelClassMap;
    }

    public void setTravelClassMap(HashMap<String, TravelClass> travelClassMap) {
        this.travelClassMap = travelClassMap;
    }


    public int getSeatsByTravelClass(String seatingClassName){
       return travelClassMap.get(seatingClassName).availableSeats;
    }
}



