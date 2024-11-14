public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private final java.util.Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        if (annualInterestRate <= 0 || numberOfYears <= 0 || loanAmount <= 0)
            throw new IllegalArgumentException("None of the values can be zero or negative. Please try again.");
        else {
            this.annualInterestRate = annualInterestRate;
            this.numberOfYears = numberOfYears;
            this.loanAmount = loanAmount;
            loanDate = new java.util.Date();
        }
    }

    public double getAnnualInterestRate() { return annualInterestRate; }

    public void setAnnualInterestRate(double annualInterestRate) {
        if(annualInterestRate <= 0) throw new IllegalArgumentException("Annual interest rate cannot be zero or negative.");
        else this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() { return numberOfYears; }

    public void setNumberOfYears(int numberOfYears) {
        if(numberOfYears <= 0) throw new IllegalArgumentException("Number of years cannot be zero or negative.");
        else this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() { return loanAmount; }

    public void setLoanAmount(double loanAmount) {
        if(loanAmount <= 0) throw new IllegalArgumentException("Loan amount cannot be zero or negative.");
        else this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate /
                (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    }

    public double getTotalPayment() { return getMonthlyPayment() * numberOfYears * 12; }

    public java.util.Date getLoanDate() { return loanDate; }
}
