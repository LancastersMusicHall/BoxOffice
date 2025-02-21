import java.util.List;

//Defines methods to access and update customer data.
//Used by both Operations and Marketing teams for customer insights.

public interface CustomerDataInterface {
    
    //Retrieves customer information.
    Customer getCustomerDetails(int customerID);
    
    //Retrieves all customers.
    List<Customer> getAllCustomers();
    
    //Retrieves list of events attended by a customer.
    List<Event> getEventsAttendedByCustomer(int customerID);
    
    //Updates customer information.
    void updateCustomerInfo(Customer customer);
    
    //Retrieves customers with accessibility needs.
    List<Customer> getCustomersWithAccessibilityNeeds();
}
