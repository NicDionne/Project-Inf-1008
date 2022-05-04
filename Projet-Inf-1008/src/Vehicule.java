import java.util.Date;

public class Vehicule {
	private String categorie;
	private int kilometrage;
	private Date date;
	private int IDVehicule;
	/**

	 * 
	 * @param categorie : Categorie du v�hicule
	 * @param kilometrage : Kilometrage de l'endometre
	 * @param dateDebut : Date de d�but de location
	 * @param dateFin : Date de fin de location
	 */
	public Vehicule(String categorie,int kilometrage, Date date, Date dateFin) {
		this.categorie = categorie;
		this.kilometrage = kilometrage;
		this.date = date;
	}
	
	/** 
	 * 
	 * @param dateDebut
	 * @param dateFin
	 */
	public void retirerDispo(Date dateDebut,Date dateFin)
	{
		
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
	 * @return int : identifiant du v�hicule
	 */
	public int getID() {
		return IDVehicule;
	}
	


}
