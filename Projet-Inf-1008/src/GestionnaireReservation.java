
import java.util.ArrayList;


/** repr�sente une r�servation **/
public class GestionnaireReservation {
    ArrayList<Reservation> listeReservation ;
    
    /** @author Quentin Tambone **/

    /** Constructeur **/
    public GestionnaireReservation(){
        listeReservation = new ArrayList<>() ;
    }
    
    /** @author Quentin Tambone **/

    /** m�thode enregistrer qui enregistre une r�servation
     * @param reservation : une reservation
     */
    public void enregistrer(Reservation reservation){
        this.listeReservation.add(reservation) ;
    }

    /**@author Quentin Tambone
     * 
     *  m�thode getReservation get une r�servation
     * @param numResa : un num�ro de r�servation
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
    
    /** m�thode AnnulerReservation annule une r�servation
     * @param numResa : un num�ro de r�servation
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
