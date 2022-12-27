package pl.deptala.piotr.java.spring.app.workshop.api.exception;

public class ServiceNotFoundException extends Exception{
    public ServiceNotFoundException(String message) {
        super(message);
    }

    public ServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
