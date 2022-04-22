import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Nicolas Dionne
 *
 * Menu du préposé utilisé pour l'ajout d'un client.
 * Le menu ce ferme que lorsque le préposé annule l'ajout d'un client ou lorsqu'il confirme l'ajout d'un client.
 * 
 *Fait avec l'aide de IntelliJ IDEA
 */
public class GUI_AjoutClient {
	JFrame frame = new JFrame("Formulaire ajout client");
	final JPanel panel1 = new JPanel();
	 private JTextField textFieldNom;
	   private JTextField textFieldPrenom;
	    private JTextField textFieldAdresse;
	    private JFormattedTextField formattedTextFieldTelDom;
	    private JFormattedTextField formattedTextFieldTelMob;
	    private JFormattedTextField formattedTextFieldNoPermis;
	    private JPasswordField passwordFieldCB;
	    private JButton confirmerAjoutButton;
	    private JButton annulerButton;
	public GUI_AjoutClient()
	{ 	
		 
		 //JFrame initialisation
	     frame.setContentPane(panel1);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setVisible(true);
	        panel1.setLayout(new GridBagLayout());
	        final JLabel labelCB = new JLabel();
	      //  Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
	      //  if (label1Font != null) label1.setFont(label1Font);
	        labelCB.setHorizontalAlignment(11);
	        labelCB.setText("Nuémero carte Bancaire : ");
	        GridBagConstraints gbc;
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 8;
	        gbc.gridwidth = 9;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelCB, gbc);
	        final JToolBar toolBar1 = new JToolBar();
	        gbc = new GridBagConstraints();
	        gbc.gridx = 2;
	        gbc.gridy = 9;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(toolBar1, gbc);
	        textFieldNom = new JTextField();
	        Font textFieldNomFont = new Font(null, -1, 16);
	        if (textFieldNomFont != null) textFieldNom.setFont(textFieldNomFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 1;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldNom, gbc);
	        final JLabel labelNom = new JLabel();
	        Font labelNomFont = new Font(null, -1, 16);
	        if (labelNomFont != null) labelNom.setFont(labelNomFont);
	        labelNom.setHorizontalAlignment(11);
	        labelNom.setText("Nom :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNom, gbc);
	        textFieldPrenom = new JTextField();
	        Font textFieldPrenomFont = new Font(null, -1, 16);
	        if (textFieldPrenomFont != null) textFieldPrenom.setFont(textFieldPrenomFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 2;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldPrenom, gbc);
	        final JLabel labelPrenom = new JLabel();
	        Font labelPrenomFont = new Font(null, -1, 16);
	        if (labelPrenomFont != null) labelPrenom.setFont(labelPrenomFont);
	        labelPrenom.setHorizontalAlignment(11);
	        labelPrenom.setText("Prenom :");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelPrenom, gbc);
	        textFieldAdresse = new JTextField();
	        Font textFieldAdresseFont = new Font(null, -1, 16);
	        if (textFieldAdresseFont != null) textFieldAdresse.setFont(textFieldAdresseFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(textFieldAdresse, gbc);
	        final JLabel labelAdresse = new JLabel();
	        Font labelAdresseFont = new Font(null, -1, 16);
	        if (labelAdresseFont != null) labelAdresse.setFont(labelAdresseFont);
	        labelAdresse.setHorizontalAlignment(0);
	        labelAdresse.setHorizontalTextPosition(0);
	        labelAdresse.setText("Adresse : ");
	        labelAdresse.setToolTipText("Inserer en respectant le format numéro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelAdresse, gbc);
	        final JLabel labelTel = new JLabel();
	        Font labelTelFont = new Font(null, -1, 16);
	        if (labelTelFont != null) labelTel.setFont(labelTelFont);
	        labelTel.setHorizontalAlignment(11);
	        labelTel.setText("Tél :     ");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelTel, gbc);
	        formattedTextFieldTelDom = new JFormattedTextField();
	        Font formattedTextFieldTelDomFont = new Font(null, -1, 16);
	        if (formattedTextFieldTelDomFont != null) formattedTextFieldTelDom.setFont(formattedTextFieldTelDomFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 5;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(formattedTextFieldTelDom, gbc);
	        formattedTextFieldTelMob = new JFormattedTextField();
	        Font formattedTextFieldTelMobFont = new Font(null, -1, 16);
	        if (formattedTextFieldTelMobFont != null) formattedTextFieldTelMob.setFont(formattedTextFieldTelMobFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 6;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(formattedTextFieldTelMob, gbc);
	        formattedTextFieldNoPermis = new JFormattedTextField();
	        Font formattedTextFieldNoPermisFont = new Font(null, -1, 16);
	        if (formattedTextFieldNoPermisFont != null) formattedTextFieldNoPermis.setFont(formattedTextFieldNoPermisFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 9;
	        gbc.gridy = 7;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(formattedTextFieldNoPermis, gbc);
	        final JLabel labelNoPermis = new JLabel();
	        Font labelNoPermisFont = new Font(null, -1, 16);
	        if (labelNoPermisFont != null) labelNoPermis.setFont(labelNoPermisFont);
	        labelNoPermis.setHorizontalAlignment(11);
	        labelNoPermis.setText("Numéro de permis : ");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 7;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelNoPermis, gbc);
	        final JLabel labelTelMob = new JLabel();
	        Font labelTelMobFont = new Font(null, Font.ITALIC, 16);
	        if (labelTelMobFont != null) labelTelMob.setFont(labelTelMobFont);
	        labelTelMob.setText("Mobile");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 6;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelTelMob, gbc);
	        final JLabel labelTelDom = new JLabel();
	        Font labelTelDomFont = new Font(null, Font.ITALIC, 16);
	        if (labelTelDomFont != null) labelTelDom.setFont(labelTelDomFont);
	        labelTelDom.setText("Domicile");
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 5;
	        gbc.anchor = GridBagConstraints.EAST;
	        panel1.add(labelTelDom, gbc);
	        passwordFieldCB = new JPasswordField();
	        passwordFieldCB.setColumns(9);
	        Font passwordFieldCBFont = new Font(null, -1, 16);
	        if (passwordFieldCBFont != null) passwordFieldCB.setFont(passwordFieldCBFont);
	        gbc = new GridBagConstraints();
	        gbc.gridx = 10;
	        gbc.gridy = 8;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(passwordFieldCB, gbc);
	        confirmerAjoutButton = new JButton();
	        confirmerAjoutButton.setText("Confirmer Ajout");
	        confirmerAjoutButton.addActionListener(e -> confirmerAjoutButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 3;
	        gbc.gridy = 9;
	        gbc.gridwidth = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.add(confirmerAjoutButton, gbc);
	        annulerButton = new JButton();
	        annulerButton.setText("Annuler");
	        annulerButton.addActionListener(e -> annulerButtonClick());
	        gbc = new GridBagConstraints();
	        gbc.gridx = 1;
	        gbc.gridy = 9;
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
		private void confirmerAjoutButtonClick()
		{
			GestionnaireClient.CreationClient(textFieldNom.getText(), textFieldPrenom.getText(), textFieldAdresse.getText(),formattedTextFieldTelDom.getValue(),
					formattedTextFieldTelMob.getValue(), formattedTextFieldNoPermis.getValue(),passwordFieldCB.getPassword());
		}
		private void annulerButtonClick() {
			GestionnaireClient.annulerCreationClient();
		}
}
