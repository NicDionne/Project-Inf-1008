
public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String noTelDom;
	private String noTelMob;
	private String noPermis;
	private String	noCarteBancaire;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Constructeur de la classe client 
	 * 
	 * @param nom : Nom du client
	 * @param prenom : Prenom du client
	 * @param adresse : Adresse du client sous le format numéro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays
	 * @param noTelDom : Numéro de téléphone du domicile du client (incluant le code régional en premier)
	 * @param noTelMob : Numéro de téléphone mobile du client (incluant le code régional en premier) 
	 * @param noPermis : No de permis du client
	 * @param noCarteBancaire : No de carte bancaire du client
	 */
	public Client(String nom, String prenom, String adresse, String noTelDom,
			String noTelMob, String noPermis, String noCarteBancaire)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.noTelDom = noTelDom;
		this.noTelMob = noTelMob;
		this.noPermis = noPermis;
		this.noCarteBancaire = noCarteBancaire;
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Permet de retourner l'objet sous le format String
	 */
	public String toString()
	{
		return nom + " " + prenom + " " + adresse + " " +
	noTelDom + " " + noTelMob + " " + noPermis + " " + noCarteBancaire;
	}
	
	//Accesseur de client, ND
	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	public String getAdresse()
	{
		return adresse;
	}
	public String getNoTelDom()
	{
		return noTelDom;
	}
	public String getNoTelMob()
	{
		return noTelMob;
	}
	public String getNoPermis()
	{
		return noPermis;
	}
	public String getNoCarteBancaire()
	{
		return noCarteBancaire;
	}
	
	
}
