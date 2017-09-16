package airline.Model;
public class First extends TravelClass {

    public  First(int totalSeats, int availableSeats,double baseFare, double totalPrice){
        super(totalSeats,availableSeats,baseFare, totalPrice);
    }

    public double calculateTotalPrice(int numberOfPassenger) {

        int seatsOccupied = getTotalSeats() - getAvailableSeats();
        double totalPrice = getBaseFare() * numberOfPassenger;
        /*totalPrice = (seatsOccupied > getTotalSeats() * 0.4 && seatsOccupied < getTotalSeats() * 0.9) ?
                totalPrice + totalPrice * 0.3 :
                ((seatsOccupied > getTotalSeats() * 0.9) ? totalPrice + totalPrice * 0.6 : totalPrice);
        setTotalPrice(totalPrice);*/
        return totalPrice;
    }

}