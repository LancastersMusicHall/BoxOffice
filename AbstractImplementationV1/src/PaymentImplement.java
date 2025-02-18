public class PaymentImplement extends AbstractPayment {

    public PaymentImplement(double amount, String paymentProcessor, String purchaseDate) {
        super(amount, paymentProcessor, purchaseDate);
    }

    @Override
    public void processPayment() {
        // Simple output message as a method placeholder
        System.out.println("Processing payment in PaymentImplement.");
    }

    @Override
    public void printReceipt() {
        // Simple output message as a method placeholder
        System.out.println("Printing receipt in PaymentImplement.");
    }
}
