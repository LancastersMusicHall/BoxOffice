public class TicketSalesData implements TicketSalesDataInterface {
    @Override
    public void recordTicketSale(int ticketID, int customerID) {
        System.out.println("Recording ticket sale for Ticket ID: " + ticketID + " and Customer ID: " + customerID);
    }

    @Override
    public void retrieveTicketData(int ticketID) {
        System.out.println("Retrieving ticket data for Ticket ID: " + ticketID);
    }
}