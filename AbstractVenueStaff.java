// Interfaces

// Venue Staff Interface
public interface VenueStaffInterface {
    void login();
    void logout();
}

// Manager Interface
public interface ManagerInterface extends VenueStaffInterface {
    void processRefund();
    void updateTicketSales();
    void modifySeatingConfig();
    void addShow();
    void addSeats();
    void removeShows();
    void removeSeats();
    void holdSeats();
    void markSeatAsRestricted();
    void changeSeatPrice();
}

// Calendar Data Interface
public interface CalendarDataInterface {
    void retrieveCalendar();
    void updateCalendar();
}

// Seating Data Interface
public interface SeatingDataInterface {
    void retrieveSeatingArrangement();
    void updateSeatStatus(int seatID, boolean isReserved);
}

// Ticket Sales Data Interface
public interface TicketSalesDataInterface {
    void recordTicketSale(int ticketID, int customerID);
    void retrieveTicketData(int ticketID);
}

// Group Booking Data Interface
public interface GroupBookingDataInterface {
    void reserveGroupSeats(int groupID, int[] seatIDs);
    void validateGroupBooking(int groupID);
}

// Customer Data Interface
public interface CustomerDataInterface {
    void validateDiscount(int customerID);
    void retrieveBookingPreferences(int customerID);
}

// Payment Interface  -- may/may not be necessary
public interface PaymentInterface {
    void processPayment(double amount, String paymentMethod);
    void printReceipt(int transactionID);
}

// Abstract Classes

// Abstract Venue Staff
public abstract class AbstractVenueStaff {
    protected String name;
    protected int staffID;
    protected String role;

    public abstract void login();
    public abstract void logout();
}

// Abstract Ticket
public abstract class AbstractTicket {
    protected int ticketID;
    protected double price;
    protected int seatNumber;

    public abstract void validateTicket();
}

// Abstract Payment
public abstract class AbstractPayment {
    protected int transactionID;
    protected double amount;
    protected String paymentMethod;
    protected String paymentStatus;
    protected String purchaseDate;

    public abstract void processPayment();
    public abstract void printReceipt();
}
