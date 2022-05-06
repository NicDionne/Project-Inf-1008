package interface_Utilisateur;

/**
 * 
 * @author Ramy
 *
 */ 
import javax.swing.*;

import domaine.Registre;

import java.awt.*;

public class GUI_AjoutVehicule extends GUI { 

	final JPanel panel1 = new JPanel();
	private JTextField textFieldCategorie;
	private JTextField textFieldMarque;
	private JTextField textFieldAnnee;
	private JTextField textFieldModel;
	private JTextField textFieldKilometrage;
	private JTextField textFieldPlaqueImmatriculation;
	private JTextField textFieldPoids;
	private JTextField textFieldCouleur;
	private JTextField textFieldCapacite;
	private JTextField textFieldTemps;
	private JTextField textFieldCommentaire;
	private JButton confirmerAjoutButton;
	private JButton annulerButton;
	    
	public GUI_AjoutVehicule(GUI upperMenu)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Formulaire ajout vehicule");
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
	        
	        
	        textFieldCategorie = new JTextField();
	        Font textFieldCategorieFont = new Font(null, -1, 16);
	        if (textFieldCategorieFont != null) textFieldCategorie.setFont(textFieldCategorieFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 1;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldCategorie, gbc);
	        final JLabel labelCategorie = new JLabel();
	        Font labelCategorieFont = new Font(null, -1, 16);
	        if (labelCategorieFont != null) labelCategorie.setFont(labelCategorieFont);
	        labelCategorie.setHorizontalAlignment(11);
	        labelCategorie.setText("Categorie de vehicule :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCategorie, gbc);
	       
	        textFieldMarque = new JTextField();
	        Font textFieldMarqueFont = new Font(null, -1, 16);
	        if (textFieldMarqueFont != null) textFieldMarque.setFont(textFieldMarqueFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 2;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldMarque, gbc);
	        final JLabel labelMarque = new JLabel();
	        Font labelMarqueFont = new Font(null, -1, 16);
	        if (labelMarqueFont != null) labelMarque.setFont(labelMarqueFont);
	        labelMarque.setHorizontalAlignment(11);
	        labelMarque.setText("Marque :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelMarque, gbc);
	        
	        textFieldAnnee = new JTextField();
	        Font textFieldAnneeFont = new Font(null, -1, 16);
	        if (textFieldAnneeFont != null) textFieldAnnee.setFont(textFieldAnneeFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldAnnee, gbc);
	        final JLabel labelAnnee = new JLabel();
	        Font labelAnneeFont = new Font(null, -1, 16);
	        if (labelAnneeFont != null) labelAnnee.setFont(labelAnneeFont);
	        labelAnnee.setHorizontalAlignment(11);
	        labelAnnee.setText("Annee :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelAnnee, gbc);
	        
	        textFieldModel = new JTextField();
	        Font textFieldModelFont = new Font(null, -1, 16);
	        if (textFieldModelFont != null) textFieldModel.setFont(textFieldModelFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 4;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldModel, gbc);
	        final JLabel labelModel = new JLabel();
	        Font labelModelFont = new Font(null, -1, 16);
	        if (labelModelFont != null) labelModel.setFont(labelModelFont);
	        labelModel.setHorizontalAlignment(0);
	        labelModel.setHorizontalTextPosition(0);
	        labelModel.setText("Model : ");
	        labelModel.setToolTipText("Inserer Model");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelModel, gbc);
	        
	        
	        textFieldKilometrage = new JTextField();
	        Font textFieldKilometrageFont = new Font(null, -1, 16);
	        if (textFieldKilometrageFont != null) textFieldKilometrage.setFont(textFieldKilometrageFont);
	        textFieldKilometrage.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 5;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldKilometrage, gbc);
	        final JLabel labelKilometrage = new JLabel();
	        Font labelKilometrageFont = new Font(null, -1, 16);
	        if (labelKilometrageFont != null) labelKilometrage.setFont(labelKilometrageFont);
	        labelKilometrage.setHorizontalAlignment(0);
	        labelKilometrage.setHorizontalTextPosition(0);
	        labelKilometrage.setText("Kilometrage : ");
	        labelKilometrage.setToolTipText("Inserer Kilometrage");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 5;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelKilometrage, gbc);
	        
