package pl.waw.sgh.bank;

public class PlayWithBank {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = bank.newCustomer("John",
                "Brown", "john@brown.com");
        Customer c2 = bank.newCustomer("Anna",
                "Smith", "anna@smith.com");
        Account a1 = bank.newAccount(c1, "Debit");
        Account a2 = bank.newAccount(c1, "Savings");
        Account a3 = bank.newAccount(c1, "");

        Account a4 = bank.newAccount(c2, "Debit");
        Account a5 = bank.newAccount(c2, "Savings");
        a1.deposit(150.0);
        a2.deposit(100.0);
        a2.charge(25.0);

        // Transfer 50.00 from accID 100 to 102
        bank.transfer(100, 102, 50.00);

        System.out.println(bank);

    }
}
