import java.util.List;

public interface CustomerDataInterface {

    Customer getCustomerDetails(int customerID);

    List<Customer> getAllCustomers();

    List<Event> getEventsAttendedByCustomer(int customerID);

    void updateCustomerInfo(Customer customer);

    List<Customer> getCustomersWithAccessibilityNeeds();
}
