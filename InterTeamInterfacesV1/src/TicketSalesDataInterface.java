import java.util.Date;
import java.util.List;

//Defines methods for managing ticket sales data.
//Box Office team use data for reporting and providing sales insights to both Operations and Marketing teams.

public interface TicketSalesDataInterface {
    
    //Records new ticket sale.
    void recordTicketSale(TicketSale ticketSale);
    
    //Retrieves data for a ticket.
    TicketSale getTicketData(int ticketID);
    
    //Retrieves sales report for given date range.
    List<TicketSale> getSalesReport(Date startDate, Date endDate);

    //Provides revenue summary for given date range.
    double getRevenueSummary(Date startDate, Date endDate);
    
    //Retrieves all tickets sold to a customer.
    List<TicketSale> getTicketByCustomer(int customerID);
    
    //Retrieves ticket for an event and customer.
    TicketSale getTicketForEvent(int eventID, int customerID);
}
