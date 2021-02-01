package classes;
public interface PayrollDisposition {
    public void sendPayment(Employee empl , double payment) throws UnpayableEmployeeException;
}
