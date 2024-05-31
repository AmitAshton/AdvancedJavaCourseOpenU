/**
 * HourlyEmployee class represents an employee who earns wages based on the number of hours worked.
 * It is a subclass of Employee and inherits its attributes and methods.
 */
public class HourlyEmployee extends Employee {
    private double wage; // Hourly wage of the hourly employee
    private double hours; // Hours worked by the hourly employee

    /**
     * Constructs an HourlyEmployee object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     * @param wage                Hourly wage of the employee
     * @param hours               Hours worked by the employee
     */
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
                          int birthDay, int birthMonth, int birthYear, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber, birthDay, birthMonth, birthYear);
        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        } else if (!(hours < 0.0) && !(hours > 168.0)) {
            this.wage = wage;
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
    }

    /**
     * Sets the hourly wage of the employee.
     *
     * @param wage Hourly wage to set
     * @throws IllegalArgumentException if the hourly wage is negative
     */
    public void setWage(double wage) {
        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        } else {
            this.wage = wage;
        }
    }

    /**
     * Gets the hourly wage of the employee.
     *
     * @return Hourly wage of the employee
     */
    public double getWage() {
        return this.wage;
    }

    /**
     * Sets the hours worked by the employee.
     *
     * @param hours Hours worked to set
     * @throws IllegalArgumentException if the hours worked are negative or exceed 168
     */
    public void setHours(double hours) {
        if (!(hours < 0.0) && !(hours > 168.0)) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
    }

    /**
     * Gets the hours worked by the employee.
     *
     * @return Hours worked by the employee
     */
    public double getHours() {
        return this.hours;
    }

    /**
     * Calculates the earnings of the hourly employee.
     *
     * @return Earnings of the employee
     */
    public double earnings() {
        return this.getHours() <= 40.0 ? this.getWage() * this.getHours() :
                40.0 * this.getWage() + (this.getHours() - 40.0) * this.getWage() * 1.5;
    }

    /**
     * Returns a string representation of the hourly employee.
     *
     * @return String representation of the hourly employee
     */
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(),
                "hourly wage", this.getWage(), "hours worked", this.getHours());
    }
}
