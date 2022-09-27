package pl.deptala.piotr.java.spring.app.workshop.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class RentCarEntity {
    @Id
    @GeneratedValue
    private long id;
    private int rentTime;
    private String car;

    public RentCarEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "RentCar{" +
                "id=" + id +
                ", rentTime=" + rentTime +
                ", car='" + car + '\'' +
                '}';
    }
}
