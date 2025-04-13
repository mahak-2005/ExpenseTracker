package TravelExpense;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name ="travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String destinationname;

    @Column(nullable = false)
    private double amount;

    public Travel() {
    }

    public Travel( String destinationname, double amount) {
        this.destinationname = destinationname;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinationname() {
        return destinationname;
    }

    public void setDestinationname(String destinationname) {
        this.destinationname = destinationname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Travel that = (Travel) o;
        return id == that.id && Double.compare(amount, that.amount) == 0 && Objects.equals(destinationname, that.destinationname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinationname, amount);
    }

    @Override
    public String toString() {
        return "TravelExpense{" +
                "id=" + id +
                ", destinationname='" + destinationname + '\'' +
                ", amount=" + amount +
                '}';
    }
}
