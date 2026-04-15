package Uebung_3_2;

public class MultiTicket extends Ticket {
    private int rides;
    public MultiTicket(double price, int rides) {
        super(price);
        this.rides = rides;
    }

    @Override
    public String toString() {
        String message = "number rides: " + rides + "\n";
        return super.toString() + message;
    }
}
