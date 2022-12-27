package pl.deptala.piotr.java.spring.app.workshop.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private String date;
    private String name;

    public ServiceEntity() {
    }

    public ServiceEntity(Long id, double price, String date, String name) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
