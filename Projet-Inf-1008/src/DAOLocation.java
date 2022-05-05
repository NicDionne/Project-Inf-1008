import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DAOLocation  {
	// Nom du fichier utiliser
	private static final String NOMFICHIER = "DBLocation.csv";
	private static final String SEPARATOR = ",";
	private static final String DATEFORMAT = "MM/dd/yyyy";

	public DAOLocation() {

	}

	/**
	 * Methode ayant pour but de sauvegarder dans la base de donner les informations
	 * sur une location
	 * 
	 * @author Nicolas Dionne
	 * 
	 * @return int: l'ID location generer par la BD
	 * @param location : location que l'on souhait enregistrer
	 */
	public int save(Location location) {
		int IDLocation;
		IDLocation = nextID();
		location.setNumLoc(IDLocation);
		csvWrite(location);
		incrementNextID(IDLocation);
		return IDLocation;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 *         Methode permettant de getter un client dans la base de donner csv par
	 *         son identifiant. Cette methode peut prendre un certain nombre de
	 *         temps avec un fichier volumineux comme elle traverse ligne par ligne
	 *         de façon linéaire donc un temps possible de n, ou n est le nombre
	 *         d'élement dans le fichier.
	 * 
	 * @param id : int IDentifiant a 9 chiffre unique de l'utilisateur
	 * @return Client le client trouver correspondant au critères, null si aucun de
	 *         trouver
	 */
	public Location get(int id) {
		int IDLigne;
		String currentLigne; // Ligne en cours de lecture
		try {
			Scanner scanner = new Scanner(new File(NOMFICHIER));
			// On skip la première ligne qui corespond au générateur d'identifiant
			scanner.nextLine();
			// On travers les ligne une par une
			while (scanner.hasNextLine()) {
				// On get la ligne puis on retire la partie de gauche (après la ',')
				currentLigne = scanner.nextLine();
				IDLigne = Integer.parseInt(currentLigne.split(",")[0]);
				// Si on trouve
				if (IDLigne == id) {
					scanner.close();
					// Transforme notre string sous le format d'un client et le retourne
					return formatCSVToLocation(currentLigne);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}



	public void delete(Location location) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * @param Location : location que l'on souhait ecrire dans le fichier csv
	 */
	private void csvWrite(Location location) {
		try (FileWriter fichier = new FileWriter(NOMFICHIER, true)) {
			fichier.append(formatCSVLocation(location));
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
	 * @param Location : location que l'on veut retourner sous forme formater
	 * @return La location sous forme formater en String pour la BD
	 */
	private String formatCSVLocation(Location location) {
		String locationFormater = "";
		locationFormater += location.getNumLoc() + SEPARATOR;
		locationFormater += location.getDateDebut() + SEPARATOR;
		locationFormater += location.getDateFin() + SEPARATOR;
		locationFormater += location.getVehiculeID() + SEPARATOR;
		locationFormater += location.getClientID() + "\n";
		return locationFormater;
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * @param stringLocation : String forme formater en String pour la BD Location d'une location
	 * @return Location : location reformter dans sa forme location
	 */
	private Location formatCSVToLocation(String stringLocation) {
		SimpleDateFormat formateurDate = new SimpleDateFormat(DATEFORMAT);
		Location location = new Location();
		String[] infoClient = stringLocation.split(SEPARATOR);
		location.setNumLoc(Integer.parseInt(infoClient[0]));
		try {
			location.setDateDebut(formateurDate.parse(infoClient[1]));
			location.setDateFin(formateurDate.parse(infoClient[2]));
		} catch (ParseException e) {
			// LA BD est corrompue
			e.printStackTrace();
		}
		location.setVehicule(infoClient[3]);
		location.setClient(GestionnaireClient.getClient(Integer.parseInt(infoClient[4])));
		return location;
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 *         Methode permetant de generer un ID unique a 9 chiffre
	 * @return L'identifiant unique nouvellement creer, -1 si un probleme est
	 *         survenu
	 */
	private int nextID() {
		int dernierID;
		try {
			// On Lit la derniere ID Utiliser
			File fichier = new File(NOMFICHIER);
			Scanner reader = new Scanner(fichier);
			dernierID = reader.nextInt();
			reader.close();
			return (dernierID + 1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * @author Nicolas Dionne Methode permetant d'incrementer notre generateur
	 *         d'identifiant
	 * @param dernierID : int dernier ID sortit generer par le systeme, si
	 *                  incertint, appeler la methode nextID()
	 */
	private void incrementNextID(int dernierID) {
		String code;
		try {
			// https://docs.oracle.com/javase/6/docs/api/java/io/RandomAccessFile.html
			RandomAccessFile fichier = new RandomAccessFile(NOMFICHIER, "rw");
			fichier.seek(0);
			code = Integer.toString(dernierID + 1);
			fichier.writeBytes(code);
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
