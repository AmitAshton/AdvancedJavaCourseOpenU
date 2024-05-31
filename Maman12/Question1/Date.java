/**
 * Date class represents a date with day, month, and year components.
 * It provides methods to validate and manipulate dates.
 */
public class Date {
    private final int month; // Month of the date
    private final int day; // Day of the date
    private final int year; // Year of the date
    private static final int[] daysPerMonth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Constructs a Date object with the specified day, month, and year.
     *
     * @param day   Day of the date
     * @param month Month of the date
     * @param year  Year of the date
     * @throws IllegalArgumentException if the date components are invalid
     */
    public Date(int day, int month, int year) {
        if (month > 0 && month <= 12) {
            if (day > 0 && (day <= daysPerMonth[month] || month == 2 && day == 29)) {
                if (month != 2 || day != 29 || year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
                    this.month = month;
                    this.day = day;
                    this.year = year;
                } else {
                    throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
                }
            } else {
                throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
            }
        } else {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        }
    }

    /**
     * Gets the month component of the date.
     *
     * @return Month of the date
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Gets the day component of the date.
     *
     * @return Day of the date
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Gets the year component of the date.
     *
     * @return Year of the date
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Returns a string representation of the date in the format "day/month/year".
     *
     * @return String representation of the date
     */
    public String toString() {
        return String.format("%d/%d/%d", this.day, this.month, this.year);
    }
}