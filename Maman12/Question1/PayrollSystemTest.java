import java.util.ArrayList;
import java.util.Calendar;

/**
 * PayrollSystemTest class is a test class to demonstrate the functionality of the payroll system.
 * It creates instances of different types of employees and calculates their earnings.
 */
public class PayrollSystemTest {

    public static void main(String[] args) {

        // Create instances of different types of employees
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith",
                "111-11-1111", 14, 6, 2006, 800.0);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price",
                "222-22-2222", 19, 4, 1977, 16.75, 40.0);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones",
                "333-33-3333", 21, 1, 2002, 10000.0, 0.06);

        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob",
                "Lewis", "444-44-4444", 25, 4,
                1968, 3000.0, 0.04, 7500.0);

        PieceWorker pieceWorkerEmployee = new PieceWorker("Amit", "Ashton",
                "555-55-5555", 17, 4, 1997, 45, 15);

        // Create an ArrayList to store the employees
        ArrayList<Employee> employees = new ArrayList<>();

        // Add employees to the ArrayList
        employees.add(salariedEmployee);
        employees.add(hourlyEmployee);
        employees.add(commissionEmployee);
        employees.add(basePlusCommissionEmployee);
        employees.add(pieceWorkerEmployee);

        // Get the current month
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        // Iterate over the employees and display their information
        for(Employee currentEmployee: employees) {

            // Print employee information
            System.out.println(currentEmployee);

            // Check if it's the employee's birth month
            if (currentMonth == currentEmployee.getDateOfBirth().getMonth()) {
                // If it's the birth month, add 200 NIS to earnings
                double earnings = currentEmployee.earnings();
                System.out.println("Earnings (+200 NIS for your birthday!): " + (earnings + 200.0) + "\n\n");
            } else {
                // If it's not the birth month, display regular earnings
                System.out.println("Earnings: " + currentEmployee.earnings() + "\n\n");
            }
        }
    }
}
