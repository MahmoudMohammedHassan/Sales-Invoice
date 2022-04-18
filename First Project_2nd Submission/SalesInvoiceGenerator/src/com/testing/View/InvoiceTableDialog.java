
package com.testing.View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceTableDialog extends JDialog{
    private JLabel invDateLbl;
    private JLabel customerNameLbl;
    private JTextField invDateField;
    private JTextField customerNameField;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceTableDialog(InvoiceGeneratorFrame frame) {
        invDateLbl = new JLabel("Date:");
        invDateField = new JTextField(30);
        customerNameLbl = new JLabel("Customer Name:");
        customerNameField = new JTextField(30);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        okButton.setActionCommand("okCreateInvoice");
        okButton.addActionListener(frame.getListener());
        cancelButton.setActionCommand("cancelCreateInvoice");
        cancelButton.addActionListener(frame.getListener());
        
        setLayout(new GridLayout(3, 2));
        add(invDateLbl);
        add(invDateField);
        add(customerNameLbl);
        add(customerNameField);
        add(okButton);
        add(cancelButton);
        pack();
    } 

    public JTextField getInvDateField() {
        return invDateField;
    }

    public JTextField getCustomerNameField() {
        return customerNameField;
    }
    
}
