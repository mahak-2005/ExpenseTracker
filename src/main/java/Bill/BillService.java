package Bill;

import java.util.List;

public interface BillService {
    Bill createBill (Bill bill) throws BillValidationException ;
    List<Bill> getAllBill() throws BillNotFoundException;

    Bill getBillById(long id) throws BillNotFoundException;
    Bill getBillByBillType(String billType) throws BillNotFoundException;
    boolean deleteBill(long id) throws Exception;
}
