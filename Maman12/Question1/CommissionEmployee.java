/**
 * CommissionEmployee class represents an employee who earns commissions based on gross sales.
 * It is a subclass of Employee and inherits its attributes and methods.
 */
public class CommissionEmployee extends Employee {
    private double grossSales; // Gross sales of the commission employee
    private double commissionRate; // Commission rate of the commission employee

    /**
     * Constructs a CommissionEmployee object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     * @param grossSales          Gross sales of the employee
     * @param commissionRate      Commission rate of the employee
     */
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              int birthDay, int birthMonth, int birthYear, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber, birthDay, birthMonth, birthYear);
        if (!(commissionRate <= 0.0) && !(commissionRate >= 1.0)) {
            if (grossSales < 0.0) {
                throw new IllegalArgumentException("Gross sales must be >= 0.0");
            } else {
                this.grossSales = grossSales;
                this.commissionRate = commissionRate;
            }
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    /**
     * Sets the gross sales of the employee.
     *
     * @param grossSales Gross sales to set
     * @throws IllegalArgumentException if the gross sales are negative
     */
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        } else {
            this.grossSales = grossSales;
        }
    }

    /**
     * Gets the gross sales of the employee.
     *
     * @return Gross sales of the employee
     */
    public double getGrossSales() {
        return this.grossSales;
    }

    /**
     * Sets the commission rate of the employee.
     *
     * @param commissionRate Commission rate to set
     * @throws IllegalArgumentException if the commission rate is not in the range (0, 1)
     */
    public void setCommissionRate(double commissionRate) {
        if (!(commissionRate <= 0.0) && !(commissionRate >= 1.0)) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    /**
     * Gets the commission rate of the employee.
     *
     * @return Commission rate of the employee
     */
    public double getCommissionRate() {
        return this.commissionRate;
    }

    /**
     * Calculates the earnings of the commission employee.
     *
     * @return Earnings of the employee
     */
    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    /**
     * Returns a string representation of the commission employee.
     *
     * @return String representation of the commission employee
     */
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", this.getGrossSales(), "commission rate", this.getCommissionRate());
    }
}
