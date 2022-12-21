package pl.deptala.piotr.java.spring.app.workshop.web.model;

public class BayACarModel {
    private int price;
    public String car;

    public BayACarModel() {
    }

    public BayACarModel(int price, String car) {
        this.price = price;
        this.car = car;
    }

    public int getPrice() {
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
        return "BayACarModel{" +
                "price=" + price +
                ", car='" + car + '\'' +
                '}';
    }
}
