package classes;
public class Appointee extends Employee {
    private int payday;
    private int hoursPerMonth;
    private double payPerHour;



    public Appointee(String id , int payday ,  int hoursPerMonth , double payPerHour) {
        super(id);
        if (payday < 1 || payday > 30 )throw new IllegalArgumentException("");
        if (hoursPerMonth <= 0 )throw new IllegalArgumentException();
        if (payPerHour <= 0 )throw new IllegalArgumentException();

        this.payday = payday;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;

    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 30 )throw new IllegalArgumentException();

        if (dayOfMonth == payday) {
            return true;
        }
        return false;
    }

/*  The Appointee, on the other hand, has a contract which requires him
    to work a certain number of hours each month and
    grants him a certain hourly salary. However, 40 percent of the money
    the Appointee would theoretically receive are used
    for things like the employee’s social insurance.*/

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        double salaryOfAppointee;
        if(hoursPerMonth > 0 )
        {
            salaryOfAppointee = ( payPerHour * hoursPerMonth) - 40 / 100 * ( payPerHour * hoursPerMonth)  ;

        } else throw new UnpayableEmployeeException();

        return salaryOfAppointee ;
    }

    @Override
    public double calculateDeductions() {
        try {
            return this.calculatePay()* .4;
        } catch (UnpayableEmployeeException e) {
            e.printStackTrace();
            return 0.0;
        }

    }


}
