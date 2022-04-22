import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
/**
 * 
 * @author Nicolas Dionne
 *
 *Menu principale du registre permettant la redirection vers des fonctionnalité de d'autre menu
 */
public class GUI_Menu   {
	private JPanel panel1;
	private JButton annulerUneRéservationButton;
	private JButton ouvrirDossierClientButton;
	private JButton modifierDossierClientButton;
	private JButton ajouterClientButton;
	private JButton retirerClientButton;
	private JButton réstituerLocationButton;
	private JButton modifierUneRéservationButton;
	private JButton ajouterRéservationButton;
	private JButton deconnexionButton;
	private JButton retirerUneRéservationButton;
    private JButton ajouterLocationButton;
	private JButton consulterLaListeDesButton;
	JFrame frame = new JFrame("Menu principale");
	public GUI_Menu()
	{ 	
		panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setEnabled(true);
        panel1.setBorder(BorderFactory.createTitledBorder(null, "Registre", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer1, gbc);
        retirerClientButton = new JButton();
        retirerClientButton.addActionListener(e -> retirerClientButtonClick());
        retirerClientButton.setText("Retirer Client");
        retirerClientButton.setToolTipText("Cliquer afin de retirer un client du système");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(retirerClientButton, gbc);
        ouvrirDossierClientButton = new JButton();
        ouvrirDossierClientButton.setText("Ouvrir Dossier Client");
        ouvrirDossierClientButton.setToolTipText("Cliquer afin d'ouvrir le dossier d'un client");
        ouvrirDossierClientButton.addActionListener(e -> ouvrirDossierClientButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ouvrirDossierClientButton, gbc);
        deconnexionButton = new JButton();
        deconnexionButton.setText("Deconnexion");
        deconnexionButton.setToolTipText("Cliquer afin de vous déconnecter");
        deconnexionButton.addActionListener(e -> deconnexionButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel1.add(deconnexionButton, gbc);
        ajouterClientButton = new JButton();
        ajouterClientButton.setText("Ajouter Client");
        ajouterClientButton.setToolTipText("Cliquer afin d'ajouter un client dans le système");
        ajouterClientButton.addActionListener(e -> ajouterClientButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterClientButton, gbc);
        modifierDossierClientButton = new JButton();
        modifierDossierClientButton.setText("Modifier Dossier Client");
        modifierDossierClientButton.setToolTipText("Cliquer afin de modifier un dossier client dans le système");
        modifierDossierClientButton.addActionListener(e -> modifierDossierClientButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(modifierDossierClientButton, gbc);
        modifierUneRéservationButton = new JButton();
        modifierUneRéservationButton.setText("Modifier une réservation");
        modifierUneRéservationButton.setToolTipText("Cliquer afin de modifier une réservation déjà effectuer");
        modifierUneRéservationButton.addActionListener(e -> modifierUneRéservationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(modifierUneRéservationButton, gbc);
        ajouterRéservationButton = new JButton();
        ajouterRéservationButton.setText("Ajouter réservation");
        ajouterRéservationButton.setToolTipText("Cliquer afin d'ajouter une réservation");
        ajouterRéservationButton.addActionListener(e -> ajouterRéservationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterRéservationButton, gbc);
        retirerUneRéservationButton = new JButton();
        retirerUneRéservationButton.setEnabled(true);
        retirerUneRéservationButton.setHideActionText(false);
        retirerUneRéservationButton.setText("Retirer Une réservation");
        retirerUneRéservationButton.setToolTipText("Cliquer afin de retirer une réservation");
        retirerUneRéservationButton.addActionListener(e -> retirerUneRéservationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(retirerUneRéservationButton, gbc);
        ajouterLocationButton = new JButton();
        ajouterLocationButton.setText("Ajouter Location");
        ajouterLocationButton.setToolTipText("Cliquer afin d'ajouter une location");
        ajouterLocationButton.addActionListener(e -> ajouterLocationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterLocationButton, gbc);
        annulerUneRéservationButton = new JButton();
        annulerUneRéservationButton.setText("Annuler une réservation");
        annulerUneRéservationButton.setToolTipText("Cliquer afin d'annuler une Location en cours");
        annulerUneRéservationButton.addActionListener(e -> annulerUneRéservationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(annulerUneRéservationButton, gbc);
        réstituerLocationButton = new JButton();
        réstituerLocationButton.setText("Réstituer location");
        réstituerLocationButton.setToolTipText("Cliquer afin de faire le retour d'un véhicule");
        réstituerLocationButton.addActionListener(e -> réstituerLocationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(réstituerLocationButton, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer3, gbc);
        consulterLaListeDesButton = new JButton();
        consulterLaListeDesButton.setText("Consulter la liste des véhicule");
        consulterLaListeDesButton.setToolTipText("Cliquer afin de consulter la liste des véhicules en inventaires");
        consulterLaListeDesButton.addActionListener(e -> consulterLaListeDesButton());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(consulterLaListeDesButton, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer4, gbc);
	        
	     //JFrame initialisation
	     frame.setContentPane(panel1);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setVisible(true);
	}

	public void retirerClientButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void ouvrirDossierClientButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void deconnexionButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void ajouterClientButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void modifierDossierClientButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void modifierUneRéservationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void ajouterRéservationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void retirerUneRéservationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void ajouterLocationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void réstituerLocationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void consulterLaListeDesButton(){
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void annulerUneRéservationButtonClick() {
		JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
	}
}
