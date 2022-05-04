import java.util.Date;

public class Vehicule {
	private String categorie;
	private int kilometrage;
	private Date date;
	private String IDVehicule;
	private String dispo;
	/**INFO SUR MANIÈRE SAUVEGARDE DISPONIBILITÉ
	 * @author Nicolas Dionne
	 * 
	 * 256 charactères sont 
	 * utilisé afin de laisser savoir leur disponibilité
	 * 
	 * 0 : Non - disponible
	 * 1 : Disponible
	 * 2 : Reserver
	 * 3 : En réparation
	 * 
	 */
	/**

	 * 
	 * @param categorie : Categorie du véhicule
	 * @param kilometrage : Kilometrage de l'endometre
	 * @param dateDebut : Date de début de location
	 * @param dateFin : Date de fin de location
	 */
	public Vehicule(String categorie,int kilometrage, Date date, Date dateFin,String dispo) {
		this.categorie = categorie;
		this.kilometrage = kilometrage;
		this.date = date;
		this.dispo = dispo;
	}
	
	public Vehicule()
	{
		
	}
	
	/** @author Nicolas Dionne
	 * 
	 * Méthode permetant de retiré les dispo du véhicule entre deux dates inclusivement.
	 * 
	 * @param dateDebut : Date de début de l'intervalle maintenant indisponible
	 * @param dateFin : Date de fin de l'intervalle maintenant indisponible
	 */
	public void retirerDispo(Date dateDebut,Date dateFin)
	{
		//On prend la date de début - la date d'ajourd'hui afin de calculer combien de charactère nous devons sauter
		int coordonneDebut =  converterMilisecondsToDay(dateDebut.getTime() - new Date().getTime()  );
				
		//On calcule l'intervalle de jour nécessaire de disponibilité
		int coordonneFin = coordonneDebut + converterMilisecondsToDay(dateFin.getTime() - dateDebut.getTime()  );
		
		//On transforme les dispo en tab de char
		char[] dispoTab = dispo.toCharArray();
		
		//On itère sur les jour de dispo à changer du véhicule
		for(int i = coordonneDebut; i < coordonneFin && i < dispo.length() ; i++)
			dispoTab[i] = '0'; // On indique indisponible
		
		//On re-transforme en String
		dispo = String.valueOf(dispoTab);
	}
	
	//Accesseur
	/**
	 * @Author Nicolas Dionne
	 * Getter pour la categorie
	 * @return String : la categorie de vehicule 
	 */
	public String getCategorie()
	{
		return categorie;
	}
	/**
	 * @Author Nicolas Dionne
	 * Getter pour le kilometrage
	 * @return int : le kilometrage du vehicule 
	 */
	public int getKilometrage()
	{
		return kilometrage;
	}
	/**
	 * @Author Nicolas Dionne
	 * Getter pour la date 
	 * @return Date : date de naissance du vehicule
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * @Author Nicolas Dionne
	 * Getter pour l'identifiant du vehicule 
	 * @return int : identifiant du véhicule
	 */
	public String getID() {
		return IDVehicule;
	}
	
	/**
	 * @Author Nicolas Dionne
	 * Setter pour la categorie
	 * @param categorie : String la categorie de vehicule 
	 */
	public void setCategorie(String categorie)
	{
		this.categorie = categorie;
	}
	/**
	 * @Author Nicolas Dionne
	 * Setter pour le Kilometrage
	 * @param kilometrage : int le kilometrage de vehicule 
	 */
	public void setKilometrage(int kilometrage)
	{
		this.kilometrage = kilometrage;
	}
	/**
	 * @Author Nicolas Dionne
	 * Setter pour la date du véhicule
	 * @param date : Date du vehicule 
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}
	/**
	 * @Author Nicolas Dionne
	 * Setter pour l'identifiant du véhicule unique
	 * @param nouvelleID : String identifiant unique du vehicule 
	 */
	public void setID(String nouvelleID) {
		IDVehicule = nouvelleID;
	}
	/**@author Nicolas Dionne
	 *Setter pour les dispo du véhicule
	 * @param dispo : String comportant les dispo du véhicule
	 * 256 charactères sont 
	 * utilisé afin de laisser savoir leur disponibilité
	 * 
	 * 0 : Non - disponible
	 * 1 : Disponible
	 * 2 : Reserver
	 * 3 : En réparation
	 */
	public void setDispo(String dispo)
	{
		this.dispo = dispo;
	}
	
	/**@author Nicolas Dionne
	 *Getter pour les dispo du véhicule
	 * @return dispo : String comportant les dispo du véhicule
	 * 256 charactères sont 
	 * utilisé afin de laisser savoir leur disponibilité
	 * 
	 * 0 : Non - disponible
	 * 1 : Disponible
	 * 2 : Reserver
	 * 3 : En réparation
	 */
	public String getDispo()
	{
		return dispo;
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * Méthode permettant de convertir des milisecondes en jour
	 * 
	 * @param miliseconds : long un nombre de jour en milisecondes
	 * @return int : l'équivalent du nombre de miliseconds en jour
	 */
	private int converterMilisecondsToDay(long miliseconds)
	{
		miliseconds /=24; //Pour chaque heure dans une journée
		miliseconds /=60; //Pour chaque minute dans un heure
		miliseconds /=60 ;//Pour chaque seconde dans une minute
		miliseconds /=1000 ;// Puisque miliseconds
		return (int) miliseconds;
	}


}
