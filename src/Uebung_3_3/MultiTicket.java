package Uebung_3_3;

public class MultiTicket extends Ticket {
    private int rides;

    public MultiTicket(double price, int rides) {
        super(price);
        this.rides = rides;
    }

    public boolean use() {
        if (!this.isValid()) {
            return false;
        } else {
            this.rides--;
            return true;
        }
    }

    @Override
    public String toString() {
        String message = "number rides: " + rides + "\n";
        return super.toString() + message;
    }
}
