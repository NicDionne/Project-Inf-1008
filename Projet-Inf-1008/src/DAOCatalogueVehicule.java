import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DAOCatalogueVehicule  {
	public final int NBRJOURSAUVEGARDER = 256;
	public final String NOMFICHIER = "DBVehicule";
	private static final String SEPARATOR = ",";
	private static final String DATEFORMAT = "MM/dd/yyyy";
	/**INFO SUR MANIÈRE SAUVEGARDE DISPONIBILITÉ
	 * 
	 * À La Fin des info de chaque véhicule 256 charactères sont 
	 * utilisé afin de laisser savoir leur disponibilité
	 * 
	 * 0 : Non - disponible
	 * 1 : Disponible
	 * 2 : Reserver
	 * 3 : En réparation
	 * 
	 */
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
	 *         Methode permettant de getter un vehicule dans la base de donner csv par
	 *         son identifiant. Cette methode peut prendre un certain nombre de
	 *         temps avec un fichier volumineux comme elle traverse ligne par ligne
	 *         de façon linéaire donc un temps possible de n, ou n est le nombre
	 *         d'élement dans le fichier.
	 * 
	 * @param id : String IDentifiant unique du véhicule
	 * @return Vehicule le vehicule trouver correspondant au critères, null si aucun de
	 *         trouver
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
				if (IDLigne.equals( id)) {
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
	
	
	public void miseAJourVehicule(Vehicule t) {
		// TODO Auto-generated method stub
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
		vehiculeFormater += vehicule.getID() + SEPARATOR;
		vehiculeFormater += vehicule.getDate() + SEPARATOR;
		vehiculeFormater += vehicule.getKilometrage() + SEPARATOR;
		vehiculeFormater += vehicule.getCategorie() +SEPARATOR;
		vehiculeFormater += vehicule.getDispo() +		"\n";
		return vehiculeFormater;
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * @param stringVehicule : String forme formater en String pour la BD Vehicule d'un vehicule
	 * @return Vehicule : vehicule reformter dans sa forme location
	 */
	private Vehicule formatCSVToVehicule(String stringVehicule) {
		SimpleDateFormat formateurDate = new SimpleDateFormat(DATEFORMAT);
		Vehicule vehicule = new Vehicule();
		String[] infoVehicule = stringVehicule.split(SEPARATOR);
		vehicule.setID(infoVehicule[0]);
		try {
			vehicule.setDate(formateurDate.parse(infoVehicule[1]));
		} catch (ParseException e) {
			// LA BD est corrompue
			e.printStackTrace();
		}
		vehicule.setKilometrage(Integer.parseInt(infoVehicule[2]));
		vehicule.setCategorie(infoVehicule[3]);
		vehicule.setDispo(infoVehicule[4]);
		return vehicule;
	}
	
	public ArrayList<Vehicule> getVehiculeDispo(String categorie, Date dateDebut, Date dateFin) {
		
		return null;
	}	
	
}
