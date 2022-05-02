/** @author Kamil MAZAN **/
import java.util.Date;
import java.util.Random;

public class Location {
	  private Integer ID_client ;
	    private Integer numLoc ;
	    private int nbKmDebut ;
	    private Date dateDebut ;
	    private Date dateFin ;
	    

	    /** Constructeur
	     * @param dateDebut : Date du debut de la location
	     * @param dateFin : une date de fin de location
	     */
	    
	    public Location(Date dateDebut, Date dateFin){
	        this.numLoc = new Random().nextInt(10)+1 ;
	        this.dateDebut = dateDebut ;
	        this.dateFin = dateFin;
	    }


		public Integer getNumLoc() {
			return numLoc;
		}


		public void setNumLoc(Integer numLoc) {
			this.numLoc = numLoc;
		}


		public Date getDateFin() {
			return dateFin;
		}


		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}


		public int getNbKmDebut() {
			return nbKmDebut;
		}


		public void setNbKmDebut(int nbKmDebut) {
			this.nbKmDebut = nbKmDebut;
		}
	    
	    
	    
	    
	    
	    
	    
}
