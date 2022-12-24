package Controller;
import Module.InvoiceHeader;
import Module.Lines;
import Module.LinesModule;
import Viewer.Frame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceController implements ActionListener, ListSelectionListener {

    private @Nullable InvoiceHeader getInvoiceHeaderById(@NotNull ArrayList<InvoiceHeader> invoices, int id){
        for(InvoiceHeader invoiceHead : invoices){
            if(invoiceHead.getInvoiceNumber()== id){
                return invoiceHead;
            }
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File" -> {System.out.println("Load File");loadFile();}
            case "Create New Invoice" -> {System.out.println("New Invoice");createNewInvoice();}
            case "Invoice Delete " -> {System.out.println("Delete Invoice");invoiceDeleted();}
            case "Description Saved" -> {System.out.println("Save");descriptionSaved();}
            case "Description Cancel" -> {System.out.println("Cancel");descriptionCancelled();}
            case "FIle Saved" -> {System.out.println("Save FIle");fileSaved();}
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int rowSelect = iframe.getInvHeaderTable().getSelectedRow();
        ArrayList<Lines> lines = iframe.getInvoiceHeadersList().get(rowSelect).getLines();
        iframe.getInvLineTable().setModel(new LinesModule(lines));
    }
    private void loadFile() {
       try {
           JFileChooser jfc = new JFileChooser();
           int choose = jfc.showOpenDialog(iframe);
           if (choose == JFileChooser.APPROVE_OPTION){
               File headerFile = jfc.getSelectedFile();
               String headerStrPath = headerFile.getAbsolutePath();
               Path headerPath = Paths.get(headerStrPath);
               List<String> headerLines = Files.lines(headerPath).toList();
               ArrayList<InvoiceHeader> invoiceHeadersList = new ArrayList<>();
               for(String headerLine : headerLines){
                   String[] parts = headerLine.split(",");
                   int id = Integer.parseInt(parts[0]);
                   InvoiceHeader invHeader = new InvoiceHeader(id, parts[1], parts[2]);


                   invoiceHeadersList.add(invHeader);
               }
               choose = jfc.showOpenDialog(iframe);
               if (choose == JFileChooser.APPROVE_OPTION){
                   String lineStrPath = jfc.getSelectedFile().getAbsolutePath();
                   Path linePath = Paths.get(lineStrPath);
                   List<String> lineLines;
                   lineLines = Files.lines(linePath).collect(Collectors.toList());
                   for(String lineLine : lineLines){
                       String[] invoicePart = lineLine.split(",");
                       int invoiceId = Integer.parseInt(invoicePart[0]),
                           descriptionCounter = Integer.parseInt(invoicePart[3]);
                       double descriptionPrice = Double.parseDouble(invoicePart[2]);
                       InvoiceHeader header = getInvoiceHeaderById(invoiceHeadersList, invoiceId);
                       Lines invoiceLine = new Lines(header, invoicePart[1], descriptionPrice, descriptionCounter);
                       assert header != null;
                       header.getLines().add(invoiceLine);
                       iframe.setInvoiceHeadersList(invoiceHeadersList);
                   }
               }
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    private final Frame iframe;
    public InvoiceController(Frame frame) {
        this.iframe= frame;
    }
    private void createNewInvoice() {

    }

    private void invoiceDeleted() {
    }

    private void fileSaved() {
    }

    private void descriptionSaved() {
    }

    private void descriptionCancelled() {

    }
}
