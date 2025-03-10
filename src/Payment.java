public class Payment extends AbstractPayment{

    public Payment(int transactionID, double amount, String paymentProcessor, String purchaseDate) {
        super(transactionID, amount, paymentProcessor, purchaseDate);
    }

    @Override
    public void processPayment() {
        System.out.println("Payment has been finalised.");
    }

    @Override
    public void printReceipt() {
        System.out.println("Printing receipt.");
    }
}
