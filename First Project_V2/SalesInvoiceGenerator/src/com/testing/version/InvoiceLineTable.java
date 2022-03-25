
package com.testing.version;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class InvoiceLineTable extends AbstractTableModel{

    private List<InvoiceLines> invoiceLines;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceLineTable(List<InvoiceLines> invoiceLines) {
        this.invoiceLines = invoiceLines;
        
    }

    public List<InvoiceLines> getInvoiceLines() {
        return invoiceLines;
    }

    
    @Override
    public int getRowCount() {
        return invoiceLines.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: 
                return "Item Name";
            case 1: 
                return "Item Price";
            case 2:
                return "Count";
            case 3: 
                return "Item Total";
            default: 
                return "";
        }  
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: 
                return String.class;
            case 1: 
                return Double.class;
            case 2:
                return Integer.class;
            case 3: 
                return Double.class;
            default: 
                return Object.class; 
        }  

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLines row = invoiceLines.get(rowIndex);
        
        switch (columnIndex){
            case 0: 
                return row.getItemName();
            case 1: 
                return row.getItemPrice();
            case 2:
                return row.getItemCount();
            case 3: 
                return row.getItemTotal();
            default: 
                return "";
        }
    }
    
}
