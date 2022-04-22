

public class GestionnaireClient {

	
	
	public static void CreationClient(String nom,String prenom, String adresse, Object noTelDom, Object noTelMob, Object noPermis, char[] noCarteBancaire)
	{
		//Code https://stackoverflow.com/questions/2683324/java-char-array-to-int
		int result = 0;
	    for (int i = 0; i < noCarteBancaire.length; i++)
	    {
	        int digit = (int)noCarteBancaire[i] - (int)'0';
	        if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
	        result *= 10;
	        result += digit;
	    }
		//Client nouveauClient = new Client(nom, prenom, adresse, (int)noTelDom, (int)noTelMob, (int)noPermis, result);
		
	}
	private static boolean verificationDonneeNom(String nom)
	{
		return false;
	}
	private static boolean verificationDonneeTel(String noTel)
	{
		return false;
	}
	private static boolean verificationDonneeNoPermis(int noTelMob)
	{
		return false;
	}
	private static boolean verificationDonneeNoCB(char[] noCarteBancaire)
	{
		return false;
	}
	
	public static void annulerCreationClient()
	{
		
	}
}
