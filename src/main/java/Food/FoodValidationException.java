package Food;
/**
 * Exception thrown when there is an issue with food validation.
 * For example, when the required fields are missing or have invalid values.
 */
public class FoodValidationException extends RuntimeException {
    /**
     * Creates a new FoodValidationException with the specified message.
     * @param message The error message explaining the validation issue.
     */
    public FoodValidationException(String message) {
        super(message);
    }
}
