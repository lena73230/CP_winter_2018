package pl.waw.sgh.bank.gui;

import pl.waw.sgh.bank.Account;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AccountsTableModel extends DefaultTableModel {

    private static String[] cols = {"ID", "Type", "Currency", "Balance"};

    private List<Account> accountList = new ArrayList<>();

    public AccountsTableModel() {
        super(cols, 0);
    }

    public void addRow(Account account) {
        accountList.add(account);
        addRow(getVectorFromAccount(account));
        fireTableDataChanged();
    }

    public void addRows(List<Account> accountList) {
        for (Account acc : accountList) {
            addRow(acc);
        }
    }

    public void clearTable() {
        accountList.clear();
        dataVector.clear();
        fireTableDataChanged();
    }

    public Vector getVectorFromAccount(Account account) {
        Vector vc = new Vector();
        vc.add(account.getAccountID());
        vc.add(account.getClass().getSimpleName().
                replace("Account", ""));
        vc.add(account.getCurrency());
        vc.add(account.getBalance());
        return vc;
    }


    @Override
    public boolean isCellEditable(int row, int col) {
        if (col <= 1) return false;
        else return true;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        super.setValueAt(o, row, col);
        Account acc = accountList.get(row);
        switch (col) {
            case 2:
                acc.setCurrency(o.toString());
                return;
            case 3:
                acc.setBalance((BigDecimal) o);
        }

    }

    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
                return Integer.class;
            case 3:
                return BigDecimal.class;
            default:
                return String.class;
        }
    }
}
