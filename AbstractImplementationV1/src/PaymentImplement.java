public class PaymentImplement extends AbstractPayment {

    public PaymentImplement(double amount, String paymentProcessor, String purchaseDate) {
        super(amount, paymentProcessor, purchaseDate);
    }

    //Methods from abstract class have been overriden - method body is to be done over the course of the project
    @Override
    public void processPayment() {
        // Simple output message as a method placeholder
        System.out.println("Processing payment in PaymentImplement class.");
    }

    @Override
    public void printReceipt() {
        // Simple output message as a method placeholder
        System.out.println("Printing receipt in PaymentImplement class.");
    }
}
