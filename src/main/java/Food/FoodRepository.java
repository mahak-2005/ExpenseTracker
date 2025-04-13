package Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);
    List<Food> findByPriceGreaterThan(double price);
    List<Food> findByNameContainingIgnoreCase(String keyword);
    @Query("select f from Food f where f.price BETWEEN ?1 AND ?2 ORDER BY f.price ASC ")
    List<Food> findFoodInPriceRange(String name);
}
