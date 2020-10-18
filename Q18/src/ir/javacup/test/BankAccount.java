package ir.javacup.test;

public class BankAccount {
    protected String customerNationalId;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String customerNationalId, String accountNumber, double balance) {
        this.customerNationalId = customerNationalId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double v) {
        if (v < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        } else if (v > balance) {
            throw new IllegalArgumentException("Your balance is not enough");
        } else {
            balance -= v;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerNationalId() {
        return customerNationalId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double v) {
        balance += v;
    }

    public boolean equals(BankAccount obj) {
        if (this.customerNationalId.equals(obj.getCustomerNationalId())
                && this.accountNumber.equals(obj.getAccountNumber())) {
            return true;
        }
        return false;
    }

}
