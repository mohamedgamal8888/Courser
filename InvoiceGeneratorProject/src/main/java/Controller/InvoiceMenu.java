package Controller;

import Module.InvoiceHeader;
import Viewer.Frame;
import Viewer.Generation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Controller.Actions.LOAD_FILE;
import static Controller.Actions.SAVE_FILE;




public class InvoiceMenu implements ActionListener {
        private final static Logger LOGGER = Logger.getLogger(InvoiceMenu.class.getName());
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
                case LOAD_FILE -> {
                    LOGGER.log(Level.INFO, "Loading a file");

                    FileOperations.ReadFile();
                    Generation.readFileTest();
                    Frame.updateTables();
                    JOptionPane.showConfirmDialog(
                            null,
                            "Data Loaded Successfully",
                            "Success!",
                            JOptionPane.DEFAULT_OPTION);
                }
                case SAVE_FILE ->{
                    LOGGER.log(Level.INFO, "Saving file");

                    ArrayList<InvoiceHeader> ihs = FileOperations.getInvoices();
                    FileOperations.WriteFile(ihs);
                    JOptionPane.showConfirmDialog(
                            null,
                            "Data Saved Successfully",
                            "Success!",
                            JOptionPane.DEFAULT_OPTION);
                }
            }
        }
}