
import java.util.Date;
import java.util.Random;

public class Location {
	  private Integer ID_client ;
	    private Integer numLoc ;
	    private int nbKmDebut ;
	    private Date dateDebut ;
	    private Date dateFin ;
	    private Client client;
	    private Vehicule vehicule;
	    
	    /**
	     * Constructeur
	     * @author Nicolas Dionne
	     */
	    public Location()
	    {
	    	
	    }
	    
	    /** @author Kamil MAZAN **/
	    /** Constructeur
	     * @param dateDebut : Date du debut de la location
	     * @param dateFin : une date de fin de location
	     */
	    
	    public Location(Date dateDebut, Date dateFin){
	        this.numLoc = new Random().nextInt(10)+1 ;
	        this.dateDebut = dateDebut ;
	        this.dateFin = dateFin;
	    }

	    /** @author Kamil MAZAN **/
		public Integer getNumLoc() {
			return numLoc;
		}

		 /** @author Kamil MAZAN **/
		public void setNumLoc(Integer numLoc) {
			this.numLoc = numLoc;
		}

		 /** @author Kamil MAZAN **/
		public Date getDateFin() {
			return dateFin;
		}

		 /** @author Kamil MAZAN **/
		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

		 /** @author Kamil MAZAN **/
		public int getNbKmDebut() {
			return nbKmDebut;
		}

		 /** @author Kamil MAZAN **/
		public void setNbKmDebut(int nbKmDebut) {
			this.nbKmDebut = nbKmDebut;
		}
	    
		/**
		 * @author Nicolas Dionne
		 * getter pour la date de debut
		 * @return Date : Retourne la date de debut de location
		 */
		public Date getDateDebut()
		{
			return dateDebut;
		}
		/**
		 * @author Nicolas Dionne
		 * setter pour la date de debut
		 * @param dateDebut : Date de debut de la location
		 */
		public void setDateDebut(Date dateDebut)
		{
			this.dateDebut = dateDebut;
		}
		/**@author Nicolas Dionne
		 * Setter pour le client
		 * @param id_client : int correspondant a l'identifiant client
		 */
		public void setClient(int id_client) {
			ID_client = id_client;
			client = GestionnaireClient.getClient(id_client);
		}
	    /** @author Nicolas Dionne
		 * Getter pour le vehicule
	     * @return Vehicule correspondant au vehicule louer
	     */
		public Vehicule getVehicule()
		{
			return vehicule;
		}
		/**@author Nicolas Dionne
		 * Setter pour le vehicule
		 * @param vehic : Vehicule correspondant au vehicule louer
		 */
		public void setVehicule(Vehicule vehic)
		{
			this.vehicule = vehic;
		}

		public String getStringContrat() {
			// TODO Auto-generated method stub
			return null;
		}

		public void confirmationLocation() {
			// TODO Auto-generated method stub
			vehicule.retirerDispo(dateDebut, dateFin);
		}

	    
	    
	    
	    
	    
}
