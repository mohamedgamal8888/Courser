package Module;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvoiceHeaderModule extends AbstractTableModel{

    public InvoiceHeaderModule(ArrayList<InvoiceHeader> data) {
        this.data = data;
    }
    private final ArrayList<InvoiceHeader> data;
    private final String[] columns = {"Invoice ID", "Customer Name", "Invoice Date"};
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> header.getInvoiceNumber();
            case 1 -> header.getCustomerName();
            case 2 -> header.getInvoiceDate();
            default -> "";
        };
    }

}
