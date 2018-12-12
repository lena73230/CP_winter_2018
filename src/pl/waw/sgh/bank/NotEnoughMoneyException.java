package pl.waw.sgh.bank;

import java.math.BigDecimal;

public class NotEnoughMoneyException extends BankException {

    private BigDecimal balance;

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(BigDecimal balance) {
        super("Not enough money, current balance is: " + balance);
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
