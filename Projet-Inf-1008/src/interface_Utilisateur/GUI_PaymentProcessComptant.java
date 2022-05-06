package interface_Utilisateur;


import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import domaine.Registre;

public class GUI_PaymentProcessComptant extends GUI { 
	
	final JPanel panel1 = new JPanel();
	private JTextField textFieldMontant;
	
	private JButton confirmerAjoutButton;
	private JButton annulerButton;
	    
	public GUI_PaymentProcessComptant(GUI upperMenu)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Payement Comptant");
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
	        
	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("Confirmer Payement");
	        confirmerAjoutButton.addActionListener(e -> confirmerPayementButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 10;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerAjoutButton, gbc);
	        
	        
	        annulerButton = new JButton();
	        annulerButton.setText("Annuler Payement");
	        annulerButton.addActionListener(e -> annulerButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 10;
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
		private void confirmerPayementButtonClick()
		{
			Registre.ConfirmerPayementComptant(this);
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void annulerButtonClick() {
			this.toUpperMenu();
		}
		
		
}
