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
