package airline.Model;

public class Economy extends TravelClass {

    public  Economy(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

public double calculateTotalPrice(SearchCriteria searchCriteria) {

    int seatsOccupied = getTotalSeats() - getAvailableSeats();
    double totalPrice = getBaseFare() * searchCriteria.getNumberOfPassengers();
    totalPrice = (seatsOccupied > getTotalSeats() * 0.4 && seatsOccupied < getTotalSeats() * 0.9) ?
            totalPrice + totalPrice * 0.3 :
            ((seatsOccupied > getTotalSeats() * 0.9) ? totalPrice + totalPrice * 0.6 : totalPrice);
    setTotalPrice(totalPrice);
    return totalPrice;
    }

}
