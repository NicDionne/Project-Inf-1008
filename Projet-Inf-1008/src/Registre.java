import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JTextField;

public class Registre {

	/**
	 *
	 * M?thode ayant pour but de cr?er un dossier client. Elle s'occupe de
	 * faire apparaitre un GUI afin de d?buter la cr?ation d'un dossier
	 * client.
	 *
	 * @author Nicolas Dionne
	 * @param gui : GUI du menu upper
	 */
	public static void demandeCreationDossierClient(GUI gui) {
		gui.hide();
		new GUI_AjoutClient(gui);
	}

	/** M?thode ayant pour but de cr?er un dossier client. Elle s'occupe de
	 *  faire apparaitre un GUI afin de d?buter la cr?ation d'un dossier
	 *  client.
	 * @author Nicolas Dionne
	 *
	 *
	 */
	public static void creationClient(GUI gui, String nom, String prenom, String adresse, String noTelDom,
									  String noTelMob, String noPermis, String noCarteBancaire) {


		GestionnaireClient.CreationClient(nom, prenom, adresse, noTelDom, noTelMob, noPermis, noCarteBancaire);
		gui.showMessage("Le compte client a ?t? cr?er avec succ?s", "Message syst?me");
		gui.toUpperMenu();
	}


	/** ------------------------------------------------------------------------------------------------------------------**/


	/** M?thode creerReservation ayant pour but de cr?er une r?servation.
	 * @author Quentin Tambone
	 * @param categorie : une cat?gorie de v?hicule
	 * @param dateDebut : une date de d?but de r?servation
	 * @param dateDebut : une date de fin de r?servation
	 * @param gui : GUI du menu upper
	 */
	public Reservation creerReservation(String categorie, Date dateDebut, Date dateFin, GUI gui){
		Reservation resa = Reservation.creerReservation(categorie, dateDebut, dateFin) ;
		gui.showMessage("La r?servation a ?t? cr?er avec succ?s", "Message syst?me") ;
		gui.toUpperMenu();
		return resa ;
	}

	/** M?thode associerClientReservation ayant pour but de cr?er d'associer le client ? sa r?servation.
	 * @author Quentin Tambone
	 * @param ID_Client : un identifiant client
	 * @param resa : une reservation
	 * @param gui : GUI du menu upper
	 */
	public static void associerClientReservation(int ID_Client, Reservation resa, GUI gui){
		Client c = GestionnaireClient.getClient(ID_Client);
		resa.setID_client(ID_Client) ;
		gui.showMessage("voici le r?sum? de la reservation : " + "\n" + resa.toString(),"Message syst?me") ;
		gui.toUpperMenu();
	}

	/** M?thode confirmationReservation ayant pour but de d'enregistrer un reservation confirm?e.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param g : une gestionnaire de r?servation
	 * @param gui : GUI du menu upper
	 */
	public static void confirmationReservation(Reservation resa, GestionnaireReservation g, GUI gui){
		resa.enregistrerReservation(g) ;
		gui.showMessage("La r?servation a bien ?t? enregistr?e", "Message syst?me") ;
		gui.toUpperMenu();
	}

	/** M?thode rechercherReservation ayant pour but de trouver une reservation particuli?re.
	 * @author Quentin Tambone
	 * @param numResa : un num?ro de reservation
	 * @param g : une gestionnaire de r?servation
	 * @param gui : GUI du menu upper
	 */
	public static Reservation rechercherReservation(Integer numResa, GestionnaireReservation g, GUI gui){
		Reservation resa = g.getReservation(numResa) ;
		gui.showMessage("voici la reservation recherch?e" + "\n" + resa.toString(), "Message syst?me") ;
		gui.toUpperMenu();
		return resa ;
	}


	/** M?thode modificationReservation ayant pour but de modifier une reservation.
	 * @author Quentin Tambone
	 * @param resa : une reservation
	 * @param categorie : une cat?gorie de v?hicule
	 * @param dateDebut : une date de d?but de r?servation
	 * @param dateDebut : une date de fin de r?servation
	 * @param gui : GUI du menu upper
	 */
	public static void modificationReservation(Reservation resa, String categorie, Date dateDebut, Date dateFin, GUI gui){
		resa.setAttribut(categorie, dateDebut,dateFin) ;
		gui.showMessage("voici la reservation modifi?e" + "\n" + resa.toString(), "Message syst?me") ;
		gui.toUpperMenu();
	}


	/** M?thode demandeAjoutVehicule.
	 * @author Ramy
	 * @param gui : formulaire Ajout Vehicule
	 */
	public static void demandeAjoutVehicule(GUI gui) {
		gui.hide();
		new GUI_AjoutVehicule(gui);
	}

	/** M?thode demandeRetirerVehicule.
	 * @author Ramy
	 * @param gui : formulaire Supression Vehicule
	 */
	public static void demandeRetirerVehicule(GUI gui) {
		gui.hide();
		new GUI_RetirerVehicule(gui);
	}

	/** M?thode demandePayement ayant pour but de trouver une reservation particuli?re.
	 * @author Ramy
	 * @param gui : formulaire Demande Mode de payement
	 */
	public static void demandePayement(GUI gui) {
		gui.hide();
		new GUI_PaymentMode(gui);
	}

	/** M?thode ConfirmerModePayement.
	 * @author Ramy
	 * @param gui : formulaire information de payment
	 */
	public static void ConfirmerModePayement(GUI gui, String mode) {
		gui.hide();
		if(mode.equalsIgnoreCase("Carte Credit")) {
			new GUI_PaymentProcessCredit(gui);
		} else if (mode.equalsIgnoreCase("Carte Debit")) {
			new GUI_PaymentProcessDebit(gui);
		} else {
			new GUI_PaymentProcessComptant(gui);
		}
	}

