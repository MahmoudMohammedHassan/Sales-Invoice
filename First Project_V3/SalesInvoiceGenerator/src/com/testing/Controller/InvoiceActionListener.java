/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.Controller;

import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceHeaderTable;
import com.testing.Model.InvoiceLineTable;
import com.testing.Model.InvoiceLines;
import com.testing.View.InvoiceGeneratorFrame;
import com.testing.View.InvoiceItemsDialog;
import com.testing.View.InvoiceTableDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class InvoiceActionListener implements ActionListener, ListSelectionListener{
   private InvoiceGeneratorFrame frame;

    public InvoiceActionListener (InvoiceGeneratorFrame frame){
        this.frame = frame;
    }
    
  private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
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
        
        JOptionPane.showMessageDialog(frame, "Please select the header file.", "Invoices File Selection", JOptionPane.PLAIN_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int action = openFile.showOpenDialog(frame);
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
                frame.getInvoiceList().add(invoice);
                  
            }
            
                JOptionPane.showMessageDialog(frame, "Please select the lines file.", "Invoice Items File Selection", JOptionPane.PLAIN_MESSAGE);
                action = openFile.showOpenDialog(frame);
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
                
                frame.setInvoiceHeaderTable(new InvoiceHeaderTable(frame.getInvoiceList()));
                frame.getInvoicesTable().setModel(frame.getInvoiceHeaderTable());
                frame.getInvoicesTable().validate();
            }
     
             }catch(IOException e){
               JOptionPane.showMessageDialog(frame, "File could not be loaded, please select a file with correct format", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (ParseException e) {
               JOptionPane.showMessageDialog(frame, "Error: Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(NumberFormatException e){
               JOptionPane.showMessageDialog(frame, "Wrong Number Format", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }    
        
        printOutInvoices();
    }
    
    private InvoiceHeader defineInvoiceByInvNum(int invNum){
        InvoiceHeader header = null;
        for(InvoiceHeader  invoice: frame.getInvoiceList()){
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
        int SelectedRow = frame.getInvoicesTable().getSelectedRow();
        if (SelectedRow >= 0){
            InvoiceHeader rowIndex = frame.getInvoiceHeaderTable().getInvoiceList().get(SelectedRow);
            frame.getInvNumLbl().setText("" + rowIndex.getInvNum());
            frame.getInvDateTF().setText(dateFormat.format(rowIndex.getInvDate()));
            frame.getCustNameTF().setText(rowIndex.getCustomerName());
            frame.getInvTotalLbl().setText("" + rowIndex.getInvTotal());
            ArrayList<InvoiceLines> invLines = rowIndex.getLines();
            frame.setInvoiceLinesTable(new InvoiceLineTable(invLines));
            frame.getInvLinesTable().setModel(frame.getInvoiceLinesTable());
        }
    }

    private void viewNewInvDialog() {
        frame.setInvDialog(new InvoiceTableDialog(frame));
        frame.getInvDialog().setVisible(true);
    } 
    
    private void viewNewItemDialog() {
    frame.setItemDialog(new InvoiceItemsDialog(frame));
    frame.getItemDialog().setVisible(true);
    }
    
    private void okCreateInvoice() {
            String invDateString = frame.getInvDialog().getInvDateField().getText();
            String customerName = frame.getInvDialog().getCustomerNameField().getText();
            frame.getInvDialog().setVisible(false);
            frame.getInvDialog().dispose();
            frame.setInvDialog(null);
            try{
                Date invDate = dateFormat.parse(invDateString);
                int invNum = getNewInvNum();
                InvoiceHeader invHeader = new InvoiceHeader(invNum, invDate, customerName);
                frame.getInvoiceList().add(invHeader);
                frame.getInvoiceHeaderTable().fireTableDataChanged();
            }catch(ParseException e){
                JOptionPane.showMessageDialog(frame, "Error : Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            printOutInvoices();
    }

    private void cancelCreateInvoice() {
            frame.getInvDialog().setVisible(false);
            frame.getInvDialog().dispose();
            frame.setInvDialog(null);
            
            printOutInvoices();
    }

    private int getNewInvNum() {
            int lastInvNum = 0;
            for(InvoiceHeader header: frame.getInvoiceList()){
                if(header.getInvNum()>lastInvNum){
                    lastInvNum = header.getInvNum();
                }
            }
            return lastInvNum + 1;
    }

    private void okCreateLine() {
        String itemName = frame.getItemDialog().getItemNameField().getText();
        String itemPriceString = frame.getItemDialog().getItemPriceField().getText();
        String itemCountString = frame.getItemDialog().getItemCountField().getText();
        frame.getItemDialog().setVisible(false);
        frame.getItemDialog().dispose();
        frame.setItemDialog(null);
        double itemPrice = Double.parseDouble(itemPriceString);
        int itemCount = Integer.parseInt(itemCountString);
        int invNumIndex = frame.getInvoicesTable().getSelectedRow();
        InvoiceHeader inv = frame.getInvoiceHeaderTable().getInvoiceList().get(invNumIndex);
        InvoiceLines invLine = new InvoiceLines(itemName, itemPrice, itemCount, inv);
        inv.addInvLine(invLine);
        frame.getInvoiceLinesTable().fireTableDataChanged();
        frame.getInvoiceHeaderTable().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + inv.getInvTotal());
        
        printOutInvoices();
    }

    private void cancelCreateLine() {
            frame.getItemDialog().setVisible(false);
            frame.getItemDialog().dispose();
            frame.setItemDialog(null);
            
            printOutInvoices();
    }   

    private void deleteSelectedLine() {
            int selectedLineIndex = frame.getInvLinesTable().getSelectedRow();
            frame.getInvoiceLinesTable().getInvoiceLines().remove(selectedLineIndex);
            frame.getInvoiceLinesTable().fireTableDataChanged();
            frame.getInvoiceHeaderTable().fireTableDataChanged();
            InvoiceLines lineSelected = frame.getInvoiceLinesTable().getInvoiceLines().get(selectedLineIndex);
            frame.getInvTotalLbl().setText("" + lineSelected.getHeader().getInvTotal());
            
            printOutInvoices();
    }
    
    private void deleteSelectedInvoice() {
            int selectedInvoiceIndex = frame.getInvoicesTable().getSelectedRow();
            frame.getInvoiceHeaderTable().getInvoiceList().remove(selectedInvoiceIndex);
            frame.getInvoiceHeaderTable().fireTableDataChanged();
            frame.setInvoiceLinesTable(new InvoiceLineTable(new ArrayList<>()));
            frame.getInvLinesTable().setModel(frame.getInvoiceLinesTable());
            frame.getInvoiceLinesTable().fireTableDataChanged();
            frame.getInvNumLbl().setText("");
            frame.getInvDateTF().setText("");
            frame.getCustNameTF().setText("");
            frame.getInvTotalLbl().setText("");

            printOutInvoices();
    } 

    
    private void saveFile() {
      String headerString = "";
      String linesString = "";
      
      for (InvoiceHeader header: frame.getInvoiceList()){
          headerString += header.saveHeaderData();
          headerString += "\n";
          for(InvoiceLines line : header.getLines()){
             linesString += line.saveLinesData();
             linesString += "\n";
          }
      }
      JOptionPane.showMessageDialog(frame, "Please select the header file.", "Invoices File Selection", JOptionPane.PLAIN_MESSAGE);
      JFileChooser fileSelect = new JFileChooser();
      int action = fileSelect.showSaveDialog(frame);
      if (action == JFileChooser.APPROVE_OPTION){
          File invoiceFile = fileSelect.getSelectedFile();
          try{
              FileWriter invFileWriter = new FileWriter(invoiceFile);
              invFileWriter.write(headerString);
              invFileWriter.flush();
              invFileWriter.close();
              
              JOptionPane.showMessageDialog(frame, "Please select the lines file.", "Invoice Items File Selection", JOptionPane.PLAIN_MESSAGE);
              action = fileSelect.showSaveDialog(frame);
              if(action == JFileChooser.APPROVE_OPTION){
                  File linesFile = fileSelect.getSelectedFile();
                  FileWriter linesFileWriter = new FileWriter(linesFile);
                  linesFileWriter.write(linesString);
                  linesFileWriter.flush();
                  linesFileWriter.close();
              }
          } catch(Exception e) {
              JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
          }
      }
      JOptionPane.showMessageDialog(frame, "Your data has been saved successfully", "Saving Data", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public void printOutInvoices(){
        for(InvoiceHeader header: frame.getInvoiceList()){
            System.out.println(header);
        }
    }
}
