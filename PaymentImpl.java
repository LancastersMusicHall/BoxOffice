public class PaymentImpl extends AbstractPayment implements Payment {
    public PaymentImpl(int transactionID, double amount, String paymentMethod, String purchaseDate) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.purchaseDate = purchaseDate;
        this.paymentStatus = "Pending";
    }

    @Override
    public void processPayment(double amount, String paymentMethod) {
        this.paymentStatus = "Completed";
        System.out.println("Processing payment of " + amount + " using " + paymentMethod);
    }

    @Override
    public void printReceipt(int transactionID) {
        System.out.println("Transaction ID: " + transactionID + "\nAmount: " + amount + "\nPayment Method: " + paymentMethod + "\nStatus: " + paymentStatus);
    }

    @Override
    public void processPayment() {

    }

    @Override
    public void printReceipt() {

    }
}