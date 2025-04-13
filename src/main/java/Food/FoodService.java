package Food;

import java.util.List;

public interface FoodService {
    Food createFood(Food food) throws FoodValidationException;

    List<Food> getAllFoods() throws FoodNotFoundException;

    Food getFoodById(long id) throws FoodNotFoundException;

    Food getFoodByName(String name) throws FoodNotFoundException;

    boolean deleteFood(long id);
}