	        textFieldPlaqueImmatriculation = new JTextField();
	        Font textFieldPlaqueImmatriculationFont = new Font(null, -1, 16);
	        if (textFieldPlaqueImmatriculationFont != null) textFieldPlaqueImmatriculation.setFont(textFieldPlaqueImmatriculationFont);
	        textFieldPlaqueImmatriculation.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 6;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldPlaqueImmatriculation, gbc);
	        final JLabel labelPlaqueImmatriculation = new JLabel();
	        Font labelPlaqueImmatriculationFont = new Font(null, -1, 16);
	        if (labelPlaqueImmatriculationFont != null) labelPlaqueImmatriculation.setFont(labelPlaqueImmatriculationFont);
	        labelPlaqueImmatriculation.setHorizontalAlignment(0);
	        labelPlaqueImmatriculation.setHorizontalTextPosition(0);
	        labelPlaqueImmatriculation.setText("Plaque Immatriculation : ");
	        labelPlaqueImmatriculation.setToolTipText("Inserer Plaque d'Immatriculation");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 6;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelPlaqueImmatriculation, gbc);
	        
	        textFieldPoids = new JTextField();
	        Font textFieldPoidsFont = new Font(null, -1, 16);
	        if (textFieldPoidsFont != null) textFieldPoids.setFont(textFieldPoidsFont);
	        textFieldPoids.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 7;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldPoids, gbc);
	        final JLabel labelPoids = new JLabel();
	        Font labelPoidsFont = new Font(null, -1, 16);
	        if (labelPoidsFont != null) labelPoids.setFont(labelPoidsFont);
	        labelPoids.setHorizontalAlignment(0);
	        labelPoids.setHorizontalTextPosition(0);
	        labelPoids.setText("Poids : ");
	        labelPoids.setToolTipText("Poids : ");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 7;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelPoids, gbc);
	        
	        textFieldCouleur = new JTextField();
	        Font textFieldCouleurFont = new Font(null, -1, 16);
	        if (textFieldCouleurFont != null) textFieldCouleur.setFont(textFieldCouleurFont);
	        textFieldCouleur.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 8;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldCouleur, gbc);
	        final JLabel labelCouleur = new JLabel();
	        Font labelCouleurFont = new Font(null, -1, 16);
	        if (labelCouleur != null) labelCouleur.setFont(labelCouleurFont);
	        labelCouleur.setHorizontalAlignment(0);
	        labelCouleur.setHorizontalTextPosition(0);
	        labelCouleur.setText("Couleur : ");
	        labelCouleur.setToolTipText("Inserer Couleur");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 8;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCouleur, gbc);
	        
	        textFieldCapacite = new JTextField();
	        Font textFieldCapaciteFont = new Font(null, -1, 16);
	        if (textFieldCapaciteFont != null) textFieldCapacite.setFont(textFieldCapaciteFont);
	        textFieldCapacite.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 9;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldCapacite, gbc);
	        final JLabel labelCapacite = new JLabel();
	        Font labelCapaciteFont = new Font(null, -1, 16);
	        if (labelCapacite != null) labelCapacite.setFont(labelCapaciteFont);
	        labelCapacite.setHorizontalAlignment(0);
	        labelCapacite.setHorizontalTextPosition(0);
	        labelCapacite.setText("Capacite de transport: ");
	        labelCapacite.setToolTipText("Inserer Capacite Vehicule");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 9;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCapacite, gbc);
	        
	        textFieldTemps = new JTextField();
	        Font textFieldTempsFont = new Font(null, -1, 16);
	        if (textFieldTempsFont != null) textFieldTemps.setFont(textFieldTempsFont);
	        textFieldTemps.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 10;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldTemps, gbc);
	        final JLabel labelTemps = new JLabel();
	        Font labelTempsFont = new Font(null, -1, 16);
	        if (labelTemps != null) labelTemps.setFont(labelTempsFont);
	        labelTemps.setHorizontalAlignment(0);
	        labelTemps.setHorizontalTextPosition(0);
	        labelTemps.setText("Temps : ");
	        labelTemps.setToolTipText("Temps 0 a 10km/h");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 10;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelTemps, gbc);
	        
	        textFieldCommentaire = new JTextField();
	        Font textFieldCommentaireFont = new Font(null, -1, 16);
	        if (textFieldCommentaireFont != null) textFieldCommentaire.setFont(textFieldCommentaireFont);
	        textFieldCommentaire.setColumns(25);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 11;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldCommentaire, gbc);
	        final JLabel labelCommentaire = new JLabel();
	        Font labelCommentaireFont = new Font(null, -1, 16);
	        if (labelCommentaire != null) labelCommentaire.setFont(labelCommentaireFont);
	        labelCommentaire.setHorizontalAlignment(0);
	        labelCommentaire.setHorizontalTextPosition(0);
	        labelCommentaire.setText("Commentaire sur etat du vehicule : ");
	        labelCommentaire.setToolTipText("Inserer Commentaire");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 11;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCommentaire, gbc);
	        
	        
	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("Confirmer Ajout");
	        confirmerAjoutButton.addActionListener(e -> confirmerAjoutButtonClick());
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
		private void confirmerAjoutButtonClick()
		{
			Registre.creationVehicule(this,textFieldCategorie.getText(), textFieldMarque.getText(), textFieldAnnee.getText(), textFieldModel.getText(),textFieldKilometrage.getText(),
					textFieldPlaqueImmatriculation.getText(), textFieldPoids.getText(),textFieldCouleur.getText(), textFieldCapacite.getText(), textFieldTemps.getText(),
					textFieldCommentaire.getText());
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void annulerButtonClick() {
			this.toUpperMenu();
		}
		
		
}
