/**
 * PieceWorker class represents an employee who earns based on the number of items created and the cost per item.
 * It is a subclass of Employee and inherits its attributes and methods.
 */
public class PieceWorker extends Employee {
    private int costPerItem; // Cost per item for the piece worker
    private int itemsCreated; // Number of items created by the piece worker

    /**
     * Constructs a PieceWorker object with the specified details.
     *
     * @param firstName           First name of the employee
     * @param lastName            Last name of the employee
     * @param socialSecurityNumber Social security number of the employee
     * @param birthDay            Day of birth of the employee
     * @param birthMonth          Month of birth of the employee
     * @param birthYear           Year of birth of the employee
     * @param costPerItem         Cost per item for the employee
     * @param itemsCreated        Number of items created by the employee
     */
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       int birthDay, int birthMonth, int birthYear, int costPerItem, int itemsCreated) {
        super(firstName, lastName, socialSecurityNumber, birthDay, birthMonth, birthYear);
        if (costPerItem < 0) {
            throw new IllegalArgumentException("Item should cost at least 0");
        } else if (itemsCreated < 0) {
            throw new IllegalArgumentException("You must create at least 0 items");
        } else {
            this.costPerItem = costPerItem;
            this.itemsCreated = itemsCreated;
        }
    }

    /**
     * Gets the cost per item for the piece worker.
     *
     * @return Cost per item for the piece worker
     */
    public int getCostPerItem() {
        return this.costPerItem;
    }

    /**
     * Gets the number of items created by the piece worker.
     *
     * @return Number of items created by the piece worker
     */
    public int getItemsCreated() {
        return this.itemsCreated;
    }

    /**
     * Sets the cost per item for the piece worker.
     *
     * @param costPerItem Cost per item to set
     * @throws IllegalArgumentException if the cost per item is negative
     */
    public void setCostPerItem(int costPerItem) {
        if (costPerItem < 0) {
            throw new IllegalArgumentException("Item should cost at least 0");
        } else {
            this.costPerItem = costPerItem;
        }
    }

    /**
     * Sets the number of items created by the piece worker.
     *
     * @param itemsCreated Number of items created to set
     * @throws IllegalArgumentException if the number of items created is negative
     */
    public void setItemsCreated(int itemsCreated) {
        if (itemsCreated < 0) {
            throw new IllegalArgumentException("You must create at least 0 items");
        } else {
            this.itemsCreated = itemsCreated;
        }
    }

    /**
     * Calculates the earnings of the piece worker.
     *
     * @return Earnings of the piece worker
     */
    public double earnings() {
        return (double)(this.costPerItem * this.itemsCreated);
    }

    /**
     * Returns a string representation of the piece worker.
     *
     * @return String representation of the piece worker
     */
    public String toString() {
        return String.format("piece employee: %s%n%s: %d; %s: %d", super.toString(),
                "items created", this.getItemsCreated(), "cost per item", this.getCostPerItem());
    }
}

