import java.util.Date;
import java.util.List;

public interface TicketSalesDataInterface {

    void recordTicketSale(TicketSale ticketSale);

    TicketSale getTicketData(int ticketID);

    List<TicketSale> getSalesReport(Date startDate, Date endDate);

    double getRevenueSummary(Date startDate, Date endDate);

    List<TicketSale> getTicketByCustomer(int customerID);

    TicketSale getTicketForEvent(int eventID, int customerID);
}
