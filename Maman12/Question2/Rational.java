/**
 * Rational class represents a rational number with numerator and denominator.
 * The class provides basic arithmetic operations such as addition, subtraction,
 * multiplication, and division along with comparison methods.
 */
public class Rational {
    private final Integer numerator; // Numerator of the rational number
    private final Integer denominator; // Denominator of the rational number

    /**
     * Constructs a Rational object with given numerator and denominator.
     *
     * @param numerator   Numerator of the rational number
     * @param denominator Denominator of the rational number
     * @throws IllegalArgumentException if numerator or denominator is null or denominator is zero or negative
     * @throws ArithmeticException      if denominator is zero
     */
    public Rational(Integer numerator, Integer denominator) throws IllegalArgumentException, ArithmeticException {
        if (numerator != null && denominator != null) {
            if (denominator == 0) {
                throw new ArithmeticException("Denominator cannot be zero.");
            } else if (denominator < 0) {
                throw new IllegalArgumentException("Denominator must be a positive integer.");
            } else {
                this.numerator = numerator;
                this.denominator = denominator;
            }
        } else {
            throw new IllegalArgumentException("Numerator and denominator must not be null.");
        }
    }

    /**
     * Gets the numerator of the rational number.
     *
     * @return Numerator of the rational number
     */
    public Integer getNumerator() {
        return this.numerator;
    }

    /**
     * Gets the denominator of the rational number.
     *
     * @return Denominator of the rational number
     */
    public Integer getDenominator() {
        return this.denominator;
    }

    /**
     * Returns a string representation of the rational number in the form "numerator/denominator".
     *
     * @return String representation of the rational number
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Checks if this rational number is equal to the specified object.
     *
     * @param o Object to compare
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Rational) {
            Rational rational = (Rational) o;
            return this.numerator * rational.getDenominator() == this.denominator * rational.getNumerator();
        } else {
            return false;
        }
    }

    /**
     * Compares this rational number with the specified rational number.
     *
     * @param other Rational number to compare
     * @return true if this rational number is greater than the specified one, false otherwise
     */
    public boolean greaterThan(Rational other) {
        return this.numerator * other.getDenominator() > this.denominator * other.getNumerator();
    }

    /**
     * Performs the arithmetic operation specified by the sign with the given rational number.
     *
     * @param other Rational number to perform operation with
     * @param sign  Sign of the operation (1 for addition, -1 for subtraction)
     * @return Result of the operation
     */
    private Rational performOperation(Rational other, int sign) {
        int resultNumerator = this.numerator * other.getDenominator() + sign * this.denominator * other.getNumerator();
        int resultDenominator = this.denominator * other.getDenominator();
        return new Rational(resultNumerator, resultDenominator);
    }

    /**
     * Performs addition operation with the specified rational number.
     *
     * @param other Rational number to add
     * @return Result of the addition operation
     * @throws NullPointerException if the specified rational number is null
     */
    public Rational plus(Rational other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("Parameter 'other' cannot be null.");
        } else {
            return this.performOperation(other, 1);
        }
    }

    /**
     * Performs subtraction operation with the specified rational number.
     *
     * @param other Rational number to subtract
     * @return Result of the subtraction operation
     * @throws NullPointerException if the specified rational number is null
     */
    public Rational minus(Rational other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("Parameter 'other' cannot be null.");
        } else {
            return this.performOperation(other, -1);
        }
    }

    /**
     * Performs multiplication operation with the specified rational number.
     *
     * @param other Rational number to multiply
     * @return Result of the multiplication operation
     * @throws NullPointerException if the specified rational number is null
     */
    public Rational multiply(Rational other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("Parameter 'other' cannot be null.");
        } else {
            return new Rational(this.numerator * other.getNumerator(), this.denominator * other.getDenominator());
        }
    }

    /**
     * Performs division operation with the specified rational number.
     *
     * @param other Rational number to divide
     * @return Result of the division operation
     * @throws NullPointerException if the specified rational number is null
     * @throws ArithmeticException  if the specified rational number has zero numerator
     */
    public Rational divide(Rational other) throws NullPointerException, ArithmeticException {
        if (other == null) {
            throw new NullPointerException("Parameter 'other' cannot be null.");
        } else if (other.getNumerator() == 0) {
            throw new ArithmeticException("Cannot divide by zero, numerator of the second rational number should not be 0.");
        } else if (other.getNumerator() < 0) {
            return other.getDenominator() < 0 ?
                    this.multiply(new Rational(Math.abs(other.getDenominator()), Math.abs(other.getNumerator()))) :
                    this.multiply(new Rational(-1 * other.getDenominator(), Math.abs(other.getNumerator())));
        } else {
            return this.multiply(new Rational(other.getDenominator(), other.getNumerator()));
        }
    }

    /**
     * Finds the greatest common divisor (GCD) of two integers.
     *
     * @param a First integer
     * @param b Second integer
     * @return GCD of the two integers
     */
    private int findGCD(int a, int b) {
        return b == 0 ? Math.abs(a) : this.findGCD(b, a % b);
    }

    /**
     * Reduces the rational number to its simplest form.
     *
     * @return Reduced rational number
     */
    public Rational reduce() {
        int a = this.numerator;
        int b = this.denominator;
        int gcd = this.findGCD(a, b);
        return new Rational(this.numerator / gcd, this.denominator / gcd);
    }
}

