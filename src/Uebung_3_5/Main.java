package Uebung_3_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        ValidTickets validTickets = new ValidTickets() {
            @Override
            public Ticket[] checkValidity(Ticket[] ticketList) {
                List<Ticket> validTickets = new ArrayList<Ticket>();
                for (Ticket ticket : ticketList) {
                    if (ticket.isValid()) {
                        validTickets.add(ticket);
                    }
                }
                return validTickets.toArray(new Ticket[0]);
            }
        };
    }
}
