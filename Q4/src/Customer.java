public class Customer {
    private String name;
    private Account account;
    private CreditCard creditCard;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Account getAccount() {
        return account;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public double calCustomerBalance() {
        return account.getBalance() + creditCard.getCredit();
    }
}
