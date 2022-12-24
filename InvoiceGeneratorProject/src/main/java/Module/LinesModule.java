package Module;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class LinesModule extends AbstractTableModel{
    private final ArrayList<Lines> data;
    public LinesModule(ArrayList<Lines> data) {
        this.data=data;
    }
    private final String[] columns = {"Item Name", "Unit Price", "Count"};
    @Override
    public String getColumnName(int column) {return columns[column];}
    @Override
    public int getColumnCount() {return columns.length;}
    @Override
    public int getRowCount() {
        return data.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lines line = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> line.getItemName();
            case 1 -> line.getItemPrice();
            case 2 -> line.getCounter();
            default -> "";
        };
    }
}
