import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DAOCatalogueVehicule {
	public final int NBRJOURSAUVEGARDER = 256;
	public final String NOMFICHIER = "DBVehicule.csv";
	private final String SEPARATOR = ",";
	private final String DATEFORMAT = "EEE MMM dd HH:mm:ss 'EDT' yyyy";

	/**
	 * INFO SUR MANIÈRE SAUVEGARDE DISPONIBILITÉ
	 * 
	 * À La Fin des info de chaque véhicule 256 charactères sont utilisé afin de
	 * laisser savoir leur disponibilité
	 * 
	 * 0 : Non - disponible 1 : Disponible 2 : Reserver 3 : En réparation
	 * 
	 */
	public DAOCatalogueVehicule() {

	}

	/**
	 * Methode ayant pour but de sauvegarder dans la base de donner les informations
	 * sur un véhicule
	 * 
	 * @author Nicolas Dionne
	 * 
	 * @param vehicule : vehicule que l'on souhait enregistrer
	 */
	public void save(Vehicule vehicule) {
		csvWrite(vehicule);
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 *         Methode permettant de getter un vehicule dans la base de donner csv
	 *         par son identifiant. Cette methode peut prendre un certain nombre de
	 *         temps avec un fichier volumineux comme elle traverse ligne par ligne
	 *         de façon linéaire donc un temps possible de n, ou n est le nombre
	 *         d'élement dans le fichier.
	 * 
	 * @param id : String IDentifiant unique du véhicule
	 * @return Vehicule le vehicule trouver correspondant au critères, null si aucun
	 *         de trouver
	 */
	public Vehicule get(String id) {
		String IDLigne;
		String currentLigne; // Ligne en cours de lecture
		try {
			Scanner scanner = new Scanner(new File(NOMFICHIER));
			// On skip la première ligne qui corespond au générateur d'identifiant
			scanner.nextLine();
			// On travers les ligne une par une
			while (scanner.hasNextLine()) {
				// On get la ligne puis on retire la partie de gauche (après la ',')
				currentLigne = scanner.nextLine();
				IDLigne = currentLigne.split(",")[0];
				// Si on trouve
				if (IDLigne.equals(id)) {
					scanner.close();
					// Transforme notre string sous le format d'un vehicule et le retourne
					return formatCSVToVehicule(currentLigne);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Vehicule t) {
		// TODO Auto-generated method stub
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permetant de mettre a jour les dispo du vehicule
	 * ELLE DOIT CHANGER LES DISPO POUR UNE MEME LONGUEUR DE DISPO SI LA BD EST COROMPUE NE PAS UTILISER AVANT D'AVOIR RÉPARER
	 * 
	 * @param vehicule vehicule que l'on souhaite metre a jour les info dans la mémoire persistente
	 */
	public void miseAJourDispoVehicule(Vehicule vehicule) {
		String derniereLigne;
		long dernierPointeurByte;
		try {
			// https://docs.oracle.com/javase/6/docs/api/java/io/RandomAccessFile.html
			RandomAccessFile fichier = new RandomAccessFile(NOMFICHIER, "rw");
			do {
				// On garde une trace du dernier pointeur
				dernierPointeurByte = fichier.getFilePointer();

				// On lit la ligne
				derniereLigne = fichier.readLine();

				// On regarde si la ligne correspond au vehicule que l'on shouaite modifier les
				// dispo
				// On regarde deplus si la ligne est null
				if (derniereLigne == null || !formatCSVToVehicule(derniereLigne).getID().equals(vehicule.getID()))
					continue;
				// Si nous avons trouver la ligne
				// Il reste à ce positionner au bon byte
				// On calcul les byte utiliser pour stocker les infos du véhicule - byte pour
				// stocker les dispos
				fichier.seek(dernierPointeurByte + derniereLigne.length() - NBRJOURSAUVEGARDER);
				fichier.writeBytes(vehicule.getDispo());
				break;
			} while (derniereLigne != null);
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param Vehicule : vehicule que l'on souhait ecrire dans le fichier csv
	 */
	private void csvWrite(Vehicule vehicule) {
		try (FileWriter fichier = new FileWriter(NOMFICHIER, true)) {
			fichier.append(formatCSVVehicule(vehicule));
			fichier.flush();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param Vehicule : vehicule que l'on veut retourner sous forme formater
	 * @return La vehicule sous forme formater en String pour la BD
	 */
	private String formatCSVVehicule(Vehicule vehicule) {
		String vehiculeFormater = "";
		vehiculeFormater += vehicule.getID() + SEPARATOR; // 0
		vehiculeFormater += vehicule.getDate() + SEPARATOR; // 1
		vehiculeFormater += vehicule.getKilometrage() + SEPARATOR; // 2
		vehiculeFormater += vehicule.getCategorie() + SEPARATOR; // 3
		vehiculeFormater += vehicule.getDispo() + "\n"; // 4
		return vehiculeFormater;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param stringVehicule : String forme formater en String pour la BD Vehicule
	 *                       d'un vehicule
	 * @return Vehicule : vehicule reformter dans sa forme location
	 */
	private Vehicule formatCSVToVehicule(String stringVehicule) {
		SimpleDateFormat formateurDate = new SimpleDateFormat(DATEFORMAT);
		Vehicule vehicule = new Vehicule();
		String[] infoVehicule = stringVehicule.split(SEPARATOR);
		vehicule.setID(infoVehicule[0]);
		vehicule.setDate(new Date(infoVehicule[1]));
		vehicule.setKilometrage(Integer.parseInt(infoVehicule[2]));
		vehicule.setCategorie(infoVehicule[3]);
		vehicule.setDispo(infoVehicule[4]);
		return vehicule;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 *         Méthode permettant de get tout les véhicule dispo selon une catégorie
	 *         et un intervalle de temps donné par dateDebut à dateFin
	 * 
	 * @param categorie : String Catégorie du véhicule
	 * @param dateDebut : Date date début de l'intervalle de temps de disponibilité
	 * @param dateFin   : Date date de fin de l'intervalle de temps de disponibilité
	 * @return
	 */
	public ArrayList<Vehicule> getVehiculeDispo(String categorie, Date dateDebut, Date dateFin) {
		String currentLigne; // Ligne en cours de lecture
		ArrayList<Vehicule> listVehicule = new ArrayList<Vehicule>();
		try {
			Scanner scanner = new Scanner(new File(NOMFICHIER));
			// On skip la première ligne qui corespond au générateur d'identifiant
			scanner.nextLine();
			// On travers les ligne une par une
			while (scanner.hasNextLine()) {
				// On get la ligne puis on retire la partie de gauche (après la ',')
				currentLigne = scanner.nextLine();
				// Si la catégorie du véhicule correspond
				if (categorie.equals(currentLigne.split(",")[3])) {
					
					// On vérifie que nos Date corresponde
					if (verificationDate(currentLigne.split(",")[4], dateDebut, dateFin)) {
						// Transforme notre string sous le format d'un vehicule
						// et on l'ajoute à la liste de véhicule répondants aux critères
						listVehicule.add(formatCSVToVehicule(currentLigne));
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return listVehicule;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param dateFichier : String date du fichier sous format string suivant les
	 *                    critère de sauvegarde plus haut
	 * @param dateDebut   : Date date de début que le véhicule doit être disponible
	 * @param dateFin     : Date date de fin jusqu'à ou le véhicule doit être dispo
	 * @return
	 */
	public boolean verificationDate(String dateFichier, Date dateDebut, Date dateFin) {
		boolean toutEstGood = true;

		// On prend la date de début - la date d'ajourd'hui afin de calculer combien de
		// charactère nous devons sauter
		int coordonneDebut = converterMilisecondsToDay(dateDebut.getTime() - new Date().getTime());
		
		// On calcule l'intervalle de jour nécessaire de disponibilité
		int coordonneFin = coordonneDebut + converterMilisecondsToDay(dateFin.getTime() - dateDebut.getTime());
		// On itère vérifier sur les date du véhicule
		for (int i = coordonneDebut; i < coordonneFin && i < dateFichier.length(); i++) {
			
			// Si le véhicule est sois indisponible ou en réparation
			if (dateFichier.charAt(i) == '0' || dateFichier.charAt(i) == '3') {
				toutEstGood = false;
				// Pas besoin de continuer d'itéré
				break;
			}
		}
		return toutEstGood;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 *         Méthode permettant de convertir des milisecondes en jour
	 * 
	 * @param miliseconds : long un nombre de jour en milisecondes
	 * @return int : l'équivalent du nombre de miliseconds en jour
	 */
	private int converterMilisecondsToDay(long miliseconds) {
		miliseconds /= 24; // Pour chaque heure dans une journée
		miliseconds /= 60; // Pour chaque minute dans un heure
		miliseconds /= 60;// Pour chaque seconde dans une minute
		miliseconds /= 1000;// Puisque miliseconds
		return (int) miliseconds;
	}

}
