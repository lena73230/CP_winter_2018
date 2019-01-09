package pl.waw.sgh.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> custList = new ArrayList<>();

    private List<Account> accList = new ArrayList<>();

    private Integer lastCustID = 0;

    private Integer lastAccID = 100;

    // Public API
    public Customer newCustomer(String firstName,
                                String lastName,
                                String email) {
        Customer cust = new Customer(lastCustID++, firstName,
                lastName, email);
        custList.add(cust);
        return cust;
    }

    public Account newAccount(Customer cust, String accType) {
        Account acc;
        switch (accType) {
            case "Savings":
                acc = new SavingsAccount(lastAccID++, 0.0, cust);
                break;
            case "Debit":
                acc = new DebitAccount(lastAccID++, 0.0, cust);
                break;
            default:
                acc = new CheckingAccount(lastAccID++, 0.0, cust);
        }
        accList.add(acc);
        return acc;
    }

    private Account findAccountByID(Integer accID) throws NonExistingAccountException {
        for (Account acc : accList) {
            if (acc.getAccountID().equals(accID)) {
                return acc;
            }
        }
        throw new NonExistingAccountException(accID);
    }

    private ArrayList<Account> findAccountsByCustomer(Customer customer) {
        ArrayList<Account> customerAccList = new ArrayList<Account>();
        for (Account acc : accList) {
            if (acc.getCustomer().equals(customer)) {
                customerAccList.add(acc);
            }
        }
        return customerAccList;
    }


    public void transfer(Integer fromAccID, Integer toAccID,
                         Double amount) throws NotEnoughMoneyException, NonExistingAccountException {
        Account fromAcc = findAccountByID(fromAccID);
        Account toAcc = findAccountByID(toAccID);
        try {
            fromAcc.charge(amount);
            toAcc.deposit(amount);
        } catch (NotEnoughMoneyException e) {
            ArrayList<Account> customerAccList = findAccountsByCustomer(fromAcc.getCustomer());
            for (Account acc : customerAccList) {
                if (acc.getBalance().compareTo(BigDecimal.valueOf(amount)) >= 0) {
                    acc.charge(amount);
                    toAcc.deposit(amount);
                    return;
                }
            }
            throw new NotEnoughMoneyException("There is not enough money on either of your accounts");
        }
    }


































    public Customer findCustomerByID(Integer curCustID) {
        for (Customer cust : custList) {
            if (cust.getCustomerID().equals(curCustID))
                return cust;
        }
        return null;
    }

    private int findCurCustIdx(Integer curCustID) {
        for (Customer cust : custList) {
            if (cust.getCustomerID().equals(curCustID))
                return custList.indexOf(cust);
        }
        return -1;
    }

    public void removeCustomer(Integer custToRemoveID) {
        int custToRemoveIdx = findCurCustIdx(custToRemoveID);
        custList.remove(custToRemoveIdx);
    }

    public Customer getPrevCustomer(Integer curCustID) {
        int curCustIdx = findCurCustIdx(curCustID);
        if (curCustIdx > 0)
            return custList.get(curCustIdx - 1);
        else
            return null;
    }

    public Customer getNextCustomer(Integer curCustID) {
        int curCustIdx = findCurCustIdx(curCustID);
        if (curCustIdx < custList.size() - 1)
            return custList.get(curCustIdx + 1);
        else
            return null;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "custs=\n" + custList +
                ",\naccs=\n" + accList +
                '}';
    }
}