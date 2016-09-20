/*** Program Function; To accept employee information and incorporate Polymorphism, Abstract classes, and Interfaces.
 *** Creator; Paul Gaudnik, Mark Jarjour, Michael Luger
 *** Submission Date; September 20th, 2016
 *** Date Last Modified; September 19th, 2016
 ***/

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class UIEmployee extends JFrame {
	private static final long serialVersionUID = 1371750691536720618L;
	public static JPanel employeePanel = new JPanel();

	public static void main (String[] args) {
		// Generating valid, invalid, and buffer lists.
		List<Employee> validEmployees = new ArrayList<Employee>();
		List<Employee> invalidEmployees = new ArrayList<Employee>();
		List<Employee> employeeBuffer = new ArrayList<Employee>();

		// Setting up layout.
		employeePanel.setLayout(new FlowLayout() );

		// Setting up row of labels.
		JLabel frankensteinsLabel = new JLabel("  Employee Name:       Hours:       Sales:       ");
		employeePanel.add(frankensteinsLabel);

		// Input fields.
		final JTextField nameTextField = new JTextField(10);
		nameTextField.setEditable(true);
		employeePanel.add(nameTextField);

		final JTextField hrsTextField = new JTextField(4);
		hrsTextField.setEditable(true);
		employeePanel.add(hrsTextField);

		final JTextField salesTextField = new JTextField(6);
		salesTextField.setEditable(true);
		employeePanel.add(salesTextField);

		// If "Add" button is pressed, fire this listener.
		class buttonListenerADD implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				ImageIcon icon = new ImageIcon(UIEmployee.class.getResource("/assets/notice.png"));
				Boolean validHrs = true;
				Boolean validSales = true;
				int hrs = 0;
				double sales = 0.0;

				// Parse the text fields to int add the value to the buffer.
				try {  
					// Parse text field.
					hrs = Integer.parseInt(hrsTextField.getText());

					// If invalid hours then re-prompt.
					if (hrs < 0 || hrs > 60) {
						JOptionPane.showMessageDialog(null, "\"Hours\" parameter must be between 0 and 60." , "Output", JOptionPane.ERROR_MESSAGE, icon);
						validSales = false;
					}
				} catch (NumberFormatException nfe) { 
					// If an error is caught then throw an error dialog.
					JOptionPane.showMessageDialog(null, "Please enter a valid \"Hours\" parameter." , "Output", JOptionPane.ERROR_MESSAGE, icon);
					validSales = false;
				}

				try {
					// Parse text field.
					sales = Double.parseDouble(salesTextField.getText());
					
					// If invalid hours then re-prompt.
					if (sales < 0) {
						JOptionPane.showMessageDialog(null, "\"Sales\" parameter must be greater than zero." , "Output", JOptionPane.ERROR_MESSAGE, icon);
						validSales = false;
					}
				} catch (NumberFormatException nfe) { 
					// If an error is caught then throw an error dialog.
					JOptionPane.showMessageDialog(null, "Please enter a valid \"Sales\" parameter." , "Output", JOptionPane.ERROR_MESSAGE, icon);
					validSales = false;
				}

				if (validHrs && validSales) {
					// Add it to the buffer.
					employeeBuffer.add(new Employee(name, hrs, sales));

					// Clear text fields.
					nameTextField.setText("");
					hrsTextField.setText("");
					salesTextField.setText("");
				}
			}
		}

		// If "Submit" button is pressed, fire this listener.
		class buttonListenerSUBMIT implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// Move buffer employee list to valid or invalid.
				for (Employee emp : employeeBuffer) {
					if (emp.isValid()) {
						validEmployees.add(emp);
					} else {
						invalidEmployees.add(emp);
					}
				}
			}
		}

		// Buttons
		JButton addButton = new JButton("Add");
		addButton.setToolTipText("Add the information provided into the database.");
		addButton.addActionListener(new buttonListenerADD());
		employeePanel.add(addButton);

		JButton submitButton = new JButton("Submit");
		submitButton.setDefaultCapable(true);
		submitButton.addActionListener(new buttonListenerSUBMIT());
		employeePanel.add(submitButton);

		// Set up frame.
		UIEmployee OneFrame = new UIEmployee();
		OneFrame.pack();
		OneFrame.setTitle("Employee");
		OneFrame.setSize(290,125);
		OneFrame.setResizable(false);
		OneFrame.setLocationRelativeTo(null);
		OneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OneFrame.add(employeePanel);
		OneFrame.setVisible(true);
	}
}