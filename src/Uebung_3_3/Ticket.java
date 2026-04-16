package Uebung_3_3;

public abstract class Ticket {
    private double price;
    private boolean isValid;
    protected static double[] priceLevels = {1.8, 2.9, 3.8, 4.8, 5.6};

    public Ticket (double price) {
        this.price = price;
        this.isValid = true;
    }

    public boolean isValid() {
        return isValid;
    }

    protected void invalidate() {
        this.isValid = false;
    }

    abstract boolean use();

    @Override
    public String toString() {
        return "ticket price: " + this.price + "\n";
    }
}
