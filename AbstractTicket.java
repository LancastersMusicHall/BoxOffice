public abstract class AbstractTicket {
    protected int ticketID;
    protected double price;
    protected int seatNumber;

    public abstract void validateTicket();
}