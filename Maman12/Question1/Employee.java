/**
 * Employee class represents a generic employee with basic information such as name, social security number,
 * and date of birth. It is an abstract class providing a blueprint for concrete employee types.
 */
public abstract class Employee {
    private final String firstName; // First name of the employee
    private final String lastName; // Last name of the employee
    private final String socialSecurityNumber; // Social security number of the employee
    private final Date dateOfBirth; // Date of birth of the employee

    /**
     * Constructs an Employee object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber, int birthDay, int birthMonth, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBirth = new Date(birthDay, birthMonth, birthYear);
    }

    /**
     * Gets the first name of the employee.
     *
     * @return First name of the employee
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return Last name of the employee
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the social security number of the employee.
     *
     * @return Social security number of the employee
     */
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    /**
     * Gets the date of birth of the employee.
     *
     * @return Date of birth of the employee
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return String representation of the employee
     */
    public String toString() {
        return String.format("%s %s%nsocial security number: %s%nbirthday: %s", this.getFirstName(), this.getLastName(),
                this.getSocialSecurityNumber(), this.getDateOfBirth().toString());
    }

    /**
     * Abstract method to calculate earnings of the employee.
     *
     * @return Earnings of the employee
     */
    public abstract double earnings();
}
