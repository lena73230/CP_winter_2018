package pl.waw.sgh.bank;

import javax.swing.*;
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

    public void deleteAccount(Account accToDel) {
        accList.remove(accToDel);
    }

    private Account findAccountByID(Integer accID) {
        for (Account acc : accList) {
            if (acc.getAccountID().equals(accID))
                return acc;
        }
        return null;
    }

    public List<Account> findAccountsByCustomer(Customer customer) {
        List<Account> newAccList = new ArrayList<>();
        for (Account acc : accList) {
            if (acc.getCustomer().equals(customer))
                newAccList.add(acc);
        }
        return newAccList;
    }

    public void transfer(Integer fromAccID, Integer toAccID,
                         Double amount) throws NotEnoughMoneyException {
        Account fromAcc = findAccountByID(fromAccID);
        Account toAcc = findAccountByID(toAccID);
        fromAcc.charge(amount);
        toAcc.deposit(amount);
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
        Customer custToDel = findCustomerByID(custToRemoveID);
        List<Account> accOfCustToDel = findAccountsByCustomer(custToDel);
        if (!accOfCustToDel.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Customer has accounts and therefore cannot be deleted");
            return;
        }
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
