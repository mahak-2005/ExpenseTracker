package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseFoodService implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public DatabaseFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food createFood(Food food) {
        if (food == null) {
            throw new FoodValidationException("Food cannot be null");
        }
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFoods() {
        List<Food> foodList = foodRepository.findAll();
        if (foodList.isEmpty()) {
            throw new FoodNotFoundException("No food found");
        }
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(long id) {
        return foodRepository.findById(id).orElseThrow(() -> new FoodNotFoundException("Food with id " + id + " not found"));
    }

    @Override
    public Food getFoodByName(String name) {
        return foodRepository.findByName(name).orElseThrow(() -> new FoodNotFoundException("Food with name " + name + " not found"));
    }

    @Override
    public boolean deleteFood(long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return true;
        }else
        {throw new FoodNotFoundException("Food with id " + id + " not found");}
    }

    }



