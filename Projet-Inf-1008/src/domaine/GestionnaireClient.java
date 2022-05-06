package domaine;



public class GestionnaireClient {
 
	private static DAOClient daoClient = new DAOClient();
	/**@author Nicolas Dionne
	 * 
	 * Methode permettant la creation d'un client et de son enregistrement
	 * 
	* @param nom : Nom du client
	 * @param prenom : Prenom du client
	 * @param Adresse : Adresse du client sous le format num�ro de maison, direction de rue, nom de rue, ville, province, ZipCode, pays
	 * @param noTelDom : Num�ro de t�l�phone du domicile du client (incluant le code r�gional en premier)
	 * @param noTelMob : Num�ro de t�l�phone mobile du client (incluant le code r�gional en premier) 
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

	/** M�thode getClient ayant pour but de r�cup�rer le dossier client.
	 * @author Nicolas Dionne
	 * @param ID_Client : int un identifiant client unique � 9 chiffres
	 * @return Client : Le client obtenue � partir de l'iDclient, null si aucun
	 */
	public static Client getClient(int ID_Client){
		DAOClient daoCLient = new DAOClient();
		return daoClient.get(ID_Client);
	}

}
