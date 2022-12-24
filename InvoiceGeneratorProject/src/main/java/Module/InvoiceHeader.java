package Module;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class InvoiceHeader {


    private ArrayList<Lines> lines;
    public ArrayList<Lines> getLines() {
        if (lines == null){lines = new ArrayList<>();}
        return lines;
    }
    private final int invoiceNumber;
    private final String invoiceDate;
    public InvoiceHeader(int invoiceNumber, String invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }
    private final String customerName;
    public String getCustomerName() {
        return customerName;
    }
    public int getInvoiceNumber() {return getInvoiceNumber();}
    public String getInvoiceDate() {
        return invoiceDate;
    }

}
