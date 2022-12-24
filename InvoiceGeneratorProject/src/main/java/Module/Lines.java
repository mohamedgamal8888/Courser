package Module;

public class Lines {
    private InvoiceHeader invoice;
    public void setInvoice(InvoiceHeader invoice) {this.invoice = invoice;}
    public InvoiceHeader getInvoice() {return invoice;}
    private String itemName;
    public void setItemName(String itemName) {this.itemName = itemName;}
    public String getItemName() {return itemName;}
    private double itemPrice;
    public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}
    public double getItemPrice() {return itemPrice;}
    private int counter;
    public void setCount(int count) {this.counter = count;}
    public int getCounter() {return counter;}
    public double getLineTotal() {return counter * itemPrice ;}
    public Lines(InvoiceHeader invoice, String itemName, double itemPrice, int count) {
        this.invoice = invoice;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.counter = count;
    }
}
