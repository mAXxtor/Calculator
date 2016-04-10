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
     * @param params numbers
     */
    public void add(int ... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }

    /**
     * Subtracts the numbers
     * @param params numbers
     */
    public void sub(int ... params) {
        for (Integer param : params) {
            this.result -= param;
        }
    }

    /**
     * Multiplies the numbers
     * @param params numbers
     */
    public void multiply(int ... params) {
        for (Integer param : params) {
            this.result *= param;
        }
    }

    /**
     * Divides the numbers
     * @param params numbers
     */
    public void divide(int ... params) {
        for (Integer param : params) {
            this.result /= param;
        }
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
