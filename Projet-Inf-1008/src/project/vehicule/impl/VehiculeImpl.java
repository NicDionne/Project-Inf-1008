/**
 * @author Ramy
 */

package project.vehicule.impl;

import project.vehicule.Vehicule;

public class VehiculeImpl implements Vehicule {
	
	public static int nbrVehicule = 0;
	
	/* Obligatoire */
	private int id;
	private String categorie;
	private String marque;
	private int annee;
	private String model;
	private int kilometrage;
	private String plaqueImmatriculation;
	
	/* Optionnel */
	private float poids;
	private String couleur;
	private int capacite;
	private int temps;
	private String commentaire;
	
	public VehiculeImpl() {
	}
	
	/**
	 * @param categorie : Categorie du véhicule
	 * @param marque : Marque du vehicule
	 * @param annee : Date de l'annee de construction
	 * @param model : Model du vehicule
	 * @param kilometrage : kilometrage du vehicule
	 * @param plaqueImmatriculation : plaqueImmatriculation du vehicule
	 */
	public VehiculeImpl(String categorie, String marque, int annee, String model, int kilometrage, String plaqueImmatriculation) {
		this.categorie = categorie;
		this.marque = marque;
		this.annee = annee;
		this.model = model;
		this.kilometrage = kilometrage;
		this.plaqueImmatriculation = plaqueImmatriculation;
		this.poids = 0;
		this.couleur = "";
		this.capacite = 0;
		this.temps = 0;
		this.commentaire = "";
		this.id = nbrVehicule + 1;
		nbrVehicule++;
	}
	
	/**
	 * @param categorie : Categorie du véhicule
	 * @param marque : Marque du vehicule
	 * @param annee : Date de l'annee de construction
	 * @param model : Model du vehicule
	 * @param kilometrage : kilometrage du vehicule
	 * @param plaqueImmatriculation : plaqueImmatriculation du vehicule
	 * @param poids : Poids du vehicule
	 * @param couleur : Couleur du vehicule
	 * @param capacite : Capacite du vehicule
	 * @param Temps : Vitesse du vehicule de 0 a 100km/h
	 * @param commentaire :Commentaire sur le vehicule
	 */
	public VehiculeImpl(String categorie, String marque, int annee, String model, int kilometrage, String plaqueImmatriculation, float poids, String couleur, int capacite, int temps, String commentaire) {
		this(categorie, marque, annee, model, kilometrage, plaqueImmatriculation);
		this.poids = poids;
		this.couleur = couleur;
		this.capacite = capacite;
		this.temps = temps;
		this.commentaire = commentaire;
	}
	
	
	
	public static int getNbrVehicule() {
		return nbrVehicule;
	}

	public static void setNbrVehicule(int nbrVehicule) {
		VehiculeImpl.nbrVehicule = nbrVehicule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getPlaqueImmatriculation() {
		return plaqueImmatriculation;
	}

	public void setPlaqueImmatriculation(String plaqueImmatriculation) {
		this.plaqueImmatriculation = plaqueImmatriculation;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public String toString() {
		return (this.id + "," + this.categorie + "," + this.marque + "," + this.annee + "," + this.model + "," + this.kilometrage 
				+ "," + this.plaqueImmatriculation + "," + this.poids + "," + this.couleur + "," + this.capacite + "," + this.temps 
				+ "," + this.commentaire);
	}

}
