import java.util.List;

//Provides methods to access and update customer data.
//Used by both the Operations and Marketing teams for customer insights.

public interface CustomerDataInterface {
    
    //Retrieves detailed customer information.
    Customer getCustomerDetails(int customerID);
    
    //Retrieves all customers.
    List<Customer> getAllCustomers();
    
    //Retrieves list of events attended by specific customer.
    List<Event> getEventsAttendedByCustomer(int customerID);
    
    //Updates customer information.
    void updateCustomerInfo(Customer customer);
    
    //Retrieves customers with accessibility needs.
    List<Customer> getCustomersWithAccessibilityNeeds();
}
