public class TicketSalesManager implements TicketSalesDataInterface {
    @Override
    public void recordTicketSale(int ticketID, int customerID) {
        System.out.println("Recording sale for ticket " + ticketID + " to customer " + customerID);
    }

    @Override
    public void retrieveTicketData(int ticketID) {
        System.out.println("Retrieving ticket data for ticket " + ticketID);
    }
}
