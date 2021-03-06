package domaine;


public class Client {
	private static int compteurClient =0; 
	private String nom;
	private String prenom;
	private String adresse;
	private String noTelDom;
	private String noTelMob;
	private String noPermis;
	private String	noCarteBancaire;
	private int idClient;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Constructeur de la classe client 
	 * 
	 * @param nom : Nom du client
	 * @param prenom : Prenom du client
	 * @param adresse : Adresse du client sous le format num?ro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays
	 * @param noTelDom : Num?ro de t?l?phone du domicile du client (incluant le code r?gional en premier)
	 * @param noTelMob : Num?ro de t?l?phone mobile du client (incluant le code r?gional en premier) 
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
	 * Constructeur de la classe client 

	 */
	public Client()
	{
		
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
	
	
	//Accesseur de client, N.D.
	public int getIDClient()
	{ 
		return idClient;
	}
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
	
	//Setter N.D.
	public void setIDClient(int idClient)
	{ 
		this.idClient = idClient;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	public void setNoTelDom(String noTelDom)
	{
		this.noTelDom = noTelDom;
	}
	public void setNoTelMob(String noTelMob)
	{
		this.noTelMob = noTelMob;
	}
	public void setNoPermis(String noPermis)
	{
		this.noPermis = noPermis;
	}
	public void setNoCarteBancaire(String noCarteBancaire)
	{
		this.noCarteBancaire = noCarteBancaire;
	}
	
}
