package pl.waw.sgh.bank.gui;

import pl.waw.sgh.bank.Bank;
import pl.waw.sgh.bank.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ExampleLogic extends ExampleUI {

    private Bank bank = new Bank();

    public ExampleLogic(JFrame mainWindow) {
        super();
        addNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                emailTextField.setText("");
                customerIDLabel.setText("NEW");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer curCustID = Integer.parseInt(customerIDLabel.getText());
                    // Existing Customer
                    Customer cust = bank.findCustomerByID(curCustID);
                    cust.setFirstName(firstNameTextField.getText());
                    cust.setLastName(lastNameTextField.getText());
                    cust.setEmail(emailTextField.getText());
                } catch (NumberFormatException e) {
                    // NEW Customer
                    Customer newCust = bank.newCustomer(firstNameTextField.getText(),
                            lastNameTextField.getText(), emailTextField.getText());
                    customerIDLabel.setText(newCust.getCustomerID().toString());
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
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(mainWindow, "This customer is not saved yet!");
                }
            }
        });
    }

    public void displayCustomer(Customer cust) {
        firstNameTextField.setText(cust.getFirstName());
        lastNameTextField.setText(cust.getLastName());
        emailTextField.setText(cust.getEmail());
        customerIDLabel.setText(cust.getCustomerID().toString());
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
