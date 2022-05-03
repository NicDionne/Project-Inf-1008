import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;  

public class DAOClient  {

	//Nom du fichier utiliser
	private static final String NOMFICHIER = "DBClient.csv";
	private static final String SEPARATOR = ",";
	public DAOClient()
	{
		
	}
	/**
	 * Methode ayant pour but de sauvegarder dans la base de donner les informations sur un client
	 * 
	 * @author Nicolas Dionne
	 * 
	 * @param client : client que l'on souhait enregistrer
	 */
	public  void save(Client client)
	{
		csvWrite(client);
	}
	
	
	public  ArrayList<Client> get(int id) {
		return null;
	} 
	
	public  void delete(Client client)
	{
		
	}
	
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * @param client : client que l'on souhait ecrire dans le fichier csv
	 */
	private void csvWrite(Client client)
	{
		try (FileWriter fichier = new FileWriter(NOMFICHIER,true)){
			fichier.append(formatCSVClient(client));
			fichier.flush();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**@author Nicolas Dionne
	 * 
	 * @param client : Client que l'on veut retourner sous forme formater
	 * @return Le client sous forme formater en String pour la BD
	 */
	private String formatCSVClient(Client client)
	{
		String clientFormater = "";
		clientFormater += client.getIDClient() + SEPARATOR;
		clientFormater += client.getNom() + SEPARATOR;
		clientFormater += client.getPrenom()+ SEPARATOR;
		clientFormater += client.getAdresse()+ SEPARATOR;
		clientFormater += client.getNoTelDom()+ SEPARATOR;
		clientFormater += client.getNoTelMob()+ SEPARATOR;
		clientFormater += client.getNoPermis()+ SEPARATOR;
		clientFormater += client.getNoCarteBancaire() +"\n";
		return clientFormater;
	}
	
	/**@author Nicolas Dionne
	 * 
	 * @param client : String forme formater en String pour la BD Client du Client
	 * @return Client : Le client reformter dans sa forme client
	 */
	private Client formatCSVToClient(String stringClient)
	{
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
	
}
