import java.util.Date;

public class Registre {

	/**
	 * 
	 * M�thode ayant pour but de cr�er un dossier client. Elle s'occupe de
	 * faire apparaitre un GUI afin de d�buter la cr�ation d'un dossier
	 * client.
	 *         
	 * @author Nicolas Dionne
	 * @param gui : GUI du menu upper
	 */
	public static void demandeCreationDossierClient(GUI gui) {
		gui.hide();
		GUI_AjoutClient gui_AjoutClient = new GUI_AjoutClient(gui);
	}

	/** M�thode ayant pour but de cr�er un dossier client. Elle s'occupe de
	 *  faire apparaitre un GUI afin de d�buter la cr�ation d'un dossier
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
		gui.showMessage("Le compte client a �t� cr�er avec succ�s. Nouvelle Identifiant du client : " + IDClient, "Message syst�me");
		gui.toUpperMenu();
	}


	/** ------------------------------------------------------------------------------------------------------------------**/


	/** M�thode creerReservation ayant pour but de cr�er une r�servation.
	 * @author Quentin Tambone
	 * @param categorie : une cat�gorie de v�hicule
	 * @param dateDebut : une date de d�but de r�servation
	 * @param dateDebut : une date de fin de r�servation
	 * @param gui : GUI du menu upper
	 */
	public Reservation creerReservation(String categorie, Date dateDebut, Date dateFin, GUI gui){
		Reservation resa = Reservation.creerReservation(categorie, dateDebut, dateFin) ;
		gui.showMessage("La r�servation a �t� cr�er avec succ�s", "Message syst�me") ;
		gui.toUpperMenu();
		return resa ;
	}

	/** M�thode associerClientReservation ayant pour but de cr�er d'associer le client � sa r�servation.
	 * @author Quentin Tambone
	 * @param ID_Client : un identifiant client
	 * @param resa : une reservation
	 * @param gui : GUI du menu upper
	 */
	public static void associerClientReservation(int ID_Client, Reservation resa, GUI gui){
		Client c = GestionnaireClient.getClient(ID_Client);
		resa.setID_client(ID_Client) ;
		gui.showMessage("voici le r�sum� de la reservation : " + "\n" + resa.toString(),"Message syst�me") ;
		gui.toUpperMenu();
	}

	/** M�thode confirmationReservation ayant pour but de d'enregistrer un reservation confirm�e.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param g : une gestionnaire de r�servation
	 * @param gui : GUI du menu upper
	 */
	public static void confirmationReservation(Reservation resa, GestionnaireReservation g, GUI gui){
		resa.enregistrerReservation(g) ;
		gui.showMessage("La r�servation a bien �t� enregistr�e", "Message syst�me") ;
		gui.toUpperMenu();
	}

	/** M�thode rechercherReservation ayant pour but de trouver une reservation particuli�re.
	 * @author Quentin Tambone
	 * @param numResa : un num�ro de reservation
	 * @param g : une gestionnaire de r�servation
	 * @param gui : GUI du menu upper
	 */
	public static Reservation rechercherReservation(Integer numResa, GestionnaireReservation g, GUI gui){
		Reservation resa = g.getReservation(numResa) ;
		gui.showMessage("voici la reservation recherch�e" + "\n" + resa.toString(), "Message syst�me") ;
		gui.toUpperMenu();
		return resa ;
	}


	/** M�thode modificationReservation ayant pour but de modifier une reservation.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param categorie : une cat�gorie de v�hicule
	 * @param dateDebut : une date de d�but de r�servation
	 * @param dateDebut : une date de fin de r�servation
	 * @param gui : GUI du menu upper
	 */
	public static void modificationReservation(Reservation resa, String categorie, Date dateDebut, Date dateFin, GUI gui){
		resa.setAttribut(categorie, dateDebut,dateFin) ;
		gui.showMessage("voici la reservation modifi�e" + "\n" + resa.toString(), "Message syst�me") ;
		gui.toUpperMenu();
	}

}
