/** @author Quentin Tambone **/
import java.util.Date;
import java.util.Random;
import java.text.DateFormat;

/** repr�sente une r�servation **/
public class Reservation extends GestionnaireReservation {
    private Integer ID_client ;
    private Integer numResa ;
    private String categorie ;
    private Date dateDebut ;
    private Date dateFin ;

    /** Constructeur
     * @param cate : une cat�gorie de v�hicule
     * @param debut : une de date de d�but
     * @param fin : une date de fin
     */
    public Reservation(String cate, Date debut, Date fin){
        this.numResa = new Random().nextInt(10)+1 ;
        this.categorie =  cate ;
        this.dateDebut = debut ;
        this.dateFin = fin ;
    }

    /** m�thode creerReservation qui cr�er une instance reservation
     * @param categorie : une cat�gorie de v�hicule
     * @param dateDebut : une de date de d�but
     * @param dateFin : une date de fin
     * @return
     */
    public static Reservation creerReservation(String categorie, Date dateDebut, Date dateFin){
        return new Reservation(categorie, dateDebut, dateFin) ;
    }


    /** m�thode getNumResa qui r�cup�re le num�ro de r�servation
     * @return le num�ro de r�servation
     */
    public Integer getNumResa(){return this.numResa ;}

    /** m�thode setID_client qui set l'identifiant client
     * @param ID_Client : un identifiant client
     */
    public void setID_client(Integer ID_Client){
        this.ID_client = ID_Client ;
    }

    /** m�thode setAttribut qui set la cat�gorie de v�hicule, la date de d�but, et la date de fin d'une r�servation
     * @param categorie : une cat�gorie de v�hicule
     * @param dateDebut : une date de d�but de r�servation
     * @param dateFin : une date de fin de r�servation
     */
    public void setAttribut(String categorie, Date dateDebut, Date dateFin){
        if(categorie != null){ this.categorie = categorie ;}
        if(dateDebut != null){ this.dateDebut = dateDebut ;}
        if(dateFin != null){ this.dateFin = dateFin ;}
    }

    /** m�thode enregistrerReservation enregistre une r�servation dans le gestionnaire
     * @param g : un gestionnaire de r�servation
     */
    public void enregistrerReservation(GestionnaireReservation g){
        g.enregistrer(this) ;
    }

    /** m�thode toString qui affiche une r�servation
     * @return l'affichage d'une reservation
     */
    public String toString(){
        return "Num�ro de R�servation : " + numResa + "\n" + "Cat�gorie du v�hicule : " + categorie + "\n"
                + "Date d�but : " + DateFormat.getInstance().format(dateDebut) + "\n" + "Date fin : " + DateFormat.getInstance().format(dateFin);
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
