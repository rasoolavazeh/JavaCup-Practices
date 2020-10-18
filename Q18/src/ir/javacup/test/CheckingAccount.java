package ir.javacup.test;

public class CheckingAccount extends BankAccount{
    private double overDraftAmount;

    public CheckingAccount(String customerNationalId, String accountNumber, double balance, double overDraftAmount) {
        super(customerNationalId, accountNumber, balance);
        this.overDraftAmount = overDraftAmount;
    }

    public double getOverdraftAmount() {
        return overDraftAmount;
    }

    @Override
    public boolean equals(BankAccount obj) {
        if (obj instanceof CheckingAccount) {
            if (this.customerNationalId.equals(obj.getCustomerNationalId())
                && this.accountNumber.equals(getAccountNumber())) {
                return true;
            }
        }
        return false;
    }
}
