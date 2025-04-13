package Bill;

public class BillValidationException extends RuntimeException {
    public BillValidationException(String message) {
        super(message);
    }
}
