package Bill;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;


@Entity
@Table(name = "Bill")
public class Bill {
    private long id;
    private String billType;
    private double price;

    public Bill() {
    }

    public Bill(long id, String billType, double price) {
        this.id = id;
        this.billType = billType;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id && Double.compare(price, bill.price) == 0 && Objects.equals(billType, bill.billType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billType, price);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billType='" + billType + '\'' +
                ", price=" + price +
                '}';
    }
}
