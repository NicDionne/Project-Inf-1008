
public class Registre {

	/**
	 * 
	 * Méthode ayant pour but de créer un dossier client. Elle s'occupe de
	 * faire apparaitre un GUI afin de débuter la création d'un dossier
	 * client.
	 *         
	 * @author Nicolas Dionne
	 * @param gui : GUI du menu upper
	 */
	public static void demandeCreationDossierClient(GUI gui) {
		gui.hide();
		GUI_AjoutClient gui_AjoutClient = new GUI_AjoutClient(gui);
	}

	/** Méthode ayant pour but de créer un dossier client. Elle s'occupe de
	 *  faire apparaitre un GUI afin de débuter la création d'un dossier
	 *  client.
	 * @author Nicolas Dionne
	 * 
	 *        
	 */
	public static void creationClient(GUI gui, String nom, String prenom, String adresse, String noTelDom,
			String noTelMob, String noPermis, String noCarteBancaire) {
		
		
		GestionnaireClient.CreationClient(nom, prenom, adresse, noTelDom, noTelMob, noPermis, noCarteBancaire);
		gui.showMessage("Le compte client a été créer avec succès", "Message système");
		gui.toUpperMenu();
	}

}
