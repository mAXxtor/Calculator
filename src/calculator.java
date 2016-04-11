/**
 * The class realize the calculator.
 */
public class Calculator {

    /**
     * The calculation result.
     */
    private int result;

    /**
     * Summarizes the numbers
     */
    public void add(int a, int b) {
            this.result = a + b;
    }

    /**
     * Subtracts the numbers
     */
    public void sub(int a, int b) {
        this.result = a - b;
    }

    /**
     * Multiplies the numbers
     */
    public void multiply(int a, int b) {
            this.result = a * b;
    }

    /**
     * Divides the numbers
     */
    public void divide(int a, int b) {
            this.result = a / b;
    }

    /**
     * Get the result.
     * @return the calculation result.
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Clean the calculation result.
     */
    public void cleanResult() {
        this.result = 0;
    }
}
