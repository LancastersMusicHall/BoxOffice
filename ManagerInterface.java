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