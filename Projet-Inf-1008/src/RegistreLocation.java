import java.util.ArrayList;

public class RegistreLocation {
	private static Location location;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Commence une location
	 */
	public static void debuterLocation(GUI upperMenu)
	{
		//On crée une location
		location = new Location();
		//Interface utilisateur traitant l'ajout d'un véhicule
		GUI_AjoutLocation gui = new GUI_AjoutLocation(upperMenu);
	}
	
	public static ArrayList<Vehicule> SaisiNoReservation(int noReservation)
	{
		GestionnaireReservation gestionnaire = new GestionnaireReservation();
		//On get la reservation par son no de reservation
		Reservation res = gestionnaire.getReservation(noReservation);
		//On vérifie qu'on a bien trouver Si on a pas trouver
		if(res == null)
		{
			return null;
		}
		//setDonnees() on set les donnes
		location.setDateDebut(res.getDateDebut());
		location.setDateFin(res.getDateFin());
		location.setClient(res.getID_client());
		//Get les vehicule dispo
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		return daoCatalogueVehicule.getVehiculeDispo(res.getCategorie(),res.getDateDebut(),res.getDateFin());
	}
	
	public static String SelectionVehicule(Vehicule vehicSelect) {
		location.setVehicule(vehicSelect);
		return location.getStringContrat();
	}
	public static String confirmationLocation()
	{
		location.confirmationLocation();
		//Mise a jour dans le systeme des dispo du vehicule
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		daoCatalogueVehicule.miseAJourDispoVehicule(location.getVehicule());
		//Savegarde de La location
		DAOLocation daoCatalogueLocation = new DAOLocation();
		int noLocation = daoCatalogueLocation.save(location);
		//Contrat de location
		return "Numéro de Location : "+ noLocation+ " \n" +location.toString();
	}
}
