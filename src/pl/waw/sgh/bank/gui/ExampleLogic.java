package pl.waw.sgh.bank.gui;

import pl.waw.sgh.bank.Account;
import pl.waw.sgh.bank.Bank;
import pl.waw.sgh.bank.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Arrays;

public class ExampleLogic extends ExampleUI {

    private Bank bank = new Bank();

    private Customer curCust = null;

    private JPopupMenu contextMenu;

    public ExampleLogic(JFrame mainWindow) {
        super();
        //
        contextMenu = new JPopupMenu("Operations on accounts");

        JMenuItem newDebitAccount = new JMenuItem("New Debit Account");
        newDebitAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (curCust == null) {
                    JOptionPane.showMessageDialog(null, "Current customer is not set");
                    return;
                }
                Account newAcc = bank.newAccount(curCust, "Debit");
                accountsTableModel.addRow(newAcc);
            }
        });
        JMenuItem newSavingsAccount = new JMenuItem("New Savings Account");
        newSavingsAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (curCust == null) {
                    JOptionPane.showMessageDialog(null, "Current customer is not set");
                    return;
                }
                Account newAcc = bank.newAccount(curCust, "Savings");
                accountsTableModel.addRow(newAcc);
            }
        });
        JMenuItem newCheckingAccount = new JMenuItem("New Checking Account");
        newCheckingAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (curCust == null) {
                    JOptionPane.showMessageDialog(null, "Current customer is not set");
                    return;
                }
                Account newAcc = bank.newAccount(curCust, "Checking");
                accountsTableModel.addRow(newAcc);
            }
        });
        JMenuItem deleteAccount = new JMenuItem("Delete Account");
        deleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int[] accRowsToDel = accTable.getSelectedRows();
                System.out.println("rows to delete:" + Arrays.toString(accRowsToDel));
                for (Integer row : accRowsToDel) {
                    Account acc = accountsTableModel.getAccountByRow(row);
                    bank.deleteAccount(acc);
                }
                // reload accounts for current customer
                accountsTableModel.clearTable();
                accountsTableModel.addRows(bank.findAccountsByCustomer(curCust));
            }
        });

        contextMenu.add(newDebitAccount);
        contextMenu.add(newSavingsAccount);
        contextMenu.add(newCheckingAccount);
        contextMenu.add(deleteAccount);
        accTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (mouseEvent.isPopupTrigger()) {
                    contextMenu.show(mouseEvent.getComponent(),
                            mouseEvent.getX(), mouseEvent.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        addNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                emailTextField.setText("");
                customerIDLabel.setText("NEW");
                accountsTableModel.clearTable();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer curCustID = Integer.parseInt(customerIDLabel.getText());
                    // Existing Customer
                    curCust = bank.findCustomerByID(curCustID);
                    curCust.setFirstName(firstNameTextField.getText());
                    curCust.setLastName(lastNameTextField.getText());
                    curCust.setEmail(emailTextField.getText());
                } catch (NumberFormatException e) {
                    // NEW Customer
                    curCust = bank.newCustomer(firstNameTextField.getText(),
                            lastNameTextField.getText(), emailTextField.getText());
                    customerIDLabel.setText(curCust.getCustomerID().toString());
                }
            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer curCustID = Integer.parseInt(customerIDLabel.getText());
                    Customer prevCust = bank.getPrevCustomer(curCustID);
                    if (prevCust != null) displayCustomer(prevCust);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(mainWindow, "This customer is not saved yet!");
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer curCustID = Integer.parseInt(customerIDLabel.getText());
                    Customer nextCust = bank.getNextCustomer(curCustID);
                    if (nextCust != null) displayCustomer(nextCust);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(mainWindow, "This customer is not saved yet!");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer curCustID = Integer.parseInt(customerIDLabel.getText());
                    Customer prevCust = bank.getPrevCustomer(curCustID);
                    bank.removeCustomer(curCustID);
                    if (prevCust != null) displayCustomer(prevCust);
                    //else displayCustomer(new Customer());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(mainWindow, "This customer is not saved yet!");
                }
            }
        });
    }

    public void displayCustomer(Customer cust) {
        // Pass the customer to display to curCust
        curCust = cust;
        //
        firstNameTextField.setText(cust.getFirstName());
        lastNameTextField.setText(cust.getLastName());
        emailTextField.setText(cust.getEmail());
        customerIDLabel.setText(cust.getCustomerID().toString());
        // Clear and fill the accounts table
        accountsTableModel.clearTable();
        accountsTableModel.addRows(bank.findAccountsByCustomer(cust));
    }

    public JPanel getCustomerMainPanel() {
        return customerMainPanel;
    }

    public static void main(String[] args) {
        JFrame bankFrame = new JFrame("Bank App");
        bankFrame.setSize(500, 400);
        bankFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ExampleLogic exampleLogic = new ExampleLogic(bankFrame);
        bankFrame.add(exampleLogic.getCustomerMainPanel());
        bankFrame.setVisible(true);
    }
}
