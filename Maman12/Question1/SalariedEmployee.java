/**
 * SalariedEmployee class represents an employee who earns a fixed weekly salary.
 * It is a subclass of Employee and inherits its attributes and methods.
 */
public class SalariedEmployee extends Employee {
    private double weeklySalary; // Weekly salary of the salaried employee

    /**
     * Constructs a SalariedEmployee object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     * @param weeklySalary        Weekly salary of the employee
     */
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,
                            int birthDay, int birthMonth, int birthYear, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber, birthDay, birthMonth, birthYear);
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    /**
     * Sets the weekly salary of the employee.
     *
     * @param weeklySalary Weekly salary to set
     * @throws IllegalArgumentException if the weekly salary is negative
     */
    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    /**
     * Gets the weekly salary of the employee.
     *
     * @return Weekly salary of the employee
     */
    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    /**
     * Calculates the earnings of the salaried employee.
     *
     * @return Earnings of the employee (equal to weekly salary)
     */
    public double earnings() {
        return this.getWeeklySalary();
    }

    /**
     * Returns a string representation of the salaried employee.
     *
     * @return String representation of the salaried employee
     */
    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", this.getWeeklySalary());
    }
}

