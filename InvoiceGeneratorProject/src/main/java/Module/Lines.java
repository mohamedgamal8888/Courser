package Module;

import Controller.FileOperations;

public class Lines {

    private int invoiceNumber;
        private String itemName;
        private int itemCount;
        private double itemPrice;
        public String[] getTableFormat() {
        String[] data = new String[FileOperations.getInvoicesItemsHeaders().length];
        data[0] = String.valueOf(getInvoiceNumber());
        data[1] = getItemName();
        data[2] = String.valueOf(getItemPrice());
        data[3] = String.valueOf(getItemCount());
        data[4] = String.valueOf(getItemPrice() * getItemCount());

        return data;
    }
        public Lines(InvoiceHeader parentInvoice, int invoiceNumber, String itemName, double itemPrice, int count) {
            setParentInvoice(parentInvoice);
            setInvoiceNumber(invoiceNumber);
            setItemName(itemName);
            setItemPrice(itemPrice);
            setItemCount(count);
        }
        public int getInvoiceNumber() {
            return invoiceNumber;
        }
        public String getItemName() {
            return itemName;
        }
        public double getItemPrice() {
            return itemPrice;
        }
        public void setInvoiceNumber(int i) {
            invoiceNumber = i;
        }
        public void setParentInvoice(InvoiceHeader invoice) {
        }
        public void setItemName(String n) {
            itemName = n;
        }
        public void setItemPrice(double p) {
            itemPrice = p;
        }
        public void setItemCount(int c) {
            itemCount = c;
        }
        public int getItemCount() {
            return itemCount;
        }

    }

