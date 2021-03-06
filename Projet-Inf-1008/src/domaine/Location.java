package domaine;


import java.util.Date;
import java.util.Random;

public class Location {
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

	    /**@author Nicolas Dionne
		 * 
		 * Methode permettant de confirmer la location
		 */
		public void confirmationLocation() {
			//On retire Les dispo du v?hicule
			vehicule.retirerDispo(dateDebut, dateFin);
		}
	    
	    
	    //Accesseur
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
		 * Setter pour le client ? partir de son identifiant client
		 * @param Client : Client correspondant a la location
		 */
		public void setClient(Client client) {
			this.client = client ;
		}
		
	    /** @author Nicolas Dionne
		 * Getter pour le vehicule
	     * @return Vehicule correspondant au vehicule louer
	     */
		public Vehicule getVehicule()
		{
			return vehicule;
		}
		/** @author Nicolas Dionne
		 * Getter pour l'ID du vehicule
	     * @return String : ID vehicule correspondant au vehicule louer
	     */
		public String getVehiculeID()
		{
			return vehicule.getID();
		}
		/** @author Nicolas Dionne
		 * Getter pour l'ID du client
	     * @return int : ID client correspondant au client qui a louer
	     */
		public int getClientID()
		{
			return client.getIDClient();
		}
		/**@author Nicolas Dionne
		 * Setter pour le vehicule
		 * @param vehic : Vehicule correspondant au vehicule louer
		 */
		public void setVehicule(Vehicule vehic)
		{
			this.vehicule = vehic;
		}
		/**@author Nicolas Dionne
		 * Setter pour le vehicule ? partir de l'identifiant du v?hicule
		 * @param vehiculeID : String correspondant ? l'identifiant du vehicule louer
		 */
		public void setVehicule(String vehiculeID)
		{
			DAOCatalogueVehicule daoCatalogue = new DAOCatalogueVehicule();
			this.vehicule = daoCatalogue.get(vehiculeID);
		}
		
		/**@author Nicolas Dionne
		 * Getter pour avoir le contrat de location sous format String
		 * @return String : Le contrat sous forme string
		 */
		public String getStringContrat() {
			String contrat; 
			contrat = "Contrat de location pour : " + client.getNom() + ", " + client.getPrenom() + "\n";
			contrat += "Num?ro d'identification du client : " + client.getIDClient() + "\n";
			contrat += "Location pour le v?hicule : " + vehicule.getID()+ "\n";
			contrat += "\t Categorie : " + vehicule.getCategorie() + "\n"; 
			contrat += "Pour les date du " + this.getDateDebut() + " au " + this.getDateFin();
			return contrat;
		}
		


	    
	    
	    
	    
	    
}
