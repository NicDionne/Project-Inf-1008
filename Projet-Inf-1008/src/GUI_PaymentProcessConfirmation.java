/**
 * @author Ramy
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.text.MaskFormatter;

import project.vehicule.CsvFileHelper;
import project.vehicule.impl.VehiculeDAOImpl;
import project.vehicule.impl.VehiculeImpl;

public class GUI_PaymentProcessConfirmation extends GUI { 
	
	final JPanel panel1 = new JPanel();

	private JButton confirmerAjoutButton;
	private JButton annulerButton;
	    
	
	public GUI_PaymentProcessConfirmation(GUI upperMenu, String recuTxt)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Confirmation et generation recu");
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
	        
	        
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 1;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        JTextArea textArea = new JTextArea(recuTxt, 10, 20);
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        textArea.setEditable(false); 
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 10;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        panel1.add(textArea, gbc);
	        panel1.add(scrollPane, gbc);
	        
	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("print Recu");
	        confirmerAjoutButton.addActionListener(e -> confirmerPrintButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 12;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerAjoutButton, gbc);

	        annulerButton = new JButton();
	        annulerButton.setText("Envoyer Recu");
	        annulerButton.addActionListener(e -> envoiRecuButtonClick());
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
		private void confirmerPrintButtonClick()
		{
			Registre.confirmerPrint(this);
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void envoiRecuButtonClick() {
			Registre.confirmerEnvoiRecu(this);
		}
		
		
}
