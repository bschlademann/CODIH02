package Uebung_3_1;

public class MultiTicket extends Ticket {
    private int rides;
    public MultiTicket(double price, int rides) {
        super(price);
        this.rides = rides;
    }
    @Override
    public String toString() {
        String invalided = !ticketIsValid ? "ticket is invalidated\n" : "";
        return "ticket price:" + getPrice() + "\n" + invalided + "number rides:" + rides;
    }
}
