import java.util.List;

public interface CustomerDataInterface {

    Customer getCustomerDetails(int customerID);

    List<Event> getEventsAttendedByCustomer(int customerID);

    void updateCustomerInfo(Customer customer);

    List<Customer> getCustomersWithAccessibilityNeeds();
}
