/**
 * BasePlusCommissionEmployee class represents an employee who earns a base salary plus commissions based on gross sales.
 * It is a subclass of CommissionEmployee and inherits its attributes and methods.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // Base salary of the base plus commission employee

    /**
     * Constructs a BasePlusCommissionEmployee object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     * @param grossSales          Gross sales of the employee
     * @param commissionRate      Commission rate of the employee
     * @param baseSalary          Base salary of the employee
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      int birthDay, int birthMonth, int birthYear, double grossSales,
                                      double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, birthDay, birthMonth, birthYear, grossSales, commissionRate);
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    /**
     * Sets the base salary of the employee.
     *
     * @param baseSalary Base salary to set
     * @throws IllegalArgumentException if the base salary is negative
     */
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    /**
     * Gets the base salary of the employee.
     *
     * @return Base salary of the employee
     */
    public double getBaseSalary() {
        return this.baseSalary;
    }

    /**
     * Calculates the earnings of the base plus commission employee.
     *
     * @return Earnings of the employee
     */
    public double earnings() {
        return this.getBaseSalary() + super.earnings();
    }

    /**
     * Returns a string representation of the base plus commission employee.
     *
     * @return String representation of the base plus commission employee
     */
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", this.getBaseSalary());
    }
}
