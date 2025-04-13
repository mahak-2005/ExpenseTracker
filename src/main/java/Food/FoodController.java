package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@Validated
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(@Qualifier("databaseFoodService")FoodService foodService) {
        this.foodService = foodService;
    }
    @PostMapping
    public ResponseEntity<Food> createFood( @RequestBody Food food){
        Food savedFood = foodService.createFood(food);
        return new  ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Food>> getAllFood(){
        List<Food> foods= foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable long id){
        Food food = foodService.getFoodById(id);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/byName")
    public ResponseEntity<Food> getFoodByName(@RequestParam String name){
        Food food = foodService.getFoodByName(name);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable  long id){
        boolean deleted = foodService.deleteFood(id);
    if(deleted){
        return ResponseEntity.ok("Food deleted successfully");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with not found");
    }
}
