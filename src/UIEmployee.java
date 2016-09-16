import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.util.ArrayList;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIEmployee extends JFrame {
	private static final long serialVersionUID = 1371750691536720618L;
	public static JPanel employeePanel = new JPanel();

	public UIEmployee() {
		//		// Setting up layout.
		//		employeePanel.setLayout(new FlowLayout() );
		//		
		//		// Setting up row of labels.
		//		JLabel frankensteinsLabel = new JLabel("  Employee Name:       Hours:       Sales:       ");
		//		
		//		employeePanel.add(frankensteinsLabel);
		//
		//		// Input fields.
		//		JTextField NameTextField = new JTextField(10);
		//		NameTextField.setEditable(true);
		//		employeePanel.add(NameTextField);
		//		
		//		JTextField HrsTextField = new JTextField(4);
		//		HrsTextField.setEditable(true);
		//		employeePanel.add(HrsTextField);
		//
		//		JTextField SalesTextField = new JTextField(6);
		//		SalesTextField.setEditable(true);
		//		employeePanel.add(SalesTextField);
		//		
		//
		//		// Buttons
		//		JButton addButton = new JButton("Add");
		//		addButton.setToolTipText("Add the information provided into the database.");
		//		employeePanel.add(addButton);
		//		// TODO: Add action handler(s).
		//
		//		JButton submitButton = new JButton("Submit");
		//		submitButton.setDefaultCapable(true);
		//		employeePanel.add(submitButton);
	}

	public static void main (String[] args) {
		UIEmployee OneFrame = new UIEmployee();
		List<Employee> validEmployees = new ArrayList<Employee>();
		List<Employee> invalidEmployees = new ArrayList<Employee>();
		List<Employee> employeeBuffer = new ArrayList<Employee>();

		// Setting up layout.
		employeePanel.setLayout(new FlowLayout() );

		// Setting up row of labels.
		JLabel frankensteinsLabel = new JLabel("  Employee Name:       Hours:       Sales:       ");

		employeePanel.add(frankensteinsLabel);

		// Input fields.
		final JTextField NameTextField = new JTextField(10);
		NameTextField.setEditable(true);
		employeePanel.add(NameTextField);

		final JTextField HrsTextField = new JTextField(4);
		HrsTextField.setEditable(true);
		employeePanel.add(HrsTextField);

		final JTextField SalesTextField = new JTextField(6);
		SalesTextField.setEditable(true);
		employeePanel.add(SalesTextField);

		class buttonListenerADD implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String name = NameTextField.getText();
				int hrs = Integer.parseInt(HrsTextField.getText());
				double sales = Double.parseDouble(SalesTextField.getText());
				employeeBuffer.add(new Employee(name, hrs, sales));
			}
		}

		class buttonListenerSUBMIT implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				for (Employee emp : employeeBuffer) {
					if (emp.isValid) {
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

		OneFrame.pack();
		OneFrame.setTitle("Employee");
		OneFrame.setSize(280,125);
		OneFrame.setResizable(false);
		OneFrame.setLocationRelativeTo(null);       //center the frame display
		OneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OneFrame.add(employeePanel);           //add panel to the frame
		OneFrame.setVisible(true);                  // set the frame visible
	}

	//	class buttonListenerADD implements ActionListener {
	//		public void actionPerformed(ActionEvent e) {
	//			JButton button = (JButton) e.getSource();
	//		}
	//	}
	//	
	//	class buttonListenerSUBMIT implements ActionListener {
	//		public void actionPerformed(ActionEvent e) {
	//			JButton button = (JButton) e.getSource();
	//		}
	//	}
}