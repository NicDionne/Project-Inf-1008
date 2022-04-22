
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
	public static void creationClient(GUI gui, String nom, String prenom, String adresse, Object noTelDom,
			Object noTelMob, Object noPermis, char[] noCarteBancaire) {
		// On v�rifie les donn�e entr� par l'utilisateur
		boolean aucuneErreur = true;

		// Code https://stackoverflow.com/questions/2683324/java-char-array-to-int
		int noCB = 0;
		for (int i = 0; i < noCarteBancaire.length; i++) {
			int digit = (int) noCarteBancaire[i] - (int) '0';
			if ((digit < 0) || (digit > 9)) {
				aucuneErreur = false;
				break;
			}
			noCB *= 10;
			noCB += digit;
		}
		if (aucuneErreur)// Si aucune erreur d'insertion (de la part du pr�pos�) ne c'est produit
		{
			GestionnaireClient.CreationClient(nom, prenom, adresse, (int)noTelDom,(int) noTelMob, (int)noPermis, noCB);
			gui.showMessage("Le compte client a �t� cr�er avec succ�s", "Message syst�me");
			gui.toUpperMenu();
		}

	}

	public static void annulerCreationClient() {

	}
}
