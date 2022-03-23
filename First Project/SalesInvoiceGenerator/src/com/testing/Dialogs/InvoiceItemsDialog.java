
package com.testing.Dialogs;

import com.testing.InvoiceGeneratorFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceItemsDialog extends JDialog {
    private JLabel itemNameLbl;
    private JLabel itemPriceLbl;
    private JLabel itemCountLbl;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemCountField;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceItemsDialog(InvoiceGeneratorFrame frame) {
       itemNameLbl = new JLabel("Item Name:");
       itemNameField = new JTextField(30);
       itemPriceLbl = new JLabel("Item Price:");
       itemPriceField = new JTextField(30);
       itemCountLbl = new JLabel("Count:");
       itemCountField = new JTextField(30);
       
       okButton = new JButton("OK");
       cancelButton = new JButton("Cancel");
       okButton.setActionCommand("okCreateLine");
       okButton.addActionListener(frame);
       cancelButton.setActionCommand("cancelCreateLine");
       cancelButton.addActionListener(frame);
        
        setLayout(new GridLayout(4, 2));
        add(itemNameLbl);
        add(itemNameField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(itemCountLbl);
        add(itemCountField);
        add(okButton);
        add(cancelButton);
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }
 
}
