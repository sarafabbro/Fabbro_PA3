public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        System.out.println("");

        saver1.calculateMonthlyInterest(2000.00, saver1.modifyInterestRate(4.0));
        saver2.calculateMonthlyInterest(3000.00, saver2.modifyInterestRate(4.0));

        System.out.println("");

        saver1.calculateMonthlyInterest(2000.00, saver1.modifyInterestRate(5.0));
        saver2.calculateMonthlyInterest(3000.00, saver2.modifyInterestRate(5.0));
    }
}
