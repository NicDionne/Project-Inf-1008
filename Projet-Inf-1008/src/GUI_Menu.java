import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI_Menu   {
	private JButton button1;
	final JPanel panel1 = new JPanel();
	JFrame frame = new JFrame("test");
	public GUI_Menu()
	{ 	
		//JPanel initialisation
	        panel1.setLayout(new GridBagLayout());
	        panel1.setBorder(BorderFactory.createTitledBorder(null, "test", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
	        button1 = new JButton();
	        button1.setText("Button");
	        GridBagConstraints gbc;
	        gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(button1, gbc);
	        final JPanel spacer1 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(spacer1, gbc);
	        final JPanel spacer2 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        panel1.add(spacer2, gbc);
	        
	        //JFrame initialisation
	        frame.setContentPane(panel1);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setVisible(true);
	}
	
	
}
