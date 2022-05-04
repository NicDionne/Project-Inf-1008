import java.util.Date;

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
	 * @param gui : Gui du menu upper
	 * @param nom : String nom de l'utilisateur
	 * @param prenom : String prenom de l'utilisateur
	 * @param adresse : String adresse de l'utilisateur
	 * @param noTelDom : String noTel domiciliaire de l'utilisateur
	 * @param noTelMob : String noTel Mobile de l'utilisateur
	 * @param noPermis : String no de permis de l'utilisateur
	 * @param noCarteBancaire : String no de Cart bancaire de l'utilisateur
	 */
	public static void creationClient(GUI gui, String nom, String prenom, String adresse, String noTelDom,
			String noTelMob, String noPermis, String noCarteBancaire) {
		int IDClient;
		IDClient = GestionnaireClient.CreationClient(nom, prenom, adresse, noTelDom, noTelMob, noPermis, noCarteBancaire);
		gui.showMessage("Le compte client a été créer avec succès. Nouvelle Identifiant du client : " + IDClient, "Message système");
		gui.toUpperMenu();
	}


	/** ------------------------------------------------------------------------------------------------------------------**/


	/** Méthode creerReservation ayant pour but de créer une réservation.
	 * @author Quentin Tambone
	 * @param categorie : une catégorie de véhicule
	 * @param dateDebut : une date de début de réservation
	 * @param dateDebut : une date de fin de réservation
	 * @param gui : GUI du menu upper
	 */
	public Reservation creerReservation(String categorie, Date dateDebut, Date dateFin, GUI gui){
		Reservation resa = Reservation.creerReservation(categorie, dateDebut, dateFin) ;
		gui.showMessage("La réservation a été créer avec succès", "Message système") ;
		gui.toUpperMenu();
		return resa ;
	}

	/** Méthode associerClientReservation ayant pour but de créer d'associer le client à sa réservation.
	 * @author Quentin Tambone
	 * @param ID_Client : un identifiant client
	 * @param resa : une reservation
	 * @param gui : GUI du menu upper
	 */
	public static void associerClientReservation(int ID_Client, Reservation resa, GUI gui){
		Client c = GestionnaireClient.getClient(ID_Client);
		resa.setID_client(ID_Client) ;
		gui.showMessage("voici le résumé de la reservation : " + "\n" + resa.toString(),"Message système") ;
		gui.toUpperMenu();
	}

	/** Méthode confirmationReservation ayant pour but de d'enregistrer un reservation confirmée.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param g : une gestionnaire de réservation
	 * @param gui : GUI du menu upper
	 */
	public static void confirmationReservation(Reservation resa, GestionnaireReservation g, GUI gui){
		resa.enregistrerReservation(g) ;
		gui.showMessage("La réservation a bien été enregistrée", "Message système") ;
		gui.toUpperMenu();
	}

	/** Méthode rechercherReservation ayant pour but de trouver une reservation particulière.
	 * @author Quentin Tambone
	 * @param numResa : un numéro de reservation
	 * @param g : une gestionnaire de réservation
	 * @param gui : GUI du menu upper
	 */
	public static Reservation rechercherReservation(Integer numResa, GestionnaireReservation g, GUI gui){
		Reservation resa = g.getReservation(numResa) ;
		gui.showMessage("voici la reservation recherchée" + "\n" + resa.toString(), "Message système") ;
		gui.toUpperMenu();
		return resa ;
	}


	/** Méthode modificationReservation ayant pour but de modifier une reservation.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param categorie : une catégorie de véhicule
	 * @param dateDebut : une date de début de réservation
	 * @param dateDebut : une date de fin de réservation
	 * @param gui : GUI du menu upper
	 */
	public static void modificationReservation(Reservation resa, String categorie, Date dateDebut, Date dateFin, GUI gui){
		resa.setAttribut(categorie, dateDebut,dateFin) ;
		gui.showMessage("voici la reservation modifiée" + "\n" + resa.toString(), "Message système") ;
		gui.toUpperMenu();
	}

}
