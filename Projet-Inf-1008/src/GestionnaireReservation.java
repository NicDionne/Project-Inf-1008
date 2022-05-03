/** @author Quentin Tambone **/
import java.util.ArrayList;

/** repr�sente une r�servation **/
public class GestionnaireReservation {
    ArrayList<Reservation> listeReservation ;

    /** Constructeur **/
    public GestionnaireReservation(){
        listeReservation = new ArrayList<>() ;
    }

    /** m�thode enregistrer qui enregistre une r�servation
     * @param reservation : une reservation
     */
    public void enregistrer(Reservation reservation){
        this.listeReservation.add(reservation) ;
    }

    /** m�thode getReservation get une r�servation
     * @param numResa : un num�ro de r�servation
     */
    public Reservation getReservation(Integer numResa){
        for(Reservation r : listeReservation){
            if(r.getNumResa().equals(numResa)){
                return r ;
            }
        }
        return null ;
    }
    
    /** m�thode AnnulerReservation annule une r�servation
     * @param numResa : un num�ro de r�servation
     */
    
    public void AnnulerReservation(int numResa) {
    	  for(Reservation r : listeReservation){
              if(r.getNumResa().equals(numResa)){
            	//RemboursementReservation(r); // Cas 10 = Remboursement de la reservation
            	  r= null;
            	  System.out.println("Annulation de reservation reussi");
              }
              else System.out.println("Reservation non trouv�");
          }
    }
    
    
    
}
