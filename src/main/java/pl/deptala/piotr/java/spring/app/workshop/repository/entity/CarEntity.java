package pl.deptala.piotr.java.spring.app.workshop.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "CARS")
public class CarEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String color;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity owner;

    public CarEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
//                ", owner=" + owner +
                '}';
    }
}
