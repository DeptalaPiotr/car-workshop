package pl.deptala.piotr.java.spring.app.workshop.web.model;

public class ServiceModel {

    private double price;
    private String date;
    private String name;

    public ServiceModel() {
    }

    public ServiceModel(double price, String date, String name) {
        this.price = price;
        this.date = date;
        this.name = name;
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
        return "ServiceModel{" +
                "price=" + price +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
