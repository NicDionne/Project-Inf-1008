/**
 * @author Ramy
 */ 
import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class GUI_PaymentProcessDebit extends GUI { 
	
	final JPanel panel1 = new JPanel();
	private JTextField textFieldMontant;
	private JTextField textFieldNumCarte;
	private JTextField textFieldNumEndoCarte;
	private JTextField textFieldNomTitulaire;
	private JTextField textFieldPrenomTitulaire;
	private JTextField textFieldRue;
	private JTextField textFieldVille;
	private JTextField textFieldCodePostale;
	private JTextField textFieldProvince;
	private JTextField textFieldNumApp;
	
	private JButton confirmerAjoutButton;
	private JButton annulerButton;
	    
	public GUI_PaymentProcessDebit(GUI upperMenu)
	{ 	
		//Initialisation des variables 
		 frame = new JFrame("Formulaire Saisie information carte de debit");
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
	        
	    	textFieldNumCarte = new JTextField();
	        Font textFieldNumCarteFont = new Font(null, -1, 16);
	        if (textFieldNumCarteFont != null) textFieldNumCarte.setFont(textFieldNumCarteFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 2;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldNumCarte, gbc);
	        final JLabel labelNumCarte = new JLabel();
	        Font labelNumCarteFont = new Font(null, -1, 16);
	        if (labelNumCarteFont != null) labelNumCarte.setFont(labelNumCarteFont);
	        labelNumCarte.setHorizontalAlignment(11);
	        labelNumCarte.setText("Num Carte Debit :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNumCarte, gbc);
	        
	        textFieldNumEndoCarte = new JTextField();
	        Font textFieldNumEndoCarteFont = new Font(null, -1, 16);
	        if (textFieldNumEndoCarteFont != null) textFieldNumEndoCarte.setFont(textFieldNumEndoCarteFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 3;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldNumEndoCarte, gbc);
	        final JLabel labelNumEndoCarte = new JLabel();
	        Font labelNumEndoCarteFont = new Font(null, -1, 16);
	        if (labelNumEndoCarteFont != null) labelNumEndoCarte.setFont(labelNumEndoCarteFont);
	        labelNumEndoCarte.setHorizontalAlignment(11);
	        labelNumEndoCarte.setText("Num Endo Carte Debit :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNumEndoCarte, gbc);

	    	textFieldNomTitulaire = new JTextField();
	        Font textFieldNomTitulaireFont = new Font(null, -1, 16);
	        if (textFieldNomTitulaireFont != null) textFieldNomTitulaire.setFont(textFieldNomTitulaireFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 4;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldNomTitulaire, gbc);
	        final JLabel labelNomTitulaire = new JLabel();
	        Font labelNomTitulaireFont = new Font(null, -1, 16);
	        if (labelNomTitulaireFont != null) labelNomTitulaire.setFont(labelNomTitulaireFont);
	        labelNomTitulaire.setHorizontalAlignment(11);
	        labelNomTitulaire.setText("Nom Titulaire :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNomTitulaire, gbc);

	        textFieldPrenomTitulaire = new JTextField();
	        Font textFieldPrenomTitulaireFont = new Font(null, -1, 16);
	        if (textFieldPrenomTitulaireFont != null) textFieldPrenomTitulaire.setFont(textFieldPrenomTitulaireFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 5;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldPrenomTitulaire, gbc);
	        final JLabel labelPrenomTitulaire = new JLabel();
	        Font labelPrenomTitulaireFont = new Font(null, -1, 16);
	        if (labelPrenomTitulaireFont != null) labelPrenomTitulaire.setFont(labelPrenomTitulaireFont);
	        labelPrenomTitulaire.setHorizontalAlignment(11);
	        labelPrenomTitulaire.setText("Prenom Titulaire :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 5;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelPrenomTitulaire, gbc);
	        
	        textFieldRue = new JTextField();
	        Font textFieldRueFont = new Font(null, -1, 16);
	        if (textFieldRueFont != null) textFieldRue.setFont(textFieldRueFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 6;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldRue, gbc);
	        final JLabel labelRue = new JLabel();
	        Font labelRueFont = new Font(null, -1, 16);
	        if (labelRueFont != null) labelRue.setFont(labelRueFont);
	        labelRue.setHorizontalAlignment(11);
	        labelRue.setText("Adresse (Rue) :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 6;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelRue, gbc);

	    	textFieldVille = new JTextField();
	        Font textFieldVilleFont = new Font(null, -1, 16);
	        if (textFieldVilleFont != null) textFieldVille.setFont(textFieldVilleFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 7;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldVille, gbc);
	        final JLabel labelVille = new JLabel();
	        Font labelVilleFont = new Font(null, -1, 16);
	        if (labelVilleFont != null) labelVille.setFont(labelVilleFont);
	        labelVille.setHorizontalAlignment(11);
	        labelVille.setText("Adresse (Ville) :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 7;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelVille, gbc);
	        
	        textFieldCodePostale = new JTextField();
	        Font textFieldCodePostaleFont = new Font(null, -1, 16);
	        if (textFieldCodePostaleFont != null) textFieldCodePostale.setFont(textFieldCodePostaleFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 8;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldCodePostale, gbc);
	        final JLabel labelCodePostale = new JLabel();
	        Font labelCodePostaleFont = new Font(null, -1, 16);
	        if (labelCodePostaleFont != null) labelCodePostale.setFont(labelCodePostaleFont);
	        labelCodePostale.setHorizontalAlignment(11);
	        labelCodePostale.setText("Adresse (Code Postale) :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 8;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCodePostale, gbc);

	    	textFieldProvince = new JTextField();
	        Font textFieldProvinceFont = new Font(null, -1, 16);
	        if (textFieldProvinceFont != null) textFieldProvince.setFont(textFieldProvinceFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 9;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldProvince, gbc);
	        final JLabel labelProvince = new JLabel();
	        Font labelProvinceFont = new Font(null, -1, 16);
	        if (labelProvinceFont != null) labelProvince.setFont(labelProvinceFont);
	        labelProvince.setHorizontalAlignment(11);
	        labelProvince.setText("Adresse (Province) :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 9;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelProvince, gbc);
	        
	        textFieldNumApp = new JTextField();
	        Font textFieldNumAppFont = new Font(null, -1, 16);
	        if (textFieldNumAppFont != null) textFieldNumApp.setFont(textFieldNumAppFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 10;
	        gbc.gridwidth = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldNumApp, gbc);
	        final JLabel labelNumApp = new JLabel();
	        Font labelNumAppFont = new Font(null, -1, 16);
	        if (labelNumAppFont != null) labelNumApp.setFont(labelNumAppFont);
	        labelNumApp.setHorizontalAlignment(11);
	        labelNumApp.setText("Adresse (Num Appart) :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 10;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNumApp, gbc);
	        
	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("Confirmer Payement");
	        confirmerAjoutButton.addActionListener(e -> confirmerPayementButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 11;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerAjoutButton, gbc);
	        
	        
	        annulerButton = new JButton();
	        annulerButton.setText("Annuler Payement");
	        annulerButton.addActionListener(e -> annulerButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 11;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(annulerButton, gbc);
	        final JPanel spacer1 = new JPanel();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 11;
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
			Registre.ConfirmerPayementParCarteDebit(this, textFieldMontant.getText(), textFieldNumCarte.getText(), textFieldNomTitulaire.getText(), textFieldPrenomTitulaire.getText(), textFieldRue.getText(),textFieldVille.getText(),
					textFieldCodePostale.getText(), textFieldProvince.getText(),textFieldNumApp.getText());
		}
		/**
		 * 
		 * Event se produisant lorsqu'on presse sur le bouton : "Annuler"
		 */
		private void annulerButtonClick() {
			this.toUpperMenu();
		}
		
		
}
