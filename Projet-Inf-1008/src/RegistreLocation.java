import java.sql.Date;
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
		Client client = GestionnaireClient.getClient(res.getID_client());
		//setDonnees() on set les donnes
		location.setDateDebut(res.getDateDebut());
		location.setDateFin(res.getDateFin());
		location.setClient(client);
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
	
	/**@author Kamil MAZAN 
	 * méthode Restitution d'un vehicule 
     * @param numLoc : un numéro de Location
     * @param DateRetour : la date du retour du vehicule
     * @param nbKm :Le nombre de Km sur le compteur lors de la restitution
     * @param SommeDegats : La somme a deduire sur la garentie a cause des degats
     */
	  
	
	public void Restitution(int NumLoc,Date DateRetour,int nbKm,int SommeDegats) {
		int Somme=200; 
		DAOLocation daoCatalogueLocation = new DAOLocation();
		Location l =  new Location();
		l = daoCatalogueLocation.get(NumLoc);
		
		//On vérifie si il y'a du retard
           	  if (DateRetour.getTime()> l.getDateFin().getTime()) {
           		long diff = DateRetour.getTime() - l.getDateFin().getTime();
           		int diffrence = Long.valueOf(diff).intValue();
        // Il y'a du retard on rajoute 10$ pour chaque jour de retard   		
                Somme=Somme-(diffrence*10);
           	  }
        //On vérifie si le nombre de KM autorisé est depasser
           	  else if (nbKm-l.getNbKmDebut()>500){
           		int Km = (nbKm-l.getNbKmDebut())/100;
        // Il y'a des Km fait en trop on rajoute 10$ pour chaque 100 KM depasé
           		  Somme = Somme-Km*10;
           	  }
        // La somme finale a retirer sur la garentie
           	  Somme = Somme-SommeDegats;
        //RemboursementGarentie(l,Somme); // Cas 11 = Remboursement de la garentie
        //Suppression de la location
           	daoCatalogueLocation.delete(l);
           		 
             }

}


