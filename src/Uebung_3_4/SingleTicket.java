package Uebung_3_4;

public class SingleTicket extends Ticket {

    public SingleTicket(double price) {
        super(price);
    }

    public SingleTicket(int priceLevel) {
        super(calculatePrice(priceLevel));
    }

    private static boolean isValid(int priceLevel) {
        return priceLevel >= 1 && priceLevel <= 5;
    }

    private static double calculatePrice(int priceLevel) {
        if (isValid(priceLevel)) {
            return Ticket.priceLevels[priceLevel - 1];
        } else {
            throw new IllegalArgumentException("error: priceLevel out of bounds");
        }
    }

    public boolean use() {
        if (!this.isValid()) {
            return false;
        } else {
            this.invalidate();
            return true;
        }
    }

    ;

    @Override
    public String toString() {
        String message = this.isValid() ? "" : "ticket is invalidated";
        return super.toString() + message;
    }
}


