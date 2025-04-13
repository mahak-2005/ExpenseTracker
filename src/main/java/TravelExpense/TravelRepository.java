package TravelExpense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Travel} entities in the database.
 * <p>
 * This interface extends {@link JpaRepository} which provides standard CRUD operations:
 * <ul>
 *     <li>{@code save(Travel entity)}: Saves a travel entity to the database</li>
 *     <li>{@code findById(Long id)}: Finds a travel by its ID</li>
 *     <li>{@code findAll()}: Retrieves all travel</li>
 *     <li>{@code deleteById(Long id)}: Deletes a travel by its ID</li>
 *     <li>{@code delete(food entity)}: Deletes a specific travels entity</li>
 *     <li>{@code count()}: Returns the total number of travels</li>
 *     <li>{@code existsById(Long id)}: Checks if a travel with given ID exists</li>
 * </ul>
 * <p>
 * The {@code @Repository} annotation marks this interface as a Spring Data repository,
 * which allows Spring to find and configure it automatically.
 */
@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    /**
     * Finds all Destination with a amount greater than the specified value.
     * <p>
     * This method allows filtering  travel based on a minimum amount threshold.
     * Spring Data JPA automatically implements this method based on its Destination name
     * following the pattern "findBy[PropertyName][GreaterThan]".
     *
     * @param amount the minimum amount threshold
     * @return a list of travel with prices greater than the specified value
     */
    List<Travel> findByAmountGreaterThan(double amount);

    /**
     * Finds a travel by its Destination name.
     * <f>
     * This custom method is created because JpaRepository doesn't provide a
     * built-in method to search by the Destination name. Spring Data JPA will automatically
     * implement this method based on its Destination name following the pattern "findBy[PropertyName]".
     * <p>
     * The method returns an Optional object which may or may not contain a Travel,
     * avoiding potential null pointer exceptions when no travel is found with the given Destination name.
     *
     * @param Name the Destinatin name of the Travel to search for
     * @return an Optional containing the found travel, or an empty Optional if no travel exists with the given Destination name
     */
    Optional<Travel> findByTravelName(String Name);

    /**
     * Finds all travel whose name contains the specified keyword, ignoring case.
     * <p>
     * This method provides a case-insensitive partial match search on Destination names.
     * For example, searching for "land" would match "", "iPhone", etc.
     * Spring Data JPA automatically implements this method based on its name
     * following the pattern "findBy[PropertyName][Containing][IgnoreCase]".
     *
     * @param keyword the search term to look for in food names
     * @return a list of products whose names contain the keyword (case insensitive)
     */
    List<Travel> findByTravelNameContainingIgnoreCase(String keyword);
    @Query(value = "select t from Travel t where t.amount BETWEEN ?1 AND ?5 ORDER BY t.amount ASC")
    List<Travel> findByAmountBetween(double min, double max);
}
