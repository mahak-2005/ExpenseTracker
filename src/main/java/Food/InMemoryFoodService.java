package Food;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryFoodService implements FoodService {
    private final List<Food> foods;

    public InMemoryFoodService(){
        this.foods=new ArrayList<>();
    }
    @Override
    public Food createFood(Food food){
        foods.add(food);
        return food;
    }
    @Override
    public List<Food> getAllFoods(){
        return foods;
    }
    @Override
    public Food getFoodById(long id){
        for(Food food:foods){
            if (food.getId()==id){
                return food;
            }
        }
        return null;
    }
    @Override
    public Food getFoodByName(String name){
        for(Food food:foods){
            if (food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }
    @Override
    public Food updateFoodname(long id, String name){
        Food food=getFoodById(id);
        if (food!=null){
            food.setName(name);
        }
        return food;
    }
    @Override
    public Food updateFoodprice(long id, double price){
        Food food=getFoodById(id);
        if (food!=null){
            food.setPrice(price);
        }
        return food;
    }
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
