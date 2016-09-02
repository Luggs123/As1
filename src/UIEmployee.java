import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;

public class UIEmployee extends JFrame {
	private static final long serialVersionUID = 1371750691536720618L;
	public static Panel onePanel = new Panel();
    
    public UIEmployee(){
    	//TODO: Figure out how to next layouts.
        setLayout(new FlowLayout(3,25, 0)); //arguments: align, hgap and vgap
        JLabel USLabel = new JLabel("Employee info: ");
        onePanel.add(USLabel);
        
        // Input fields.
        JTextField NameTextField = new JTextField(5);
        NameTextField.setEditable(true);
        onePanel.add(NameTextField);
        
        JTextField SalesTextField = new JTextField(10);
        SalesTextField.setEditable(true);
        onePanel.add(SalesTextField);
        
        // Buttons
        JButton addButton = new JButton("Add");
        addButton.setToolTipText("Add the information provided into the database.");
        onePanel.add(addButton);
        // TODO: Add action handler(s).
        
        JButton submitButton = new JButton("Submit");
        submitButton.setDefaultCapable(true);
        onePanel.add(submitButton);
    }
    public static void main (String[] args) {
        UIEmployee OneFrame = new UIEmployee();
        OneFrame.setTitle("Employee");
        //OneFrame.pack();
        OneFrame.setSize(800,600);
        OneFrame.setResizable(false);
        OneFrame.setLocationRelativeTo(null);       //center the frame display
        OneFrame.setDefaultCloseOperation(OneFrame.EXIT_ON_CLOSE);
        OneFrame.add(onePanel);           //add panel to the frame
        OneFrame.setVisible(true);                  // set the frame visible
    }

    

    
}
