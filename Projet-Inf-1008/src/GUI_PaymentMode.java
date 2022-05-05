/**
 * @author Ramy
 */

import javax.swing.*;
import java.awt.*;


public class GUI_PaymentMode extends GUI { 
	
	final JPanel panel1 = new JPanel();
	private JTextField textFieldMontant;
	
	private JButton confirmerModePayementButton;
	private JButton annulerButton;
	String[] tab_contact;
	DefaultComboBoxModel modele;
	JComboBox liste_contact;
	
	public GUI_PaymentMode(GUI upperMenu)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Formulaire Mode de payement");
		 this.upperMenu = upperMenu;
		 
		 //JFrame initialisation
	     frame.setContentPane(panel1);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setVisible(true);
	      panel1.setLayout(new GridBagLayout());
	      
	        GridBagConstraints gbc;
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 8;
	        gbc.gridwidth = 9;
	        gbc.anchor = GridBagConstraints.EAST;

	        final JToolBar toolBar1 = new JToolBar();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 2;
	        gbc.gridy = 9;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(toolBar1, gbc);
	        
	        panel1.setBorder(BorderFactory.createLineBorder(Color.red));
	        
	        textFieldMontant = new JTextField();
	        textFieldMontant.setText("450 CAD");
	        textFieldMontant.setEnabled(false);
	        Font textFieldMontantFont = new Font(null, -1, 16);
	        if (textFieldMontantFont != null) textFieldMontant.setFont(textFieldMontantFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 1;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldMontant, gbc);
	        final JLabel labelMontant = new JLabel();
	        Font labelMontantFont = new Font(null, -1, 16);
	        if (labelMontantFont != null) labelMontant.setFont(labelMontantFont);
	        labelMontant.setHorizontalAlignment(11);
	        labelMontant.setText("Montant a payer :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelMontant, gbc);
	        
			// Liste mode de payement
	      
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 2;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
			tab_contact = new String[3];
			tab_contact[0] = new String("Comptant");
			tab_contact[1] = new String("Carte debit");
			tab_contact[2] = new String("Carte Credit");
			modele = new DefaultComboBoxModel(tab_contact);
			liste_contact = new JComboBox(modele);
			panel1.add(liste_contact, gbc);
			final JLabel labelMode = new JLabel();
		    Font labelModeFont = new Font(null, -1, 16);
		    if (labelModeFont != null) labelMode.setFont(labelModeFont);
		    labelMode.setHorizontalAlignment(11);
		    labelMode.setText("Mode de payement :");
		    gbc = new GridBagConstraints();
		    gbc.gridx = 1;
		    gbc.gridy = 2;
		    gbc.anchor = GridBagConstraints.EAST;
		    panel1.add(labelMode, gbc);
		    
	        confirmerModePayementButton = new JButton();
	        confirmerModePayementButton.setText("Confirmer Mode payement");
	        confirmerModePayementButton.addActionListener(e -> confirmerModePayementButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 12;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerModePayementButton, gbc);
	        
	        
	        annulerButton = new JButton();
	        annulerButton.setText("Annuler");
	        annulerButton.addActionListener(e -> annulerButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 12;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(annulerButton, gbc);
	        final JPanel spacer1 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 10;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        panel1.add(spacer1, gbc);
	        final JPanel spacer2 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 11;
	        gbc.gridy = 6;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        panel1.add(spacer2, gbc);
	        final JPanel spacer3 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 6;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        panel1.add(spacer3, gbc);
	        final JPanel spacer4 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 5;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(spacer4, gbc);
	        
	      //JFrame initialisation
		     frame.setContentPane(panel1);
		     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     frame.pack();
		     frame.setVisible(true);
	    }
	/**
	 * 
	 * Event se produisant lorsqu'on presse sur le bouton : "Confirmer ajout"
	 */
		private void confirmerModePayementButtonClick()
		{
			Registre.ConfirmerModePayement(this, modele.getSelectedItem().toString());
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void annulerButtonClick() {
			this.toUpperMenu();
		}
		
		
}
