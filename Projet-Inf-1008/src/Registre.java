
public class Registre {

	/**
	 * @author Nicolas Dionne
	 * 
	 *         M�thode ayant pour but de cr�er un dossier client. Elle s'occupe de
	 *         faire apparaitre un GUI afin de d�buter la cr�ation d'un dossier
	 *         client.
	 */
	public static void demandeCreationDossierClient(GUI gui) {
		gui.hide();
		GUI_AjoutClient gui_AjoutClient = new GUI_AjoutClient(gui);
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 *         M�thode ayant pour but de cr�er un dossier client. Elle s'occupe de
	 *         faire apparaitre un GUI afin de d�buter la cr�ation d'un dossier
	 *         client.
	 */
	public static void creationClient(GUI gui, String nom, String prenom, String adresse, String noTelDom,
			String noTelMob, String noPermis, String noCarteBancaire) {
		
		
		GestionnaireClient.CreationClient(nom, prenom, adresse, noTelDom, noTelMob, noPermis, noCarteBancaire);
		gui.showMessage("Le compte client a �t� cr�er avec succ�s", "Message syst�me");
		gui.toUpperMenu();
		
				
				

	}

	public static void annulerCreationClient() {

	}
}