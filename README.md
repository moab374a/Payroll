# Payroll

![Payroll_ClassDiagram](https://user-images.githubusercontent.com/44247875/107162639-09cecc00-69a5-11eb-8773-a9e2bb0657ea.jpg)

A software for the monthly payroll of employees in a company. This software is divided into two parts: The employee management and the actual payroll management.

On the employee side, we have the abstract class Employee with an identifier (id) and three abstract methods. isPayday() determines whether the given day is the payday of the employee.
The payday of an employee is an integer value between 1 and 30.
calculatePay() generally determines the (gross) salary of the employee, but in some cases throws an UnpayableEmployeeException instead.
Because this type of Exception is a so called checked exception, it has to be included in the method signature of calculatePay() via the throws keyword.
Finally, calculateDeductions() determines the employee’s deductions, i.e. the difference between gross and net salary.

As you can see in the class diagram , Employee has two subclasses: Volunteer and Appointee.
The basic difference is that the Volunteer does not receive any payment which is why he does not have a payday or any deductions. Hence, calling calculatePay() on a Volunteer causes an UnpayableEmployeeException to be thrown.

The Appointee, on the other hand, has a contract which requires him to work a certain number of hours each month and grants him a certain hourly salary. However, 40 percent of the money the Appointee would theoretically receive are used for things like the employee’s social insurance.

The actual payroll management is done by the class Payroll in combination with a PayrollDisposition. 
The method doPayroll() retrieves the list of employees from a PayrollDB and calls sendPayment() for each Employee to submit the respective salary.

As an example for the implementation of the interface PayrollDisposition, we use the class PayrollDispositionImpl. 
It keeps each sent payment in a java.util.Map that maps Employees to their payment figure. Additionally, PayrollDispositionImpl provides methods which calculate the total amount of money used for payments as well as the average amount of money paid to the employees.
