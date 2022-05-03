/** @author Quentin Tambone **/
import java.util.Date;
import java.util.Random;
import java.text.DateFormat;

/** représente une réservation **/
public class Reservation extends GestionnaireReservation {
    private Integer ID_client ;
    private Integer numResa ;
    private String categorie ;
    private Date dateDebut ;
    private Date dateFin ;

    /** Constructeur
     * @param cate : une catégorie de véhicule
     * @param debut : une de date de début
     * @param fin : une date de fin
     */
    public Reservation(String cate, Date debut, Date fin){
        this.numResa = new Random().nextInt(10)+1 ;
        this.categorie =  cate ;
        this.dateDebut = debut ;
        this.dateFin = fin ;
    }

    /** méthode creerReservation qui créer une instance reservation
     * @param categorie : une catégorie de véhicule
     * @param dateDebut : une de date de début
     * @param dateFin : une date de fin
     * @return
     */
    public static Reservation creerReservation(String categorie, Date dateDebut, Date dateFin){
        return new Reservation(categorie, dateDebut, dateFin) ;
    }


    /** méthode getNumResa qui récupère le numéro de réservation
     * @return le numéro de réservation
     */
    public Integer getNumResa(){return this.numResa ;}

    /** méthode setID_client qui set l'identifiant client
     * @param ID_Client : un identifiant client
     */
    public void setID_client(Integer ID_Client){
        this.ID_client = ID_Client ;
    }

    /** méthode setAttribut qui set la catégorie de véhicule, la date de début, et la date de fin d'une réservation
     * @param categorie : une catégorie de véhicule
     * @param dateDebut : une date de début de réservation
     * @param dateFin : une date de fin de réservation
     */
    public void setAttribut(String categorie, Date dateDebut, Date dateFin){
        if(categorie != null){ this.categorie = categorie ;}
        if(dateDebut != null){ this.dateDebut = dateDebut ;}
        if(dateFin != null){ this.dateFin = dateFin ;}
    }

    /** méthode enregistrerReservation enregistre une réservation dans le gestionnaire
     * @param g : un gestionnaire de réservation
     */
    public void enregistrerReservation(GestionnaireReservation g){
        g.enregistrer(this) ;
    }

    /** méthode toString qui affiche une réservation
     * @return l'affichage d'une reservation
     */
    public String toString(){
        return "Numéro de Réservation : " + numResa + "\n" + "Catégorie du véhicule : " + categorie + "\n"
                + "Date début : " + DateFormat.getInstance().format(dateDebut) + "\n" + "Date fin : " + DateFormat.getInstance().format(dateFin);
    }
    
   
    //Accesseur 
    /**@author Nicolas Dionne
     * 
     * getter pour la categorie vehicule 
     * @return String : Categorie du vehicule en question
     */
    public String getCategorie()
    {
    	return categorie;
    }
    /**@author Nicolas Dionne
     * 
     * getter pour la date de debut de reservation
     * @return Date : date de debut prevue de reservation
     */
    public Date getDateDebut()
    {
    	return dateDebut;
    }
    /**@author Nicolas Dionne
     * 
     * getter pour la date de fin de reservation
     * @return Date : date de fin prevue de reservation
     */
    public Date getDateFin()
    {
    	return dateFin;
    }
    
    /**@author Nicolas Dionne
     * 
     * @return int: identifiant du client correspondant a la reservation
     */
    public int getID_client(){
        return ID_client ;
    }
}
