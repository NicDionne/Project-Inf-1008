package domaine;



public class GestionnaireClient {
 
	private static DAOClient daoClient = new DAOClient();
	/**@author Nicolas Dionne
	 * 
	 * Methode permettant la creation d'un client et de son enregistrement
	 * 
	* @param nom : Nom du client
	 * @param prenom : Prenom du client
	 * @param Adresse : Adresse du client sous le format numéro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays
	 * @param noTelDom : Numéro de téléphone du domicile du client (incluant le code régional en premier)
	 * @param noTelMob : Numéro de téléphone mobile du client (incluant le code régional en premier) 
	 * @param noPermis : No de permis du client
	 * @param noCarteBancaire : No de carte bancaire du client
	 * @return 
	 */
	public static int CreationClient(String nom, String prenom, String adresse, String noTelDom,
			String noTelMob, String noPermis, String noCarteBancaire)
	{
		int IDClient;
		Client nouveauClient = new Client(nom, prenom, adresse, noTelDom,noTelMob, noPermis, noCarteBancaire);
		IDClient = daoClient.save(nouveauClient);
		return IDClient;
	}
	
	
	public static void annulerCreationClient()
	{
		
	}

	/** Méthode getClient ayant pour but de récupérer le dossier client.
	 * @author Nicolas Dionne
	 * @param ID_Client : int un identifiant client unique à 9 chiffres
	 * @return Client : Le client obtenue à partir de l'iDclient, null si aucun
	 */
	public static Client getClient(int ID_Client){
		DAOClient daoCLient = new DAOClient();
		return daoClient.get(ID_Client);
	}

}
