
package com.testing.Model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;




public class InvoiceHeaderTable extends AbstractTableModel{

    private List<InvoiceHeader> invoiceList;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceHeaderTable(List<InvoiceHeader> invoiceList) {
        this.invoiceList = invoiceList;
        
    }

    public List<InvoiceHeader> getInvoiceList() {
        return invoiceList;
    }

    
    @Override
    public int getRowCount() {
        return invoiceList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: 
                return "No.";
            case 1: 
                return "Date";
            case 2:
                return "Customer";
            case 3: 
                return "Total";
            default: 
                return "";
        }  
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: 
                return Integer.class;
            case 1: 
                return String.class;
            case 2:
                return String.class;
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
        InvoiceHeader row = invoiceList.get(rowIndex);
        
        switch (columnIndex){
            case 0: 
                return row.getInvNum();
            case 1: 
                return dateFormat.format(row.getInvDate());
            case 2:
                return row.getCustomerName();
            case 3: 
                return row.getInvTotal();
            default: 
                return "";
        }
    }
    
}
