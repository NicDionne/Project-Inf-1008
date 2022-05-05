import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import javax.swing.UIManager.*;
/**
 *
 * @author Nicolas Dionne
 *
 *Menu principale du registre utilis� grandement par le pr�pos�. 
 *Ce menu permet d'afficher les options principales disponibles � lui.
 *Lorsque le gestionnaire d�cide une option ce menu le redirige vers le bon gestionnaire de cas d'utilisation.
 *
 *Fait avec l'aide de IntelliJ IDEA
 */
public class GUI_Menu  extends GUI {
    private JPanel panel1;
    private JButton annulerUneR�servationButton;
    private JButton ouvrirDossierClientButton;
    private JButton modifierDossierClientButton;
    private JButton ajouterClientButton;
    private JButton retirerClientButton;
    private JButton r�stituerLocationButton;
    private JButton modifierUneR�servationButton;
    private JButton ajouterR�servationButton;
    private JButton deconnexionButton;
    private JButton retirerUneR�servationButton;
    private JButton ajouterLocationButton;
    private JButton consulterLaListeDesButton;
    private JButton ajouterVehiculeButton;
    private JButton retirerVehiculeButton;

    public GUI_Menu()
    {
        frame = new JFrame("Menu principale");
        //Set le menu sup�rieur
        this.upperMenu = this;

        //Pour le style r�f : https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
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
        retirerClientButton.setToolTipText("Cliquer afin de retirer un client du syst�me");
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
        deconnexionButton.setToolTipText("Cliquer afin de vous d�connecter");
        deconnexionButton.addActionListener(e -> deconnexionButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel1.add(deconnexionButton, gbc);
        ajouterClientButton = new JButton();
        ajouterClientButton.setText("Ajouter Client");
        ajouterClientButton.setToolTipText("Cliquer afin d'ajouter un client dans le syst�me");
        ajouterClientButton.addActionListener(e -> ajouterClientButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterClientButton, gbc);


        modifierDossierClientButton = new JButton();
        modifierDossierClientButton.setText("Modifier Dossier Client");
        modifierDossierClientButton.setToolTipText("Cliquer afin de modifier un dossier client dans le syst�me");
        modifierDossierClientButton.addActionListener(e -> modifierDossierClientButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(modifierDossierClientButton, gbc);
        modifierUneR�servationButton = new JButton();
        modifierUneR�servationButton.setText("Modifier une r�servation");
        modifierUneR�servationButton.setToolTipText("Cliquer afin de modifier une r�servation d�j� effectuer");
        modifierUneR�servationButton.addActionListener(e -> modifierUneR�servationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(modifierUneR�servationButton, gbc);
        ajouterR�servationButton = new JButton();
        ajouterR�servationButton.setText("Ajouter r�servation");
        ajouterR�servationButton.setToolTipText("Cliquer afin d'ajouter une r�servation");
        ajouterR�servationButton.addActionListener(e -> ajouterR�servationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterR�servationButton, gbc);
        retirerUneR�servationButton = new JButton();
        retirerUneR�servationButton.setEnabled(true);
        retirerUneR�servationButton.setHideActionText(false);
        retirerUneR�servationButton.setText("Retirer Une r�servation");
        retirerUneR�servationButton.setToolTipText("Cliquer afin de retirer une r�servation");
        retirerUneR�servationButton.addActionListener(e -> retirerUneR�servationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(retirerUneR�servationButton, gbc);
        ajouterLocationButton = new JButton();
        ajouterLocationButton.setText("Ajouter Location");
        ajouterLocationButton.setToolTipText("Cliquer afin d'ajouter une location");
        ajouterLocationButton.addActionListener(e -> ajouterLocationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterLocationButton, gbc);
        annulerUneR�servationButton = new JButton();
        annulerUneR�servationButton.setText("Annuler une r�servation");
        annulerUneR�servationButton.setToolTipText("Cliquer afin d'annuler une Location en cours");
        annulerUneR�servationButton.addActionListener(e -> annulerUneR�servationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(annulerUneR�servationButton, gbc);
        r�stituerLocationButton = new JButton();
        r�stituerLocationButton.setText("R�stituer location");
        r�stituerLocationButton.setToolTipText("Cliquer afin de faire le retour d'un v�hicule");
        r�stituerLocationButton.addActionListener(e -> r�stituerLocationButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(r�stituerLocationButton, gbc);
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
        consulterLaListeDesButton.setText("Consulter la liste des v�hicule");
        consulterLaListeDesButton.setToolTipText("Cliquer afin de consulter la liste des v�hicules en inventaires");
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

        ajouterVehiculeButton = new JButton();
        ajouterVehiculeButton.setText("Ajouter Vehicule");
        ajouterVehiculeButton.setToolTipText("Cliquer afin d'ajouter un vehicule");
        ajouterVehiculeButton.addActionListener(e -> ajouterVehiculeButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(ajouterVehiculeButton, gbc);

        retirerVehiculeButton = new JButton();
        retirerVehiculeButton.setText("Retirer Vehicule");
        retirerVehiculeButton.setToolTipText("Cliquer afin de retirer un vehicule");
        retirerVehiculeButton.addActionListener(e -> retirerVehiculeButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(retirerVehiculeButton, gbc);

        retirerVehiculeButton = new JButton();
        retirerVehiculeButton.setText("Payment");
        retirerVehiculeButton.setToolTipText("Cliquer afin de lancer le module du payement");
        retirerVehiculeButton.addActionListener(e -> payementButtonClick());
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(retirerVehiculeButton, gbc);


        //JFrame initialisation
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void retirerClientButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void ouvrirDossierClientButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void deconnexionButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void ajouterClientButtonClick() {
        Registre.demandeCreationDossierClient(this);
    }
    private void modifierDossierClientButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void modifierUneR�servationButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void ajouterR�servationButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void retirerUneR�servationButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void ajouterLocationButtonClick() {
        RegistreLocation.debuterLocation(upperMenu);
    }
    private void r�stituerLocationButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void consulterLaListeDesButton(){
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }
    private void annulerUneR�servationButtonClick() {
        JOptionPane.showMessageDialog(null, "Cette option est toujours en beta ", "Message administratif " , JOptionPane.INFORMATION_MESSAGE);
    }

    private void ajouterVehiculeButtonClick() {
        Registre.demandeAjoutVehicule(this);
    }

    private void retirerVehiculeButtonClick() {
        Registre.demandeRetirerVehicule(this);
    }

    private void payementButtonClick() {
        Registre.demandePayement(this);
    }

}
