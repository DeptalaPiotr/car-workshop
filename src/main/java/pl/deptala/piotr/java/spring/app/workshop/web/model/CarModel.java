package pl.deptala.piotr.java.spring.app.workshop.web.model;

import javax.validation.constraints.NotEmpty;

public class CarModel {

    private Long id;
    @NotEmpty(message = "Wprowadź markę samochodu")
    private String brand;
    @NotEmpty(message = "Wprowadź kolor samochodu")
    private String color;

    private UserModel owner;

    public CarModel() {
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

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }
}
