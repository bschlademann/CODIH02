package Uebung_3_5;

public class MultiTicket extends Ticket implements ReturnTrip {
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

    public boolean use(boolean IncludeReturnTrip) {
        if (this.rides >= 2) {
            use();
            use();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String message = "number rides: " + rides + "\n";
        return super.toString() + message;
    }
}
