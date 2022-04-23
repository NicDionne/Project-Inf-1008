import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DAOClient implements DAO<Client> {

	//Nom du fichier utiliser
	private static final String NOMFICHIER = "DBClient.csv";
	
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
	
	
	/**Methode ayant pour but d'aller chercher dans la base de donner le(s) client(s) 
	 * ayant le numero d'identifiant indiquer en argument.
	 * @author Nicolas Dionne
	 * 
	 * @param id : int ; Identifiant unique du client
	 * @return ArrayList<Client> : Liste de tout les client possedent l'identifiant inscrit
	 */
	public  ArrayList<Client> get(int id) {
		ArrayList<Client> listClient = new ArrayList<Client>();
		
		
		return listClient;
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
		clientFormater += client.getIDClient() + ",";
		clientFormater += client.getNom() + ",";
		clientFormater += client.getPrenom()+ ",";
		clientFormater += client.getAdresse()+ ",";
		clientFormater += client.getNoTelDom()+ ",";
		clientFormater += client.getNoTelMob()+ ",";
		clientFormater += client.getNoPermis()+ ",";
		clientFormater += client.getNoCarteBancaire() +"\n";
		return clientFormater;
		
	}
}
