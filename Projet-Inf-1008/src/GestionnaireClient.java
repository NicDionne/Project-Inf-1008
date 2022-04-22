

public class GestionnaireClient {

	
	
	public static void CreationClient(String nom,String prenom, String adresse, int noTelDom, int noTelMob, int noPermis, int noCarteBancaire)
	{
	
		Client nouveauClient = new Client(nom, prenom, adresse, noTelDom,noTelMob, noPermis, noCarteBancaire);
		
	}
	
	
	public static void annulerCreationClient()
	{
		
	}
}
