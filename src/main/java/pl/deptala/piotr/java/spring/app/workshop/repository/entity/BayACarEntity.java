package pl.deptala.piotr.java.spring.app.workshop.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BayACarEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer price;
    public String car;

    public BayACarEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "BayACarEntity{" +
                "id=" + id +
                ", price=" + price +
                ", car='" + car + '\'' +
                '}';
    }
}
