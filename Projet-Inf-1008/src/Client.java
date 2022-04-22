
public class Client {
	private String nom;
	private String prenom;
	private String Adresse;
	private int noTelDom;
	private int noTelMob;
	private int noPermis;
	private int	noCarteBancaire;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Constructeur de la classe client 
	 * 
	 * @param nom : Nom du client
	 * @param prenom : Prenom du client
	 * @param Adresse : Adresse du client sous le format numéro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays
	 * @param noTelDom : Numéro de téléphone du domicile du client (incluant le code régional en premier)
	 * @param noTelMob : Numéro de téléphone mobile du client (incluant le code régional en premier) 
	 * @param noPermis : No de permis du client
	 * @param noCarteBancaire : No de carte bancaire du client
	 */
	public Client(String nom,String prenom, String Adresse, int noTelDom,int noTelMob, int noPermis, int noCarteBancaire)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.Adresse = Adresse;
		this.noTelDom = noTelDom;
		this.noTelMob = noTelMob;
		this.noPermis = noPermis;
		this.noCarteBancaire = noCarteBancaire;
	}
	
	
}
