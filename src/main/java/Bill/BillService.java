package Bill;

import java.util.List;

public interface BillService {
    Bill createBill (Bill bill) throws Exception ;
    List<Bill> getallBill() throws Exception;

    Bill getBillById(long id) throws Exception;
    Bill getBillByBillType(String billType) throws Exception;
    boolean deleteBill(long id) throws Exception;
}
