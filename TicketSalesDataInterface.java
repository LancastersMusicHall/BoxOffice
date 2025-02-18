public interface TicketSalesDataInterface {
    void recordTicketSale(int ticketID, int customerID);
    void retrieveTicketData(int ticketID);
}