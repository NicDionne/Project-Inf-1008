
import java.util.ArrayList;


/** représente une réservation **/
public class GestionnaireReservation {
    ArrayList<Reservation> listeReservation ;
    
    /** @author Quentin Tambone **/

    /** Constructeur **/
    public GestionnaireReservation(){
        listeReservation = new ArrayList<>() ;
    }
    
    /** @author Quentin Tambone **/

    /** méthode enregistrer qui enregistre une réservation
     * @param reservation : une reservation
     */
    public void enregistrer(Reservation reservation){
        this.listeReservation.add(reservation) ;
    }

    /**@author Quentin Tambone
     * 
     *  méthode getReservation get une réservation
     * @param numResa : un numéro de réservation
     */
    public Reservation getReservation(Integer numResa){
    	//On cherche en memoire vive...
        for(Reservation r : listeReservation){
            if(r.getNumResa().equals(numResa)){
                return r ;
            }
        }
        return null ;
    }
    
    /** @author Kamil Mazan **/
    
    /** méthode AnnulerReservation annule une réservation
     * @param numResa : un numéro de réservation
     */
    
    public void AnnulerReservation(int numResa) {
    	  for(Reservation r : listeReservation){
              if(r.getNumResa().equals(numResa)){
           //RemboursementReservation(r); // Cas 10 = Remboursement de la reservation
            	  r= null;
              }
          }
    }
    
    
    
}
