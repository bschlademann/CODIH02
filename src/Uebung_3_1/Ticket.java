package Uebung_3_1;

public class Ticket {
    private double price;
    protected boolean ticketIsValid;
    protected static double[] priceLevels = {1.8, 2.9, 3.8, 4.8, 5.6};

    public Ticket (double price) {
        this.price = price;
        this.ticketIsValid = true;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTicketIsValid() {
        return ticketIsValid;
    }

    protected void invalidate() {
        this.ticketIsValid = false;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
