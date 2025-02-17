public abstract class AbstractTicket {
    private final int ticketIdNumber;
    /* did not leave the price as final so that discounts can be applied in case,
    feel free to change if this doesn't make sense and the discount will be handled elsewhere
    */
    private double price;
    private final int seatNumber;

    public AbstractTicket(int tickerIdNumber, double price, int seatNumber) {
        this.ticketIdNumber = tickerIdNumber;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    // Same as prior, added this just in case, if the discount will be handled elsewhere then alter this
    public abstract int applyTicketDiscount();

    // Added this in here just in case, feel free to remove it if you want
    public abstract boolean checkTicketValidity();
}
