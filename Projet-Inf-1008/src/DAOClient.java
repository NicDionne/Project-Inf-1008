import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class DAOClient {

	// Nom du fichier utiliser
	private static final String NOMFICHIER = "DBClient.csv";
	private static final String SEPARATOR = ",";

	public DAOClient() {

	}

	/**
	 * Methode ayant pour but de sauvegarder dans la base de donner les informations
	 * sur un client
	 * 
	 * @author Nicolas Dionne
	 * 
	 * @return int: l'ID client generer par la BD
	 * @param client : client que l'on souhait enregistrer
	 */
	public int save(Client client) {
		int IDClient;
		IDClient = nextID();
		client.setIDClient(IDClient);
		csvWrite(client);
		incrementNextID(IDClient);
		return IDClient;
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
	public Client get(int id) {
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
					return formatCSVToClient(currentLigne);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Client client) {

	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param client : client que l'on souhait ecrire dans le fichier csv
	 */
	private void csvWrite(Client client) {
		try (FileWriter fichier = new FileWriter(NOMFICHIER, true)) {
			fichier.append(formatCSVClient(client));
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
	 * @param client : Client que l'on veut retourner sous forme formater
	 * @return Le client sous forme formater en String pour la BD
	 */
	private String formatCSVClient(Client client) {
		String clientFormater = "";
		clientFormater += client.getIDClient() + SEPARATOR;
		clientFormater += client.getNom() + SEPARATOR;
		clientFormater += client.getPrenom() + SEPARATOR;
		clientFormater += client.getAdresse() + SEPARATOR;
		clientFormater += client.getNoTelDom() + SEPARATOR;
		clientFormater += client.getNoTelMob() + SEPARATOR;
		clientFormater += client.getNoPermis() + SEPARATOR;
		clientFormater += client.getNoCarteBancaire() + "\n";
		return clientFormater;
	}

	/**
	 * @author Nicolas Dionne
	 * 
	 * @param client : String forme formater en String pour la BD Client du Client
	 * @return Client : Le client reformter dans sa forme client
	 */
	private Client formatCSVToClient(String stringClient) {
		Client client = new Client();
		String[] infoClient = stringClient.split(SEPARATOR);
		client.setIDClient(Integer.parseInt(infoClient[0]));
		client.setNom(infoClient[1]);
		client.setPrenom(infoClient[2]);
		client.setAdresse(infoClient[3]);
		client.setNoTelDom(infoClient[4]);
		client.setNoTelMob(infoClient[5]);
		client.setNoPermis(infoClient[6]);
		client.setNoCarteBancaire(infoClient[7]);
		return client;
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
