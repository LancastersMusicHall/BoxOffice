public class TicketImplement extends AbstractTicket {

    public TicketImplement(int ticketIdNumber, double price, int seatNumber) {
        super(ticketIdNumber, price, seatNumber);
    }
    
    //Methods from abstract class have been overriden - method body is to be done over the course of the project
    @Override
    public int applyTicketDiscount() {
        // Simple output message as a method placeholder
        System.out.println("applyTicketDiscount() method called in TicketImplement class. No discount applied.");
        return 0;  
    }

    @Override
    public boolean checkTicketValidity() {
        // Simple output message as a method placeholder
        System.out.println("checkTicketValidity() method called in TicketImplement class. Ticket is valid.");
        return true;
    }
}
