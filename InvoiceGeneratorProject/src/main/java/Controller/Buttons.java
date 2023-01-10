package Controller;

import Viewer.Frame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Controller.Actions.*;

public class Buttons implements ActionListener {
        private static final Logger LOGGER = Logger.getLogger(FileOperations.class.getName());
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case CREATE_NEW_INVOICE -> {
                    FileOperations.createInvoiceDialog();
                    LOGGER.log(Level.INFO, "Create Invoice");
                }
                case SAVE_EDIT_INVOICE -> {
                    String invoiceNumberString = Frame.getInvoiceNumberAsString();
                    int invoiceNumberInt = Integer.parseInt(invoiceNumberString);
                    if (invoiceNumberString.isEmpty()) {
                        JOptionPane.showConfirmDialog(
                                null,
                                new JLabel("please pick the invoice you want to assign the item to ..."),
                                "Item error",
                                JOptionPane.DEFAULT_OPTION);
                        break;
                    } else {
                        FileOperations.userInvoiceItemDialog(FileOperations.getInvoice(invoiceNumberInt));
                        Frame.updateTables();
                    }
                    LOGGER.log(Level.INFO, "Created new invoice item");
                }
                case CANCEL_INVOICE -> {
                    int indexInvoiceItem = Frame.displayInvoicesItemsTable.getSelectedRow();

                    if (indexInvoiceItem == -1) {
                        JOptionPane.showConfirmDialog(null,
                                new JLabel(
                                        "Select the invoice item to be deleted"),
                                "Error",
                                JOptionPane.OK_CANCEL_OPTION);
                        break;
                    } else {

                        FileOperations.deleteInvoiceItemByTableIndex(
                                (String) Frame.displayInvoicesItemsTable.getValueAt(indexInvoiceItem, 0),
                                (String) Frame.displayInvoicesItemsTable.getValueAt(indexInvoiceItem, 1)
                        );
                    }
                    LOGGER.log(Level.INFO, "Deleted Selected invoice item");

                }
                case DELETE_INVOICE -> {
                    int indexInvoice = Frame.displayInvoicesTable.getSelectedRow();
                    if (indexInvoice == -1) {
                        break;
                    } else {
                        FileOperations.deleteInvoiceByTableIndex(indexInvoice);
                    }
                    LOGGER.log(Level.INFO, "Delete Invoice");
                }
            }
        }
 }