	/** M?thode creationVehicule.
	 * @author Ramy
	 * @param categorie : categorie Vehicule
	 * @param marque : marque Vehicule
	 * @param marque : marque Vehicule
	 * @param annee : annee Vehicule
	 * @param model : model Vehicule
	 * @param kilometrage : kilometrage Vehicule
	 * @param plaqueImmatriculation : plaqueImmatriculation Vehicule
	 * @param poids : poids Vehicule
	 * @param couleur : couleur Vehicule
	 * @param capacite : capacite Vehicule
	 * @param temps : temps Vehicule
	 * @param commentaire : commentaire Vehicule
	 */
	public static void creationVehicule(GUI gui, String categorie, String marque, String annee, String model,
										String kilometrage, String plaqueImmatriculation, String poids, String couleur, String capacite, String temps, String commentaire) {
		GestionnaireVehicule.creationVehicule(categorie, marque, annee, model, kilometrage, plaqueImmatriculation, poids, couleur, capacite, temps, commentaire);
		gui.showMessage("Le vehicule a ?t? cr?er avec succ?s", "Message syst?me");
		gui.toUpperMenu();
	}

	/** M?thode SupressionVehicule.
	 * @author Ramy
	 * @param gui : formulaire Result
	 * @param vehiculestr : Vehicule
	 */
	public static void SupressionVehicule(GUI gui, String vehiculestr) {
		GestionnaireVehicule.supressionVehicule(vehiculestr.split(",")[0]);
		gui.showMessage("Le vehicule a ?t? supprime avec succ?s", "Message syst?me");
		gui.toUpperMenu();
	}


	/** M?thode ConfirmerPayementParCarteDebit.
	 * @author Ramy
	 * @param gui : formulaire Result
	 * @param montant : montant a payer
	 * @param numCarte : numero carte bancaire
	 * @param nomTitulaire : Nom Titulaire de la carte bancaire
	 * @param prenomTitulaire : Prenom Titulaire de la carte bancaire
	 * @param rue : Adresse (Rue)
	 * @param ville : Adresse (ville)
	 * @param codePostale : Adresse (codePostale)
	 * @param province : Adresse (province)
	 * @param numApp : Adresse (numApp)
	 */
	public static void ConfirmerPayementParCarteDebit(GUI gui, String montant, String numCarte, String nomTitulaire,
													  String prenomTitulaire, String rue, String ville, String codePostale, String province, String numApp) {
		gui.showMessage("Le payement a ete effectuer avec succees", "Message syst?me");
		char[] charArr = numCarte.toCharArray();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String numCartCryp = charArr[0] + charArr[1] + charArr[2] + "*******" + charArr[charArr.length-2] + charArr[charArr.length-1];

		String recuTxt = "Recu de paiment numerique\n" +
				"-------------------------\n\n" +
				"Montant Paye : " + montant + "\n" +
				"Numero de la carte : " + numCartCryp + "\n" +
				"Titulaire de la carte : " + nomTitulaire + " " + prenomTitulaire + "\n" +
				"Date : " + dtf.format(now);
		new GUI_PaymentProcessConfirmation(gui, recuTxt);
		gui.toUpperMenu();
	}

	/** M?thode ConfirmerPayementParCarteCredit.
	 * @author Ramy
	 * @param gui : formulaire Result
	 * @param montant : montant a payer
	 * @param numCarte : numero carte bancaire
	 * @param nomTitulaire : Nom Titulaire de la carte bancaire
	 * @param prenomTitulaire : Prenom Titulaire de la carte bancaire
	 * @param rue : Adresse (Rue)
	 * @param ville : Adresse (ville)
	 * @param codePostale : Adresse (codePostale)
	 * @param province : Adresse (province)
	 * @param numApp : Adresse (numApp)
	 */
	public static void ConfirmerPayementParCarteCredit(GUI gui, String montant, String numCarte, String nomTitulaire,
													   String prenomTitulaire, String rue, String ville, String codePostale, String province, String numApp) {
		gui.showMessage("Le payement a ete effectuer avec succees", "Message syst?me");
		char[] charArr = numCarte.toCharArray();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String numCartCryp = charArr[0] + charArr[1] + charArr[2] + "*******" + charArr[charArr.length-2] + charArr[charArr.length-1];

		String recuTxt = "Montant Paye : " + montant + "\n" +
				"Numero de la carte : " + numCartCryp + "\n" +
				"Titulaire de la carte : " + nomTitulaire + " " + prenomTitulaire + "\n" +
				"Date : " + dtf.format(now);
		new GUI_PaymentProcessConfirmation(gui, recuTxt);
		gui.toUpperMenu();
	}

	/** M?thode ConfirmerPayementComptant.
	 * @author Ramy
	 * @param gui : formulaire Result
	 */
	public static void ConfirmerPayementComptant(GUI gui) {
		gui.showMessage("Le payement a ete effectuer avec succees", "Message syst?me");
		gui.toUpperMenu();
	}

	/** M?thode confirmerPrint.
	 * @author Ramy
	 * @param gui : formulaire Result
	 */
	public static void confirmerPrint(GUI gui) {
		gui.showMessage("Print du recu effectuer avec succes", "Message syst?me");
		gui.toUpperMenu();
	}

	/** M?thode confirmerEnvoiRecu.
	 * @author Ramy
	 * @param gui : formulaire Result
	 */
	public static void confirmerEnvoiRecu(GUI gui) {
		gui.showMessage("Print du recu effectuer avec succes", "Message syst?me");
		gui.toUpperMenu();
	}


}
