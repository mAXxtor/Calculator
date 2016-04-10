/**
 * Created by maxxtor on 10.04.2016.
 * This is a class to start the Calculator with user interactions.
 */
import java.util.Scanner;

public class InteractRunner {
    private int firstNumber;           //first arg
    private int secondNumber;          //second arg
    private String operation;         //operation
    private Scanner scanner;        //scan input args throw cmd
    private Calculator calculator;  //copy of Calc
    private String exit;            //exit from Calc
    private String clean;           //clean calc data
    private boolean isClean;        //check is the calc clean?

    public static void main(String[] args) {
        InteractRunner runner = new InteractRunner();
        runner.start();
    }

    /**
     * Constructor
     */
    private InteractRunner() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
        this.isClean = true;
        exit = "no";
    }

    /**
     * Start the calculator
     */
    private void start() {
        while (!exit.equals("yes")) {
            try {
                requestData();
                calculate();
                System.out.println("Result is: " + calculator.getResult());
                requestClean();
                requestExitApp();
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Please input only an integer");
            }
        }
    }

    /**
     * Ask the user "Exit the app?"
     */
    private void requestExitApp() {
        System.out.println("Exit? yes/no");
        exit = scanner.next();
        if (!validateYesNo(exit)) {
            requestExitApp();
        }
    }

    /**
     * Ask the user "Clean the result?"
     */
    private void requestClean() {
        System.out.println("Clean result? yes/no");
        clean = scanner.next();
        if (validateYesNo(clean)) {
            cleanResult();
        } else  {
            requestClean();
        }
    }

    /**
     * Cleaning the result
     */
    private void cleanResult() {
        if (clean.equals("yes")) {
            calculator.cleanResult();
            this.isClean = true;
        } else {
            this.isClean = false;
        }
    }

    /**
     * Request the user data
     */
    private void requestData() {
        if (this.isClean) {
            System.out.println("Enter first arg: ");
            this.firstNumber = Integer.valueOf(scanner.next());
        } else {
            this.firstNumber = 0;
        }
        requestOperator();
        System.out.println("Enter second arg: ");
        this.secondNumber = Integer.valueOf(scanner.next());
    }

    /**
     * Validate the user answer by "yes/no"
     * @param str the user string
     * @return true, if user answer is "yes" or "no"
     */
    private boolean validateYesNo(String str) {
        boolean isValid = true;
        if (!str.equals("yes") && !str.equals("no")) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Request the user input operator
     */
    private void requestOperator() {
        System.out.println("Choose the operation: plus'+', sub'-', multi'*', divide'/'");
        this.operation = scanner.next();
        if (!validateOperator()) {
            requestOperator();
        }
    }

    /**
     * Check the operator input by user
     * @return true, if operator is valid
     */
    private boolean validateOperator() {
        boolean isValid = true;
        char charAt = this.operation.charAt(0);
        if (charAt != '+' && charAt != '-' && charAt != '*' && charAt != '/') {
            isValid = false;
        }
        return isValid;
    }

    private void calculate() {
        switch (operation.charAt(0)) {
            case '+':
                calculator.add(this.firstNumber, this.secondNumber);
                break;
            case '-':
                calculator.sub(this.firstNumber, this.secondNumber);
                break;
            case '*':
                calculator.multiply(this.firstNumber, this.secondNumber);
                break;
            case '/':
                if (this.firstNumber != 0) calculator.divide(this.firstNumber);
                if (this.secondNumber != 0) calculator.divide(this.firstNumber);
                break;
        }
    }
}

