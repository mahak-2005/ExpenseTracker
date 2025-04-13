package Bill;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InMemoryBillService implements BillService {
    private final List<Bill> bills;
    public InMemoryBillService() {
        this.bills = new ArrayList<>();
    }
    @Override
    public Bill createBill(Bill bill) {
        bills.add(bill);
        return bill;
    }

    @Override
    public List<Bill> getallBill() throws Exception {
        return List.of();
    }

    @Override
    public Bill getBillById(long id) throws Exception {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null;
    }

    @Override
    public Bill getBillByBillType(String billType) throws Exception {
        for (Bill bill : bills) {
            if (bill.getBillType().equals(billType)) {
                return bill;
            }
        }
        return null;
    }

    @Override
    public boolean deleteBill(long id) throws Exception {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                bills.remove(bill);
            }
        }
        return false;
    }
}
