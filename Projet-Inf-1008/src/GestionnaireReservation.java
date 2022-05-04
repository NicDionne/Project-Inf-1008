/** @author Quentin Tambone **/
import java.util.ArrayList;

/** représente une réservation **/
public class GestionnaireReservation {
    ArrayList<Reservation> listeReservation ;

    /** Constructeur **/
    public GestionnaireReservation(){
        listeReservation = new ArrayList<>() ;
    }

    /** méthode enregistrer qui enregistre une réservation
     * @param reservation : une reservation
     */
    public void enregistrer(Reservation reservation){
        this.listeReservation.add(reservation) ;
    }

    /**@author Quentin Tambon
     * 
     *  méthode getReservation get une réservation
     * @param numResa : un numéro de réservation
     */
    public Reservation getReservation(Integer numResa){
    	//On cherche en memoire vive
        for(Reservation r : listeReservation){
            if(r.getNumResa().equals(numResa)){
                return r ;
            }
        }
        return null ;
    }
    
    /** méthode AnnulerReservation annule une réservation
     * @param numResa : un numéro de réservation
     */
    
    public void AnnulerReservation(int numResa) {
    	  for(Reservation r : listeReservation){
              if(r.getNumResa().equals(numResa)){
            	//RemboursementReservation(r); // Cas 10 = Remboursement de la reservation
            	  r= null;
            	  System.out.println("Annulation de reservation reussi");
              }
              else System.out.println("Reservation non trouvé");
          }
    }
    
    
    
}
