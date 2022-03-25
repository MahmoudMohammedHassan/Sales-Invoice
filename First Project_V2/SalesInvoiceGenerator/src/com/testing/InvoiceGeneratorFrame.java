/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.testing;

import com.testing.Dialogs.InvoiceItemsDialog;
import com.testing.Dialogs.InvoiceTableDialog;
import com.testing.version.InvoiceHeader;
import com.testing.version.InvoiceHeaderTable;
import com.testing.version.InvoiceLineTable;
import com.testing.version.InvoiceLines;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mahmoud Mohammed
 */
public class InvoiceGeneratorFrame extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    /**
     * Creates new form InvoiceGeneratorFrame
     */
    public InvoiceGeneratorFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CustNameTF = new javax.swing.JTextField();
        InvDateTF = new javax.swing.JTextField();
        InvNumLbl = new javax.swing.JLabel();
        InvTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLinesTable = new javax.swing.JTable();
        createNewLine = new javax.swing.JButton();
        createNewLine.addActionListener(this);
        deleteLine = new javax.swing.JButton();
        deleteLine.addActionListener(this);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoicesTable.setToolTipText("");
        jScrollPane1.setViewportView(invoicesTable);
        invoicesTable.getAccessibleContext().setAccessibleName("");

        createInvBtn.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("CreateNewInvoice");

        deleteInvBtn.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.setActionCommand("DeleteInvoice");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Invoice Number");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Invoice Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Invoice Total");

        InvNumLbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        InvTotalLbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        invLinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLinesTable);

        createNewLine.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        createNewLine.setText("Create New Line");
        createNewLine.setActionCommand("CreateNewLine");

        deleteLine.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        deleteLine.setText("Delete Line");
        deleteLine.setActionCommand("DeleteLine");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Invoices Table");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Invoice Items");

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(300, 300, 300))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(createInvBtn)
                        .addGap(77, 77, 77)
                        .addComponent(deleteInvBtn)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(InvTotalLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(InvNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InvDateTF, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(CustNameTF))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createNewLine)
                .addGap(73, 73, 73)
                .addComponent(deleteLine)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(InvNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createInvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteInvBtn))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(InvDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CustNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(InvTotalLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createNewLine)
                            .addComponent(deleteLine))
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGeneratorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CustNameTF;
    private javax.swing.JTextField InvDateTF;
    private javax.swing.JLabel InvNumLbl;
    private javax.swing.JLabel InvTotalLbl;
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createNewLine;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteLine;
    private javax.swing.JTable invLinesTable;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    
    private List<InvoiceHeader> invoiceList = new ArrayList<>();
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private InvoiceHeaderTable invoiceHeaderTable;
    private InvoiceLineTable invoiceLinesTable;
    private InvoiceTableDialog invDialog;
    private InvoiceItemsDialog itemDialog;
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        switch (e.getActionCommand()){
            case "LoadFile":
                loadFile();
                break;
          case "SaveFile":
              saveFile();
               break;
            case "CreateNewInvoice":
                viewNewInvDialog();
                break;
           case "DeleteInvoice":
                deleteSelectedInvoice();
               break;
            case "CreateNewLine":
                viewNewItemDialog();
                break;
           case "DeleteLine":  
               deleteSelectedLine(); 
               break;
            case "okCreateInvoice":
                okCreateInvoice();
                break;
            case "cancelCreateInvoice":
                cancelCreateInvoice();
                break;
            case "okCreateLine":
                okCreateLine();
                break;
            case "cancelCreateLine":
                cancelCreateLine();
                break;                
        }
    }
    
    private void loadFile(){
        
        JOptionPane.showMessageDialog(this, "Please select the header file.", "Invoices File Selection", JOptionPane.PLAIN_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int action = openFile.showOpenDialog(this);
        if (action == JFileChooser.APPROVE_OPTION){
            File hFile = openFile.getSelectedFile();
            try {
            BufferedReader hReader  = new BufferedReader(new FileReader(hFile));
            String hLine = null;
            
            while ((hLine = hReader.readLine()) != null){
                String [] hParts = hLine.split(",");
                String invNumString = hParts[0];
                String invDateString = hParts[1];
                String customerName = hParts[2];
                
                int invNum = Integer.parseInt(invNumString);
                Date invDate = dateFormat.parse(invDateString);
                
                InvoiceHeader invoice = new InvoiceHeader(invNum, invDate, customerName);
                invoiceList.add(invoice);   
            }
            
                JOptionPane.showMessageDialog(this, "Please select the lines file.", "Invoice Items File Selection", JOptionPane.PLAIN_MESSAGE);
                action = openFile.showOpenDialog(this);
                if (action == JFileChooser.APPROVE_OPTION ){
                File lFile = openFile.getSelectedFile();
                BufferedReader lReader = new BufferedReader(new FileReader(lFile));
                String lLine = null;
                while ((lLine = lReader.readLine()) != null){
                    String[] lParts = lLine.split(",");
                    String invNumString = lParts[0];
                    String itemName = lParts[1];
                    String itemPriceString = lParts[2];
                    String itemCountString = lParts[3];
                            
                    int invNum = Integer.parseInt(invNumString);
                    double itemPrice = Double.parseDouble(itemPriceString);
                    int itemCount = Integer.parseInt(itemCountString);
                    
                    InvoiceHeader header = defineInvoiceByInvNum(invNum);
                    InvoiceLines invoiceLine = new InvoiceLines(itemName, itemPrice, itemCount, header);
                    header.getLines().add(invoiceLine);
                }
                
                invoiceHeaderTable = new InvoiceHeaderTable(invoiceList);
                invoicesTable.setModel(invoiceHeaderTable);
                invoicesTable.validate();
            }
     
             } catch (Exception e) {
                 e.printStackTrace();
            }
        }    
        
        printOutInvoices();
    }
    
    private InvoiceHeader defineInvoiceByInvNum(int invNum){
        InvoiceHeader header = null;
        for(InvoiceHeader  invoice: invoiceList ){
            if (invNum == invoice.getInvNum()){
                header = invoice;
                break;
            }
        }
     return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        invoiceTableSelectedRow();
        
    }

    private void invoiceTableSelectedRow() {
        int SelectedRow = invoicesTable.getSelectedRow();
        if (SelectedRow >= 0){
            InvoiceHeader rowIndex = invoiceHeaderTable.getInvoiceList().get(SelectedRow);
            InvNumLbl.setText("" + rowIndex.getInvNum());
            InvDateTF.setText(dateFormat.format(rowIndex.getInvDate()));
            CustNameTF.setText(rowIndex.getCustomerName());
            InvTotalLbl.setText("" + rowIndex.getInvTotal());
            ArrayList<InvoiceLines> invLines = rowIndex.getLines();
            invoiceLinesTable = new InvoiceLineTable(invLines);
            invLinesTable.setModel(invoiceLinesTable);
           
            
        }
    }

    private void viewNewInvDialog() {
        invDialog = new InvoiceTableDialog(this);
        invDialog.setVisible(true);
    } 
    
    private void viewNewItemDialog() {
    itemDialog = new InvoiceItemsDialog(this);
    itemDialog.setVisible(true);
    }
    
    private void okCreateInvoice() {
            String invDateString = invDialog.getInvDateField().getText();
            String customerName = invDialog.getCustomerNameField().getText();
            invDialog.setVisible(false);
            invDialog.dispose();
            invDialog =null;
            try{
                Date invDate = dateFormat.parse(invDateString);
                int invNum = getNewInvNum();
                InvoiceHeader invHeader = new InvoiceHeader(invNum, invDate, customerName);
                invoiceList.add(invHeader);
                invoiceHeaderTable.fireTableDataChanged();
            }catch(ParseException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error : Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            printOutInvoices();
    }

    private void cancelCreateInvoice() {
            invDialog.setVisible(false);
            invDialog.dispose();
            invDialog =null;
            
            printOutInvoices();
    }

    private int getNewInvNum() {
            int lastInvNum = 0;
            for(InvoiceHeader header: invoiceList){
                if(header.getInvNum()>lastInvNum){
                    lastInvNum = header.getInvNum();
                }
            }
            return lastInvNum + 1;
    }

    private void okCreateLine() {
        String itemName = itemDialog.getItemNameField().getText();
        String itemPriceString = itemDialog.getItemPriceField().getText();
        String itemCountString = itemDialog.getItemCountField().getText();
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog =null;
        double itemPrice = Double.parseDouble(itemPriceString);
        int itemCount = Integer.parseInt(itemCountString);
        int invNumIndex = invoicesTable.getSelectedRow();
        InvoiceHeader inv = invoiceHeaderTable.getInvoiceList().get(invNumIndex);
        InvoiceLines invLine = new InvoiceLines(itemName, itemPrice, itemCount, inv);
        inv.addInvLine(invLine);
        invoiceLinesTable.fireTableDataChanged();
        invoiceHeaderTable.fireTableDataChanged();
        InvTotalLbl.setText("" + inv.getInvTotal());
        
        printOutInvoices();
    }

    private void cancelCreateLine() {
            itemDialog.setVisible(false);
            itemDialog.dispose();
            itemDialog =null;
            
            printOutInvoices();
    }   

    private void deleteSelectedLine() {
            int selectedLineIndex = invLinesTable.getSelectedRow();
            invoiceLinesTable.getInvoiceLines().remove(selectedLineIndex);
            invoiceLinesTable.fireTableDataChanged();
            invoiceHeaderTable.fireTableDataChanged();
            InvoiceLines lineSelected = invoiceLinesTable.getInvoiceLines().get(selectedLineIndex);
            InvTotalLbl.setText("" + lineSelected.getHeader().getInvTotal());
            
            printOutInvoices();
    }
    
    private void deleteSelectedInvoice() {
            int selectedInvoiceIndex = invoicesTable.getSelectedRow();
            invoiceHeaderTable.getInvoiceList().remove(selectedInvoiceIndex);
            invoiceHeaderTable.fireTableDataChanged();
            invoiceLinesTable = new InvoiceLineTable(new ArrayList<>());
            invLinesTable.setModel(invoiceLinesTable);
            invoiceLinesTable.fireTableDataChanged();
            InvNumLbl.setText("");
            InvDateTF.setText("");
            CustNameTF.setText("");
            InvTotalLbl.setText("");

            printOutInvoices();
    } 

    public void printOutInvoices(){
        for(InvoiceHeader header: invoiceList){
            System.out.println(header);
        }
    }
    
    private void saveFile() {
      String headerString = "";
      String linesString = "";
      
      for (InvoiceHeader header: invoiceList){
          headerString += header.saveHeaderData();
          headerString += "\n";
          for(InvoiceLines line : header.getLines()){
             linesString += line.saveLinesData();
             linesString += "\n";
          }
      }
      JOptionPane.showMessageDialog(this, "Please select the header file.", "Invoices File Selection", JOptionPane.PLAIN_MESSAGE);
      JFileChooser fileSelect = new JFileChooser();
      int action = fileSelect.showSaveDialog(this);
      if (action == JFileChooser.APPROVE_OPTION){
          File invoiceFile = fileSelect.getSelectedFile();
          try{
              FileWriter invFileWriter = new FileWriter(invoiceFile);
              invFileWriter.write(headerString);
              invFileWriter.flush();
              invFileWriter.close();
              
              JOptionPane.showMessageDialog(this, "Please select the lines file.", "Invoice Items File Selection", JOptionPane.PLAIN_MESSAGE);
              action = fileSelect.showSaveDialog(this);
              if(action == JFileChooser.APPROVE_OPTION){
                  File linesFile = fileSelect.getSelectedFile();
                  FileWriter linesFileWriter = new FileWriter(linesFile);
                  linesFileWriter.write(linesString);
                  linesFileWriter.flush();
                  linesFileWriter.close();
              }
          } catch(Exception e) {
              JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
          }
      }
    }
}