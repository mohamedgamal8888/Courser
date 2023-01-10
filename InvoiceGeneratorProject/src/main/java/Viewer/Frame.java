package Viewer;

import Controller.Buttons;
import Controller.FileOperations;
import Controller.InvoiceMenu;
import Controller.InvoiceTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static Controller.Actions.*;

public class Frame extends JFrame {
        private final static Logger LOGGER = Logger.getLogger(Frame.class.getName());
        private static JTextField invoiceNumber = new JTextField();
        private static JTextField invoiceDate = new JTextField();
        private static JTextField customerName = new JTextField();
        private static JTextField invoiceTotal = new JTextField();
        public static JTable displayInvoicesTable = new InvoiceTable(InvoiceTable.INVOICES_TABLE).getTable();
        public static JTable displayInvoicesItemsTable = new InvoiceTable(InvoiceTable.INVOICE_ITEMS_TABLE).getTable();
        public Frame(String name) {
            super(name);
            setStyle();
            setLocation(50, 50);
            setLayout(new GridLayout(1, 2));
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            Buttons buttonsListener = new Buttons();
            InvoiceMenu menuListener = new InvoiceMenu();

            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");
            menuBar.add(menu);

            JMenuItem load = getMenuItem(menuListener, "Load File", LOAD_FILE);
            JMenuItem save = getMenuItem(menuListener, "Save File", SAVE_FILE);

            menu.add(load);
            menu.add(save);

            this.setJMenuBar(menuBar);

            JPanel leftPanel = defineLeftPanel(buttonsListener);
            JPanel rightPanel = defineRightPanel(leftPanel, buttonsListener);

            this.add(leftPanel);
            this.add(rightPanel);

            this.pack();
        }
        private JPanel defineRightPanel(JPanel leftPanel, Buttons buttonsListener) {
            JPanel rightPanel = new JPanel();

            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            leftPanel.setBorder(new EmptyBorder(new Insets(20, 25, 20, 25)));

            JPanel rightInputsPanel = new JPanel();
            rightInputsPanel.setLayout(new GridLayout(4, 2));

            invoiceNumber = new JTextField();
            invoiceDate = new JTextField();
            customerName = new JTextField();
            invoiceTotal = new JTextField();
            invoiceNumber.setEditable(false);
            invoiceTotal.setEditable(false);

            rightInputsPanel.add(new JLabel("Invoice Number"));
            rightInputsPanel.add(invoiceNumber);

            rightInputsPanel.add(new JLabel("Invoice Date"));
            rightInputsPanel.add(invoiceDate);

            rightInputsPanel.add(new JLabel("Customer Name"));
            rightInputsPanel.add(customerName);

            rightInputsPanel.add(new JLabel("Total"));
            rightInputsPanel.add(invoiceTotal);

            rightPanel.add(rightInputsPanel);

            rightPanel.add(new JLabel("Invoice Items"));
            rightPanel.add(new JScrollPane(displayInvoicesItemsTable));

            JPanel rightButtonsPanel = new JPanel();

            rightButtonsPanel.setBackground(Color.BLACK);
            rightButtonsPanel.setLayout(new BoxLayout(rightButtonsPanel, BoxLayout.X_AXIS));

            JButton saveEditBtn = new JButton("Create Invoice Item");

            saveEditBtn.setActionCommand(SAVE_EDIT_INVOICE);
            saveEditBtn.addActionListener(buttonsListener);

            JButton cancelEditBtn = new JButton("Delete Invoice Item");

            cancelEditBtn.setActionCommand(CANCEL_INVOICE);
            cancelEditBtn.addActionListener(buttonsListener);

            rightButtonsPanel.add(saveEditBtn);
            rightButtonsPanel.add(cancelEditBtn);

            rightPanel.add(rightButtonsPanel);

            return rightPanel;
        }
        private JPanel defineLeftPanel(Buttons buttonsListener) {
            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
            leftPanel.setBorder(new EmptyBorder(new Insets(20, 25, 20, 25)));

            leftPanel.add(new JLabel("Invoices Table"));
            leftPanel.add(new JScrollPane(displayInvoicesTable));

            JPanel leftButtonsPanel = new JPanel();
            leftButtonsPanel.setLayout(new BoxLayout(leftButtonsPanel, BoxLayout.X_AXIS));
            JButton createBtn = new JButton("Create New Invoice");
            JButton deleteBtn = new JButton("Delete Invoice");

            createBtn.setActionCommand(CREATE_NEW_INVOICE);
            createBtn.addActionListener(buttonsListener);

            deleteBtn.setActionCommand(DELETE_INVOICE);
            deleteBtn.addActionListener(buttonsListener);

            leftButtonsPanel.add(createBtn);
            leftButtonsPanel.add(deleteBtn);
            leftPanel.add(leftButtonsPanel);

            return leftPanel;
        }
        private JMenuItem getMenuItem(InvoiceMenu menuListener, String name, String actionCommand) {
        JMenuItem load = new JMenuItem(name);
        load.setActionCommand(actionCommand);
        load.addActionListener(menuListener);
        load.setMnemonic(76);
        //load.setAccelerator(KeyStroke.getKeyStroke(76, 8));
        return load;
    }
        public static String getInvoiceNumberAsString() {
            return invoiceNumber.getText();
        }
        private void setStyle() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Can't use Nimbus");
        }

    }
        public static void updateTextFields(String[] data) {
        invoiceNumber.setText(data[0]);
        invoiceDate.setText(data[1]);
        customerName.setText(data[2]);
        invoiceTotal.setText(data[3]);

    }
        public static void updateTables() {
            displayInvoicesTable.setModel(
                    new InvoiceTable(FileOperations.getInvoicesAsMatrix(), InvoiceTable.INVOICES_TABLE));
            displayInvoicesItemsTable.setModel(
                    new InvoiceTable(FileOperations.getInvoicesItemsTableData(), InvoiceTable.INVOICE_ITEMS_TABLE));
        }
    }

