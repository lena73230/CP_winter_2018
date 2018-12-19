package pl.waw.sgh.bank.gui;

import pl.waw.sgh.bank.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExampleLogic extends ExampleUI {

    private Bank bank = new Bank();

    public ExampleLogic() {
        super();
        addNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //formattedTextField1
            }
        });
    }

    public JPanel getCustomerMainPanel() {
        return customerMainPanel;
    }

    public static void main(String[] args) {
        JFrame bankFrame = new JFrame("Bank App");
        bankFrame.setSize(500, 400);
        bankFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ExampleLogic exampleLogic = new ExampleLogic();
        bankFrame.add(exampleLogic.getCustomerMainPanel());
        bankFrame.setVisible(true);
    }
}
