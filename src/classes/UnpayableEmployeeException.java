package classes;
import java.lang.Exception;

public class UnpayableEmployeeException extends Exception {

    public UnpayableEmployeeException(String test_message) {
       super(test_message);
    }

    public UnpayableEmployeeException() {

    }
}
