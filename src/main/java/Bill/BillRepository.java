package Bill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Optional<Bill> findById(Long aLong);
    List<Bill> findByBillType(String billType);
    List<Bill> findByPriceGreaterThan(double price);


    Long Id(long id);
}
