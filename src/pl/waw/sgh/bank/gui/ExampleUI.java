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

public class ExampleUI {
    protected JPanel customerMainPanel;
    protected JButton addNewCustomerButton;
    protected JFormattedTextField lastNameTextField;
    protected JFormattedTextField firstNameTextField;
    protected JButton goToAccountActivitiesButton;
    protected JFormattedTextField emailTextField;
    protected JLabel customerIDLabel;
    protected JButton prevButton;
    protected JButton nextButton;
    protected JButton saveButton;
    protected JButton deleteButton;
    protected JTable accTable;


    protected AccountsTableModel accountsTableModel;

    protected void createUIComponents() {
        // TODO: place custom component creation code here
        accountsTableModel = new AccountsTableModel();
        accTable = new JTable(accountsTableModel);
        // Accounts table
    }

}
