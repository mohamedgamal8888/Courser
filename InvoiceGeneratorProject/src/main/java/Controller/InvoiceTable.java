package Controller;

import Viewer.Frame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceTable extends AbstractTableModel implements ListSelectionListener, TableModelListener, TableModel{
        private final static Logger LOGGER = Logger.getLogger(InvoiceTable.class.getName());
        public static final int INVOICES_TABLE = 1;
        public static final int INVOICE_ITEMS_TABLE = 2;
        private Object[][] data;
        private String[] columnNames;
        private final int tableType;
        private JTable table;
        public InvoiceTable(int type){
            tableType = type;

            if(FileOperations.hasInvoices()){
                data= new String [0][0];
                if(type == INVOICES_TABLE){
                    columnNames = FileOperations.getInvoicesAsArray();
                } else if (type == INVOICE_ITEMS_TABLE){
                    columnNames = FileOperations.getInvoicesItemsHeaders();
                }

                table = new JTable(this);
                table.getSelectionModel().addListSelectionListener(this);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.getModel().addTableModelListener(this);
                table.setCellSelectionEnabled(true);
                return;
            }

            if(tableType == INVOICES_TABLE){
                data= FileOperations.getInvoicesAsMatrix();
                columnNames = FileOperations.getInvoicesAsArray();
            } else if (tableType == INVOICE_ITEMS_TABLE){
                data= FileOperations.getInvoicesItemsTableData();
                columnNames = FileOperations.getInvoicesItemsHeaders();
            }

            table = new JTable(this);
            table.getSelectionModel().addListSelectionListener(this);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.getModel().addTableModelListener(this);
            table.setCellSelectionEnabled(true);
        }
        public InvoiceTable(String [] [] d, int type){
            tableType = type;

            if(type == INVOICES_TABLE){
                columnNames = FileOperations.getInvoicesAsArray();
            } else if (type == INVOICE_ITEMS_TABLE){
                columnNames = FileOperations.getInvoicesItemsHeaders();
            }

            data = d;
        }
        public JTable getTable(){
            return table;
        }
        public int getColumnCount() {
            return columnNames.length;
        }
        public int getRowCount() {
            return data.length;
        }
        public String getColumnName(int col) {
            return columnNames[col];
        }
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
        @Override
        public void valueChanged(ListSelectionEvent e) {

            String[] selectedData;

            int selectedRow = table.getSelectedRow();
            int columnCount = table.getColumnCount();
            selectedData = new String[columnCount];

            if(selectedRow == -1){
                return;
            }

            for (int j = 0; j < columnCount; j++)
                selectedData[j] = (String) table.getValueAt(selectedRow,j);

            if(tableType == INVOICE_ITEMS_TABLE){
                Frame.displayInvoicesTable.setModel(new InvoiceTable(FileOperations.getInvoicesAsMatrix(),INVOICES_TABLE));
            } else if (tableType == INVOICES_TABLE){
                Frame.updateTextFields(FileOperations.getInvoiceData(Integer.parseInt(selectedData[0])));
                Frame.displayInvoicesItemsTable.setModel(new InvoiceTable(FileOperations.getInvoicesItemsTableData(Integer.parseInt(selectedData[0])),INVOICE_ITEMS_TABLE));
            }
        }
        @Override
        public void tableChanged(TableModelEvent e) {
            int column = e.getColumn();
            int row = e.getFirstRow();
            TableModel model = (TableModel)e.getSource();
            Object data = model.getValueAt(row, column);

            LOGGER.log(Level.INFO, String.format("Data %s", data.toString()));
        }


}
