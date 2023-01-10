package Viewer;

import Controller.FileOperations;
import Module.InvoiceHeader;
import Module.Lines;

import java.util.ArrayList;

public class Generation {
        public static void readFileTest(){
        ArrayList<InvoiceHeader> invoices = FileOperations.getInvoices();
        for (InvoiceHeader ih : invoices) {
            System.out.print("Invoice" + ih.getInvoiceNumber() + "Num");
            System.out.println();
            System.out.println("{");
            System.out.print("Invoice" + ih.getInvoiceNumber() + "Data (" + ih.getInvoiceDate() + "), " + ih.getCustomerName());
            System.out.println();


            for (Lines il : ih.getInvoiceItems()) {
                System.out.print(il.getItemName() + ", " + il.getItemPrice() + ", " + il.getItemCount());
                System.out.println();
            }
            System.out.println();
            System.out.println("}");
            System.out.println();
        }
    }
        public static void main(String[] args) {
            Frame view = new Frame("Generation");
            view.setVisible(true);
        }
    }


