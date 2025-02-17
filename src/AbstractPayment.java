public  abstract class AbstractPayment {
    /* I have added this ticket object for the purpose of directly adding it into the payment class,
     this way we can reduce the specific fields for the entire Abstract Payment class and just
     package these fields as extra fields under AbstractTicket, that way we aren't repeating fields such as
     amount, price etc
     Feel free to change any of this */

    private AbstractTicket ticket;
    private final double amount;
    private final String paymentProcessor;
    private final String purchaseDate;


    public AbstractPayment(double amount, String paymentProcessor, String purchaseDate) {
        this.amount = amount;
        this.paymentProcessor = paymentProcessor;
        this.purchaseDate = purchaseDate;
    }

    public abstract void processPayment();
    public abstract void printReceipt();

}
