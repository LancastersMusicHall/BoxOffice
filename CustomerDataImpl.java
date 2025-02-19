public class CustomerDataImpl implements CustomerData {
    @Override
    public void validateDiscount(int customerID) {
        System.out.println("Validating discount for Customer ID: " + customerID);
    }

    @Override
    public void retrieveBookingPreferences(int customerID) {
        System.out.println("Retrieving booking preferences for Customer ID: " + customerID);
    }
}