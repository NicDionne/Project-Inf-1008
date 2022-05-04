/** @author Kamil MAZAN **/
import java.sql.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/** représente une Location **/
public class GestionnaireLocation {
	 ArrayList<Location> listeLocation ;
	
	 /** Constructeur **/
	  public GestionnaireLocation(){
	        listeLocation = new ArrayList<>() ;
	    }
	 
	
	/** méthode Restitution d'un vehicule 
     * @param numLoc : un numéro de Location
     * @param DateRetour : la date du retour du vehicule
     * @param nbKm :Le nombre de Km sur le compteur lors de la restitution
     * @param SommeDegats : La somme a deduire sur la garentie a cause des degats
     */
	
	public void Restitution(int NumLoc,Date DateRetour,int nbKm,int SommeDegats) {
		int Somme=200; 
		
		for(Location l : listeLocation){
             if(l.getNumLoc().equals(NumLoc)){
           	  if (DateRetour.getTime()> l.getDateFin().getTime()) {
           		long diff = DateRetour.getTime() - l.getDateFin().getTime();
           		int diffrence = Long.valueOf(diff).intValue();
                Somme=Somme-(diffrence*10);
           	  }
           	  else if (nbKm-l.getNbKmDebut()>500){
           		int Km = (nbKm-l.getNbKmDebut())/100;
           		  Somme = Somme-Km*10;
           	  }
           	  Somme = Somme-SommeDegats;
           	  	//RemboursementGarentie(l,Somme); // Cas 11 = Remboursement de la garentie
           		 l=null;
           		 System.out.println("Restitution reussi");
           		 }
             else System.out.println("Restitution non trouver");
		 }
	}
	
	
	
	
}
