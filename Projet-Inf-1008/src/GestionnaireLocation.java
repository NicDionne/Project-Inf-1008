import java.sql.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GestionnaireLocation {
	 ArrayList<Location> listeLocation ;
	
	public static void DebuterLocation()
	{
		
	}
	public static void SaisiNoReservation(int noReservation)
	{
		
	}
	public static void SelectionVehicule(Vehicule vehicSelect)
	{
		
	}
	public static void ConfirmationLocation()
	{
		
	}
	
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
