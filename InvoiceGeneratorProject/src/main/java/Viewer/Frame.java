package Viewer;
import Controller.InvoiceController;
import Module.InvoiceHeader;
import Module.InvoiceHeaderModule;
import javax.swing.*;
import java.util.ArrayList;

public class Frame extends javax.swing.JFrame{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }
    public Frame() {
        controller = new InvoiceController(this);
        initComponents();
    }
    @SuppressWarnings("@unchecked")
    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        invoiceHeaderTable = new javax.swing.JTable();
        invoiceHeaderTable.getSelectionModel().addListSelectionListener(controller);
        JLabel jLabel1 = new JLabel();
        JButton createInvoiceBtn = new JButton();
        createInvoiceBtn.addActionListener(controller);
        JButton delInvBtn = new JButton();
        delInvBtn.addActionListener(controller);
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel invoiceNumLabel = new JLabel();
        JLabel invoiceDateLabel = new JLabel();
        JLabel customerNameLabel = new JLabel();
        JLabel invoiceTotalLabel = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        invoiceLineTable = new javax.swing.JTable();
        JButton saveBtn = new JButton();
        saveBtn.addActionListener(controller);
        JButton cancelBtn = new JButton();
        cancelBtn.addActionListener(controller);
        JLabel jLabel10 = new JLabel();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenuItem loadFileMenu = new JMenuItem();
        loadFileMenu.addActionListener(controller);
        JMenuItem saveFileMenu = new JMenuItem();
        saveFileMenu.addActionListener(controller);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        invoiceHeaderTable.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {}));
        jScrollPane1.setViewportView(invoiceHeaderTable);
        jLabel1.setText("Invoices Table");
        createInvoiceBtn.setText("Create New Invoice");
        delInvBtn.setText("Delete Invoice");
        jLabel2.setText("Invoice Number");
        jLabel3.setText("Invoice Date");
        jLabel4.setText("Customer Name");
        jLabel5.setText("Invoice Total");
        invoiceNumLabel.setText("");
        invoiceDateLabel.setText(" ");
        customerNameLabel.setText(" ");
        invoiceTotalLabel.setText(" ");
        invoiceLineTable.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {}));
        jScrollPane2.setViewportView(invoiceLineTable);
        saveBtn.setText("Save");
        saveBtn.addActionListener(this::saveBtnActionPerformed);
        cancelBtn.setText("Cancel");
        jLabel10.setText("Invoice Items");
        jMenu1.setText("File");
        loadFileMenu.setText("Load File");
        jMenu1.add(loadFileMenu);
        saveFileMenu.setText("Save FIle");
        jMenu1.add(saveFileMenu);
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel4)
                                                                                                .addComponent(jLabel5))
                                                                                        .addGap(22, 22, 22)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(customerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel2)
                                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(24, 24, 24)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(invoiceNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(invoiceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addComponent(jLabel10))
                                                                .addGap(30, 30, 30))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addContainerGap())))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(createInvoiceBtn)
                                                .addGap(74, 74, 74)
                                                .addComponent(delInvBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(saveBtn)
                                                .addGap(64, 64, 64)
                                                .addComponent(cancelBtn)
                                                .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(invoiceNumLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(invoiceDateLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(customerNameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(invoiceTotalLabel))
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(createInvoiceBtn)
                                                .addComponent(delInvBtn))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cancelBtn)
                                                .addComponent(saveBtn)))
                                .addGap(15, 15, 15))
        );
        pack();
    }
    private javax.swing.JTable invoiceHeaderTable;
    private javax.swing.JTable invoiceLineTable;
    private final InvoiceController controller;
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed
    public JTable getInvLineTable() {return invoiceLineTable;}
    public void setInvoiceHeadersList(ArrayList<InvoiceHeader> invoiceHeadersList) {
        this.invoiceHeadersList = invoiceHeadersList;
        InvoiceHeaderModule headerTableModel = new InvoiceHeaderModule(invoiceHeadersList);
        this.invoiceHeaderTable.setModel(headerTableModel);
    }
    private ArrayList<InvoiceHeader> invoiceHeadersList;
    public ArrayList<InvoiceHeader> getInvoiceHeadersList() {return invoiceHeadersList;}
    public JTable getInvHeaderTable() {return invoiceHeaderTable;}
}