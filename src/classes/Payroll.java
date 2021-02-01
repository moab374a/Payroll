package classes;
import java.util.ArrayList;
import java.util.List;

public class Payroll {
    //Attributes
    private PayrollDisposition disposition;
    private int payday;

    //Methods
    public Payroll(PayrollDisposition disposition, int payday) {
        if(disposition == null) throw new NullPointerException();

        if(payday <= 0 || payday > 30) throw new IllegalArgumentException();

        this.disposition = disposition;
        this.payday = payday;
    }
    public void doPayroll(PayrollDB db) throws NullPointerException {
        if(db == null) throw new NullPointerException();
        List<Employee> employeeList;
        employeeList = db.getEmployeeList();
        for(Employee e : employeeList) {
            if(e instanceof Appointee && e.isPayday(this.payday)) {
                try {
                    disposition.sendPayment(e, e.calculatePay()-e.calculateDeductions());
                } catch (UnpayableEmployeeException exc){}
            }
        }
    }
}