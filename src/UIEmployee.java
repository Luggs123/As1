import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;

public class UIEmployee extends JFrame {
	private static final long serialVersionUID = 1371750691536720618L;
	public static Panel AddEmployeePanel = new Panel();
	public static Panel EmployeeListPanel  = new Panel();
    
    public UIEmployee(){
    	//TODO: Figure out how to next layouts.
    	AddEmployeePanel.setLayout(new FlowLayout(3,25, 0)); //arguments: align, hgap and vgap
        JLabel USLabel = new JLabel("Employee info: ");
        AddEmployeePanel.add(USLabel);
        
        // Input fields.
        JTextField NameTextField = new JTextField(5);
        NameTextField.setEditable(true);
        AddEmployeePanel.add(NameTextField);
        
        JTextField SalesTextField = new JTextField(10);
        SalesTextField.setEditable(true);
        AddEmployeePanel.add(SalesTextField);
        
        // Buttons
        JButton addButton = new JButton("Add");
        addButton.setToolTipText("Add the information provided into the database.");
        AddEmployeePanel.add(addButton);
        // TODO: Add action handler(s).
        
        JButton submitButton = new JButton("Submit");
        submitButton.setDefaultCapable(true);
        AddEmployeePanel.add(submitButton);
    }
    public static void main (String[] args) {
        UIEmployee OneFrame = new UIEmployee();
        OneFrame.setTitle("Employee");
        //OneFrame.pack();
        OneFrame.setSize(800,600);
        OneFrame.setResizable(false);
        OneFrame.setLocationRelativeTo(null);       //center the frame display
        OneFrame.setDefaultCloseOperation(OneFrame.EXIT_ON_CLOSE);
        OneFrame.add(AddEmployeePanel);           //add panel to the frame
        OneFrame.setVisible(true);                  // set the frame visible
    }

    

    
}
