package ir.javacup.test;

public class SavingAccount extends BankAccount{
    private double interestAmount;

    public SavingAccount(String customerNationalId, String accountNumber, double balance, double interestAmount) {
        super(customerNationalId, accountNumber, balance);
        this.interestAmount = interestAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void addInterest() {
        double interest = balance * interestAmount;
        balance += interest;
    }

    @Override
    public boolean equals(BankAccount obj) {
        if (obj instanceof SavingAccount) {
            if (this.customerNationalId.equals(obj.getCustomerNationalId())
                && this.accountNumber.equals(obj.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }
}
