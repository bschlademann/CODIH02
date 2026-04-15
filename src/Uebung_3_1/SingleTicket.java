package Uebung_3_1;

public class SingleTicket extends Ticket {

    public SingleTicket(double price) {
        super(price);
    }

    public SingleTicket(int priceLevel) {
        super(calculatePrice(priceLevel));
    }

    private static boolean priceLevelIsValid(int priceLevel) {
        return priceLevel >= 1 && priceLevel <= 5;
    }

    private static double calculatePrice(int priceLevel) {
        if (priceLevelIsValid(priceLevel)) {
            return priceLevels[priceLevel - 1];
        } else {
            throw new IllegalArgumentException("error: priceLevel out of bounds");
        }
    }
}


