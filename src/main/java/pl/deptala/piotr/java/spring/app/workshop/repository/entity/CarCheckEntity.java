package pl.deptala.piotr.java.spring.app.workshop.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarCheckEntity {
    @Id
    @GeneratedValue
    private long id;
    private String checkList;
    private double price;

    public CarCheckEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCheckList() {
        return checkList;
    }

    public void setCheckList(String checkList) {
        this.checkList = checkList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarCheckEntity{" +
                "id=" + id +
                ", checkList='" + checkList + '\'' +
                ", price=" + price +
                '}';
    }
}
