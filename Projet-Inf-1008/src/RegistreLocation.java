import java.util.ArrayList;

public class RegistreLocation {
	private Location location;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Commence une location
	 */
	public void debuterLocation()
	{
		this.location = new Location();
	}
	
	public ArrayList<Vehicule> SaisiNoReservation(int noReservation)
	{
		GestionnaireReservation gestionnaire = new GestionnaireReservation();
		Reservation res = gestionnaire.getReservation(noReservation);
		location.setDateDebut(res.getDateDebut());
		location.setDateFin(res.getDateFin());
		location.setClient(res.getID_client());
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		return daoCatalogueVehicule.getVehiculeDispo(res.getCategorie(),res.getDateDebut(),res.getDateFin());
	}
	public String SelectionVehicule(Vehicule vehicSelect) {
		location.setVehicule(vehicSelect);
		return location.getStringContrat();
	}
	public void confirmationLocation()
	{
		location.confirmationLocation();
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		daoCatalogueVehicule.miseAJourVehicule(location.getVehicule());
		DAOLocation daoCatalogueLocation = new DAOLocation();
		int noLocation = daoCatalogueLocation.save(location);
	}
}
