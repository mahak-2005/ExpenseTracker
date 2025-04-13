package Food;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Service class for managing Food operations.
 * This class handles business logic related to Food.
 */
@Service
public class InMemoryFoodService implements FoodService {
    private final List<Food> foods;

    public InMemoryFoodService(){
        this.foods=new ArrayList<>();
    }
    /**
     * Creates a new food and adds it to the list.
     *
     * @param food The food to be created and stored
     * @return The newly created food
     */
    @Override
    public Food createFood(Food food){
        foods.add(food);
        return food;
    }
    /**
     * Retrieves all food from the list.
     *
     * @return List of all food
     */
    @Override
    public List<Food> getAllFoods(){
        return foods;
    }
    /**
     * Finds a food by its ID.
     *
     * @param id The ID of the food to find
     * @return The found food or null if not found
     */
    @Override
    public Food getFoodById(long id){
        for(Food food:foods){
            if (food.getId()==id){
                return food;
            }
        }
        return null;
    }
    /**
     * Finds  food by its name.
     *
     * @param name The name of the food to find
     * @return The found food or null if not found
     */
    @Override
    public Food getFoodByName(String name){
        for(Food food:foods){
            if (food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }
    /**
     * Deletes food by its ID.
     *
     * @param id The ID of the food to delete
     * @return true if food was deleted, false if not found
     */

    @Override
    public boolean deleteFood(long id){
        Food food=getFoodById(id);
        if (food!=null){
            foods.remove(food);
            return true;
        }
        return false;
    }

}
