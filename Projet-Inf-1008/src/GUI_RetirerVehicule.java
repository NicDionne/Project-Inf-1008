/**
 * @author Ramy
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;


import project.vehicule.CsvFileHelper;
import project.vehicule.impl.VehiculeDAOImpl;
import project.vehicule.impl.VehiculeImpl;

public class GUI_RetirerVehicule extends GUI { 
	
	final JPanel panel1 = new JPanel();
	
	String[] tab_contact;
	DefaultComboBoxModel modele;
	JComboBox liste_contact;
	private JButton confirmerAjoutButton;
	private JButton annulerButton;
	    
	
	public GUI_RetirerVehicule(GUI upperMenu)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Formulaire Supression vehicule");
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
	        String FILE_NAME = "src/test/db_vehicules.csv";
	        File file = CsvFileHelper.getResource(FILE_NAME);
	        VehiculeDAOImpl  vehiculeDao = new VehiculeDAOImpl(file);
	        List<VehiculeImpl> listVehicule = vehiculeDao.findAllVehicules();
			
			tab_contact = new String[listVehicule.size()];
			int index = 0;
			 for(VehiculeImpl vehicule : listVehicule) {
				 tab_contact[index] = vehicule.toString();
				 index++;
			 }
			
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
		    gbc.gridy = 1;
		    gbc.anchor = GridBagConstraints.EAST;
		    panel1.add(labelMode, gbc);
	        
	        

	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("Confirmer Suppression");
	        confirmerAjoutButton.addActionListener(e -> confirmerSuppressionButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 12;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerAjoutButton, gbc);

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
		private void confirmerSuppressionButtonClick()
		{
			Registre.SupressionVehicule(this,modele.getSelectedItem().toString());
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void annulerButtonClick() {
			this.toUpperMenu();
		}
		
		
}
