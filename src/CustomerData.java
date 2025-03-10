public interface CustomerData {
    boolean qualifiesForDiscount(int customerID);
    void applyDiscount(int customerID);
    void retrieveBookingPreferences(int customerID);
}
