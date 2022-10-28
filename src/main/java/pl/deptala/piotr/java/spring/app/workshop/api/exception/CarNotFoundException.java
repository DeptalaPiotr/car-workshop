package pl.deptala.piotr.java.spring.app.workshop.api.exception;

public class CarNotFoundException extends Exception{
    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
