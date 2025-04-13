package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * REST controller for managing products in the Shopkart application.
 * Provides endpoints for CRUD operations on products.
 */
@RestController
@RequestMapping("/api/foods")
@Validated
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(@Qualifier("databaseFoodService")FoodService foodService) {
        this.foodService = foodService;
    }
    /**
     * Creates a new food.
     *
     * @param food The food information to create
     * @return The created food with HTTP status 201 (created)
     */
    @PostMapping
    public ResponseEntity<Food> createFood( @RequestBody Food food){
        Food savedFood = foodService.createFood(food);
        return new  ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }
    /**
     * Retrieves all food from the system.
     *
     * @return ResponseEntity containing a list of all products with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Food>> getAllFood(){
        List<Food> foods= foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }
    /**
     * Retrieves a specific food by its ID.
     *
     * @param id the unique identifier of the food
     * @return ResponseEntity containing the food with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the food doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable long id){
        Food food = foodService.getFoodById(id);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }
    /**
     * Retrieves  food by its name.
     *
     * @param name the name of the food to search for
     * @return ResponseEntity containing the food with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if no food with the given name exists
     */
    @GetMapping("/byName")
    public ResponseEntity<Food> getFoodByName(@RequestParam String name){
        Food food = foodService.getFoodByName(name);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }
    /**
     * Deletes a specific food from the system.
     *
     * @param id the unique identifier of the food to delete
     * @return ResponseEntity with a success message and HTTP status 200 (OK) if deleted,
     * or an error message and HTTP status 404 (Not Found) if the product doesn't exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable  long id){
        boolean deleted = foodService.deleteFood(id);
    if(deleted){
        return ResponseEntity.ok("Food deleted successfully");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with not found");
    }
}
