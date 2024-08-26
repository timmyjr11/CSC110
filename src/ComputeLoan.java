import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Introductory statement with name prompt
        System.out.print("""
                Welcome to the Wright Compute Loan Calculator, the Wright way to compute loans!
                We are going to ask for your name, yearly interest rate, number of years, and loan amount!
                Please enter following the syntax given
                First, what is your name? For example Jimmy:""");

        String name = input.nextLine();

        //obtain yearly interest rate
        System.out.print("Enter yearly interest rate, for example 8.25: ");
        double annualInterestRate = input.nextDouble();

        //obtain monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        //obtain number of years
        System.out.print("Enter number of years as an integer, for example 1: ");
        int numberOfYears = input.nextInt();

        //obtain loan amount
        System.out.print("Enter loan amount, for example 120000.95: ");
        double loanAmount = input.nextDouble();

        //calculate payments
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));

        double totalPayment = monthlyPayment * numberOfYears * 12;

        // Output name, monthly and total payments
        System.out.println("\nName: " + name);

        System.out.println("The monthly payment is " +
                (int) (monthlyPayment * 100) / 100.0);

        System.out.print("The total payment is " +
                (int) (totalPayment * 100) / 100.0);
    }
}