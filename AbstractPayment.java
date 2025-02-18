public abstract class AbstractPayment {
    protected int transactionID;
    protected double amount;
    protected String paymentMethod;
    protected String paymentStatus;
    protected String purchaseDate;

    public abstract void processPayment();
    public abstract void printReceipt();
}
