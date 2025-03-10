public class Ticket extends AbstractTicket{

    public Ticket(int tickerIdNumber, double price, int seatNumber) {
        super(tickerIdNumber, price, seatNumber);
    }

    @Override
    public int applyTicketDiscount() {
        System.out.println("Applying ticket discount");
        return 0;
    }

    @Override
    public boolean checkTicketValidity() {
        System.out.println("Ticket validity is processing");
        return false;
    }
}
