package domaine;

import java.sql.Date;
import java.util.ArrayList;

import interface_Utilisateur.GUI;
import interface_Utilisateur.GUI_AjoutLocation;

public class RegistreLocation {
	private static Location locationEnCours;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Méthode permettant de Commencer une location
	 * 
	 */
	public static void debuterLocation(GUI upperMenu)
	{
		//On crée une location
		locationEnCours = new Location();
		//Interface utilisateur traitant l'ajout d'un véhicule
		GUI_AjoutLocation gui = new GUI_AjoutLocation(upperMenu);
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode contrôleur pour le cas Ajouter une location
	 * 
	 * @param noReservation : int numéro de réservation de la réservation 
	 * @return ArrayList<Vehicule> : Liste des véhicule répondant au crtières établis par la réservation
	 */
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
		locationEnCours.setDateDebut(res.getDateDebut());
		locationEnCours.setDateFin(res.getDateFin());
		locationEnCours.setClient(client);
		//Get les vehicule dispo
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		ArrayList<Vehicule> vehic = new ArrayList<>();
		vehic = daoCatalogueVehicule.getVehiculeDispo(res.getCategorie(),res.getDateDebut(),res.getDateFin());
		return daoCatalogueVehicule.getVehiculeDispo(res.getCategorie(),res.getDateDebut(),res.getDateFin());
	}
	
	/**
	 * @author Nicolas Dionne
	 *Methode du RegistreLocation Pour le Cas : Ajouter Une Location
	 * @param vehicSelect : Vehicule vehicule sélectionner par l'utilisateur 
	 * @return String : Le contrat de location sous forme String
	 */
	public static String SelectionVehicule(Vehicule vehicSelect) {
		locationEnCours.setVehicule(vehicSelect);
		return locationEnCours.getStringContrat();
	}
	/**
	 *Methode du RegistreLocation Pour le Cas : Ajouter Une Location
	 * 
	 * @return String : Le contrat de location finaliser avec son numéro d'identification de location
	 */
	public static String confirmationLocation()
	{
		locationEnCours.confirmationLocation();
		//Mise a jour dans le systeme des dispo du vehicule
		DAOCatalogueVehicule daoCatalogueVehicule = new DAOCatalogueVehicule();
		daoCatalogueVehicule.miseAJourDispoVehicule(locationEnCours.getVehicule());
		//Savegarde de La location
		DAOLocation daoCatalogueLocation = new DAOLocation();
		int noLocation = daoCatalogueLocation.save(locationEnCours);
		//Contrat de location
		return "Numéro de Location : "+ noLocation+ " \n" +locationEnCours.getStringContrat();
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


