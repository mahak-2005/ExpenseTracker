package Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/api/Bills")
@Validated
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(@Qualifier("databaseBillService") BillService billService) {
        this.billService = billService;
    }
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        Bill savedBill = billService.createBill(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billService.getAllBill();
        return  ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable long id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/ByBillType")
    public ResponseEntity<List<Bill>> getBillByBillType(@RequestParam String billType) {
        Bill bill = billService.getBillByBillType(billType);
        if (bill == null) {
            return ResponseEntity.ok((bill);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/Bill/{Id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable long Id) {
        boolean deleted = billService.deleteBill(id);
        if (deleted) {
            return ResponseEntity.ok("Bill deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bill not found");
    }

}
