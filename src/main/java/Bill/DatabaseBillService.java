package Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseBillService implements BillService {
    private final BillRepository billRepository;

    @Autowired
    public DatabaseBillService(BillRepository billRepository) {this.billRepository = billRepository;}

    @Override
    public Bill createBill(Bill bill) {
        if (bill == null) {
            throw new BillValidationException("bill cannot be null");
        }
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> gelAllBill(){
        List<Bill> bills = billRepository.findAll();
        if (billList.isEmpty()) {
            throw new BillNotFoundException("no bill found");
        }
        return billRepository.findAll();
    }
    @Override
    public Bill getBillById(long id) {
        return billRepository.findById.orElseThrow(() -> new BillNotFoundException("Bill with id " + id + " not found"));
    }
    @Override
    public Bill getBillByBillType(String billType) {
        return billRepository.findBybillType.orelseThrow( () -> new BillNotFoundException("Bill with billType" + billType + "not found"));
    }
    @Override
    public boolean deleteBill(long id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
            return true;
        }else {throw new BillNotFoundException ("Bill with id" + id + "not found");}
    }
}
