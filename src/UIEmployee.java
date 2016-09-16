import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIEmployee extends JFrame {
	private static final long serialVersionUID = 1371750691536720618L;
	public static JPanel employeePanel = new JPanel();

	public UIEmployee() {
		// Setting up layout.
		employeePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Setting up row of labels.
		JLabel nameLabel = new JLabel("Employee Name: ");
		JLabel hrsLabel = new JLabel("Hours: ");
		JLabel salesLabel = new JLabel("Sales: ");
		
		employeePanel.add(nameLabel);
		employeePanel.add(hrsLabel);
		employeePanel.add(salesLabel);

		// Input fields.
		JTextField NameTextField = new JTextField(5);
		NameTextField.setEditable(true);
		employeePanel.add(NameTextField);

		JTextField SalesTextField = new JTextField(10);
		SalesTextField.setEditable(true);
		employeePanel.add(SalesTextField);

		// Buttons
		JButton addButton = new JButton("Add");
		addButton.setToolTipText("Add the information provided into the database.");
		employeePanel.add(addButton);
		// TODO: Add action handler(s).

		JButton submitButton = new JButton("Submit");
		submitButton.setDefaultCapable(true);
		employeePanel.add(submitButton);
	}

	public static void main (String[] args) {
		UIEmployee OneFrame = new UIEmployee();
		OneFrame.pack();
		OneFrame.setTitle("Employee");
		OneFrame.setSize(800,600);
		OneFrame.setResizable(true);
		OneFrame.setLocationRelativeTo(null);       //center the frame display
		OneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OneFrame.add(employeePanel);           //add panel to the frame
		OneFrame.setVisible(true);                  // set the frame visible
	}

	class buttonListenerADD implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
		}

	}
}