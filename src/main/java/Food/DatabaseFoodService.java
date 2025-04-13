package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * A service that uses a database to store and manage food information.
 * This class implements the ProductService interface and uses a ProductRepository
 * to perform operations on the database.
 */
@Service
public class DatabaseFoodService implements FoodService {
    /**
     * The repository used to access the database.
     */
    private final FoodRepository foodRepository;
    /**
     * Creates a new DatabaseProductService with the provided repository.
     *
     * @param foodRepository the repository to use for database operations
     */
    @Autowired
    public DatabaseFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    /**
     * Adds a new food to the database.
     *
     * @param food the food to add
     * @return the saved food with any database-generated values (like ID)
     */
    @Override
    public Food createFood(Food food) {
        if (food == null) {
            throw new FoodValidationException("Food cannot be null");
        }
        return foodRepository.save(food);
    }
    /**
     * Gets a list of all food from the database.
     *
     * @return a list containing all products
     */
    @Override
    public List<Food> getAllFoods() {
        List<Food> foodList = foodRepository.findAll();
        if (foodList.isEmpty()) {
            throw new FoodNotFoundException("No food found");
        }
        return foodRepository.findAll();
    }
    /**
     * Finds a food in the database using its ID.
     *
     * @param id the ID of the food to find
     * @return the found food, or null if no food exists with the given ID
     */
    @Override
    public Food getFoodById(long id) {
        return foodRepository.findById(id).orElseThrow(() -> new FoodNotFoundException("Food with id " + id + " not found"));
    }
    /**
     * Finds a food in the database using its name.
     *
     * @param name the name of the food to find
     * @return the found food, or null if no food exists with the given name
     */
    @Override
    public Food getFoodByName(String name) {
        return foodRepository.findByName(name).orElseThrow(() -> new FoodNotFoundException("Food with name " + name + " not found"));
    }
    /**
     * Deletes a food from the database.
     *
     * @param id the ID of the food to delete
     * @return true if a food was deleted, false if no food exists with the given ID
     */
    @Override
    public boolean deleteFood(long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return true;
        }else
        {throw new FoodNotFoundException("Food with id " + id + " not found");}
    }

    }



