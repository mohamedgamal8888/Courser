package Module;

import Controller.FileOperations;

import java.util.ArrayList;
public class InvoiceHeader {

        private final ArrayList<Lines> lines = new ArrayList<>();
        private String customerName;
        private String invoiceDate;
        private Integer invoiceNumber;
        public String[] getTableFormat(){
        String[] data = new String[FileOperations.getInvoicesAsArray().length];
        double total = getInvoiceTotal();

        data[0] = String.valueOf(getInvoiceNumber());
        data[1] = getInvoiceDate();
        data[2] = getCustomerName();
        data[3] = String.valueOf(total);

        return data;
    }
         public double getInvoiceTotal() {
        double total = 0;

        for(Lines il: getInvoiceItems())
            total += il.getItemPrice() * il.getItemCount();

        return total;
    }
        public InvoiceHeader(Integer invoiceNumber, String date, String customerName){
            setInvoiceNumber(invoiceNumber);
            setInvoiceDate(date);
            setCustomerName(customerName);
        }
        public int getInvoiceNumber(){
            return invoiceNumber;
        }
        public String getInvoiceDate(){
            return invoiceDate;
        }
        public String getCustomerName(){
            return customerName;
        }
        public ArrayList<Lines> getInvoiceItems(){
            return lines;
        }
        public void setInvoiceNumber(int i){
            invoiceNumber = i;
        }
        public void setInvoiceDate(String d){
            invoiceDate = d;
        }
        public void setCustomerName(String c){
            customerName = c;
        }
        public void addInvoiceItem(Lines il){
            lines.add(il);
        }
        public void removeInvoiceLine(Lines il){
            lines.remove(il);
        }

}
