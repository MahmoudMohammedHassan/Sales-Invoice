
package com.testing.version;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    
    private int invNum;
    private Date invDate;
    private String customerName;
    private ArrayList<InvoiceLines> lines;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    

    public InvoiceHeader(int invNum, Date invDate, String customerName) {
        this.invNum = invNum;
        this.invDate = invDate;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public ArrayList<InvoiceLines> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLines> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        String headerString = "InvoiceHeader{" + "invNum=" + invNum + ", invDate=" + invDate + ", customerName=" + customerName + '}';
        for(InvoiceLines line: getLines()){
            headerString += "\n \t" +line;
        }
        return headerString;
    }

    public double getInvTotal() {
        double total = 0.0;
        for(InvoiceLines line: getLines()){
            total += line.getItemTotal();
        }
        return total;
    }

    public void addInvLine(InvoiceLines line){
        getLines().add(line);
    }
    
    public String saveHeaderData(){
        return "" + getInvNum() + "," + dateFormat.format(getInvDate()) + "," + getCustomerName();
    }
    
}
