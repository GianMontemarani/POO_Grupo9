package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonCertificado extends JButton implements TableCellRenderer, ActionListener {
	public BotonCertificado() {
		// Initialize your button properties if needed
		// For example, setOpaque(true) to make sure it's painted
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// Customize the button based on the cell value or other parameters
		setText("Certificado"); // Set the button text
		// Add any other customization based on the cell value or other parameters

		return this; // Return the button as the rendering component
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// This method will be called when the button is clicked
		// Perform your action here
		System.out.println("Button clicked!");
		// Add your custom action code here
	}
}
