package Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Repository interface for managing {@link Food} entities in the database.
 * <p>
 * This interface extends {@link JpaRepository} which provides standard CRUD operations:
 * <ul>
 *     <li>{@code save(food entity)}: Saves a food entity to the database</li>
 *     <li>{@code findById(Long id)}: Finds a food by its ID</li>
 *     <li>{@code findAll()}: Retrieves all products</li>
 *     <li>{@code deleteById(Long id)}: Deletes a food by its ID</li>
 *     <li>{@code delete(food entity)}: Deletes a specific product entity</li>
 *     <li>{@code count()}: Returns the total number of products</li>
 *     <li>{@code existsById(Long id)}: Checks if a food with given ID exists</li>
 * </ul>
 * <p>
 * The {@code @Repository} annotation marks this interface as a Spring Data repository,
 * which allows Spring to find and configure it automatically.
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    /**
     * Finds a food by its name.
     * <f>
     * This custom method is created because JpaRepository doesn't provide a
     * built-in method to search by the food name. Spring Data JPA will automatically
     * implement this method based on its name following the pattern "findBy[PropertyName]".
     * <p>
     * The method returns an Optional object which may or may not contain a food,
     * avoiding potential null pointer exceptions when no food is found with the given name.
     *
     * @param name the name of the food to search for
     * @return an Optional containing the found food, or an empty Optional if no food exists with the given name
     */
    Optional<Food> findByName(String name);
    /**
     * Finds all products with a price greater than the specified value.
     * <p>
     * This method allows filtering products based on a minimum price threshold.
     * Spring Data JPA automatically implements this method based on its name
     * following the pattern "findBy[PropertyName][GreaterThan]".
     *
     * @param price the minimum price threshold
     * @return a list of products with prices greater than the specified value
     */
    List<Food> findByPriceGreaterThan(double price);
    /**
     * Finds all products whose name contains the specified keyword, ignoring case.
     * <p>
     * This method provides a case-insensitive partial match search on food names.
     * For example, searching for "phone" would match "Smartphone", "iPhone", etc.
     * Spring Data JPA automatically implements this method based on its name
     * following the pattern "findBy[PropertyName][Containing][IgnoreCase]".
     *
     * @param keyword the search term to look for in food names
     * @return a list of products whose names contain the keyword (case insensitive)
     */
    List<Food> findByNameContainingIgnoreCase(String keyword);
    @Query("select f from Food f where f.price BETWEEN ?1 AND ?2 ORDER BY f.price ASC ")
    List<Food> findFoodInPriceRange(String name);
}
