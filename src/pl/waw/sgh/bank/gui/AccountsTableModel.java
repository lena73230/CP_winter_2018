package pl.waw.sgh.bank.gui;

import pl.waw.sgh.bank.Account;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AccountsTableModel extends DefaultTableModel {

    private String[] cols = {"ID", "Type", "Currency", "Balance"};

    private List<Account> accountList = new ArrayList<>();

    public void addRow(Account account) {
        accountList.add(account);
        addRow(getVectorFromAccount(account));
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
        return super.isCellEditable(row, col);
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        super.setValueAt(o, row, col);
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return super.getColumnClass(col);
    }
}
