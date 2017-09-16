package airline.Model;

import sun.jvm.hotspot.opto.HaltNode;

import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class TravelClass {

    private int totalSeats;
    private int availableSeats;
    private double baseFare;
    private double totalPrice;

    //HashMap<String, Method> calculateTotalPrice = new HashMap<>();

    public TravelClass(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.baseFare = baseFare;
        this.totalPrice = totalPrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double calculateTotalPrice(SearchCriteria searchCriteria){
        return getTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



}

