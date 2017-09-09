package airline.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Flight {

    private String flightName;
    private String flightId;
    private String source;
    private String destination;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate departureDate;
    private Airplane airplane;
    private int availableSeats;
    private double totalPrice;


    public Flight() {
    }

    public Flight(String flightName, String flightId, String source, String destination, LocalDate departureDate,
                  Airplane airplane, int availableSeats, double totalPrice){
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.airplane = airplane;
        this.availableSeats = availableSeats;
        this.totalPrice = totalPrice;
    }


    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getDestination() {

        return destination;
    }

    public void setDestination(String destination) {

        this.destination = destination;
    }

    public LocalDate getDepartureDate() { return departureDate; }

    public void setDepartureDate(LocalDate departureDate) {

        this.departureDate = departureDate;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }


    public int getAvailableSeats() {

        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {

        this.availableSeats = availableSeats;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    /*
    public HashMap<String, TravelClass> getTravelClassMap() {
        return travelClassMap;
    }

    public void setTravelClassMap(HashMap<String, TravelClass> travelClassMap) {
        this.travelClassMap = travelClassMap;
    }*/


    /*public int getSeatsByTravelClass(String seatingClassName){
        return travelClassMap.get(seatingClassName).availableSeats;
    }

    public boolean searchFlightsBySourceDestination(String source, String destination){
        if((source.equalsIgnoreCase(getSource())) && (destination.equalsIgnoreCase(getDestination())))
            return  true;
        else
            return false;

    }

    public boolean searchForTravelClass(){

    }
*/

}
