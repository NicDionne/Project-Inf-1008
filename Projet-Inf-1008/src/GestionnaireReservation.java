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

    /** méthode getReservation get une réservation
     * @param numResa : un numéro de réservation
     */
    public Reservation getReservation(Integer numResa){
        for(Reservation r : listeReservation){
            if(r.getNumResa().equals(numResa)){
                return r ;
            }
        }
        return null ;
    }
}
