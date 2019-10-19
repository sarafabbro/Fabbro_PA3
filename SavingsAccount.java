public class SavingsAccount{
    private static double annualInterestRate;
    private double savingsBalance;
    public void calculateMonthlyInterest(double savings, double interest){
        double monthlyInterest;
        monthlyInterest = savings + (savings*interest)/12.0;
        System.out.println(monthlyInterest);
    }
    public double modifyInterestRate(double newInterest){
        annualInterestRate=newInterest/100.0;
        return annualInterestRate;
    }
}
