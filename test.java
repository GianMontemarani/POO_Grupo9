import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableWithButtonInColumnExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Table with Button in Column Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a table model with 6 columns (replace this with your data)
        DefaultTableModel model = new DefaultTableModel(new Object[][]{{"Row 1, Col 1", "Row 1, Col 2", "Row 1, Col 3", "Row 1, Col 4", "Row 1, Col 5", "Button"}},
                                                        new Object[]{"Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6"});

        // Create a JTable with the custom model
        JTable table = new JTable(model);

        // Add a button in column 6 of the table
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

        // Add ActionListener to the button in column 6
        ((ButtonEditor) table.getColumnModel().getColumn(5).getCellEditor()).getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show a new frame when the button is clicked
                JFrame popupFrame = new JFrame("Popup Frame");
                popupFrame.setSize(300, 200);
                popupFrame.setLocationRelativeTo(frame); // Center on the main frame
                popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Add some content to the popup frame (e.g., a label)
                JLabel label = new JLabel("This is a popup frame!");
                popupFrame.add(label);

                popupFrame.setVisible(true);
            }
        });

        // Add the table to the frame
        frame.add(new JScrollPane(table));

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}

// Custom cell renderer for the button in column 6
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

// Custom cell editor for the button in column 6
class ButtonEditor extends DefaultCellEditor {
    private JButton button;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    public JButton getButton() {
        return button;
    }
}
