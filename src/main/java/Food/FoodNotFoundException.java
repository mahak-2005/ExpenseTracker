package Food;
/**
 * Exception thrown when a food is not found in the database.
 * Used when searching for a food by id or name.
 */

public class FoodNotFoundException extends RuntimeException {


    public FoodNotFoundException(String message) {
        super(message);
    }
}
