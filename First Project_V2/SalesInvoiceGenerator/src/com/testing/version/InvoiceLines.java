
package com.testing.version;


public class InvoiceLines {
    
    private String itemName;
    private double  itemPrice;
    private int itemCount;
    private InvoiceHeader header;
    

    public InvoiceLines(String itemName, double itemPrice, int itemCount, InvoiceHeader header) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.header = header;
    }
            

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "InvoiceLines{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount + '}';
    }
 
    public double getItemTotal(){
        return itemPrice * itemCount;
    }
    
    public String saveLinesData(){
        return "" + getHeader().getInvNum() + "," + getItemName() + "," + getItemPrice() + "," + getItemCount();
    }
}
