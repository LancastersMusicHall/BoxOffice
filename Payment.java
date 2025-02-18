public interface Payment {
    void processPayment(double amount, String paymentMethod);
    void printReceipt(int transactionID);
}