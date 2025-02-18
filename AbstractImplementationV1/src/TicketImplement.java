public class TicketImplement extends AbstractTicket {

    public TicketImplement(int ticketIdNumber, double price, int seatNumber) {
        super(ticketIdNumber, price, seatNumber);
    }

    @Override
    public int applyTicketDiscount() {
        // Simple output message as a method placeholder
        System.out.println("applyTicketDiscount() called in TicketImplement. No discount applied.");
        return 0;  
    }

    @Override
    public boolean checkTicketValidity() {
        // Simple output message as a method placeholder
        System.out.println("checkTicketValidity() called in TicketImplement. Ticket is valid.");
        return true;
    }
}
