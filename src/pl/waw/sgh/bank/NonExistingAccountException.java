package pl.waw.sgh.bank;

public class NonExistingAccountException extends BankException {

    private Integer accountID;

    public NonExistingAccountException(String message) {
        super(message);
    }

    public NonExistingAccountException(Integer accountID) {
        super("No such account exists, requested account ID: " + accountID);
        this.accountID = accountID;
    }

    public Integer getAccountID() {
        return accountID;
    }
}
