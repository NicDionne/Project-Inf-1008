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
		
		upperMenu.hide();
		//Interface utilisateur traitant l'ajout d'un véhicule
		GUI_AjoutLocation gui = new GUI_AjoutLocation(upperMenu);
		
	}
	
	public static ArrayList<Vehicule> SaisiNoReservation(int noReservation)
	{
		GestionnaireReservation gestionnaire = new GestionnaireReservation();
		Reservation res = gestionnaire.getReservation(noReservation);
		location.setDateDebut(res.getDateDebut());
		location.setDateFin(res.getDateFin());
		location.setClient(res.getID_client());
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		return daoCatalogueVehicule.getVehiculeDispo(res.getCategorie(),res.getDateDebut(),res.getDateFin());
	}
	public static String SelectionVehicule(Vehicule vehicSelect) {
		location.setVehicule(vehicSelect);
		return location.getStringContrat();
	}
	public static void confirmationLocation()
	{
		location.confirmationLocation();
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		daoCatalogueVehicule.miseAJourVehicule(location.getVehicule());
		DAOLocation daoCatalogueLocation = new DAOLocation();
		int noLocation = daoCatalogueLocation.save(location);
	}
}
