package Food;

import jakarta.persistence.*;


import org.antlr.v4.runtime.misc.NotNull;

import java.util.Objects;
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name should not be black")
    @Size(min= 4, message="Minimum length should be 4 characters")
    @Column(nullable = false)
    private String name;
    @NotNull(message = "Price should not be null")
    @Min(value = 0, message = "Product price must be greater than or equal to 0.")
    @Column(nullable = false)
    private double price;

    public Food() {
    }

    public Food(long id, String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Food food = (Food) o;
        return id == food.id && Double.compare(price, food.price) == 0 && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
