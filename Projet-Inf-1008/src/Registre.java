
public class Registre {

	
	/**
	 * @author Nicolas Dionne
	 * 
	 * Méthode ayant pour but de créer un dossier client.
	 * Elle s'occupe de faire apparaitre un GUI afin de débuter la création d'un dossier client.
	 */
	public static void demandeCreationDossierClient(GUI gui)
	{
		gui.hide();
		GUI_AjoutClient gui_AjoutClient = new GUI_AjoutClient(gui);
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Méthode ayant pour but de créer un dossier client.
	 * Elle s'occupe de faire apparaitre un GUI afin de débuter la création d'un dossier client.
	 */
	public static void creationClient(GUI gui,String nom,String prenom, String adresse, Object noTelDom, Object noTelMob, Object noPermis, char[] noCarteBancaire)
	{
		gui.showMessage("Le compte client a été créer avec succès", "Message système");
		gui.toUpperMenu();
	}
	public static void annulerCreationClient()
	{
		
	}
}
