/**
 * 
 * @author Ramy
 *
 */

import java.io.File;
import project.vehicule.CsvFileHelper;
import project.vehicule.impl.VehiculeDAOImpl;
import project.vehicule.impl.VehiculeImpl;

public class GestionnaireVehicule {
	
	private static final String FILE_NAME = "src/test/db_vehicules.csv";

	public static void creationVehicule(String categorie, String marque, String annee, String model,
			String kilometrage, String plaqueImmatriculation, String poids, String couleur, String capacite, String temps, String commentaire)
	{
		File file = CsvFileHelper.getResource(FILE_NAME);
		VehiculeDAOImpl  vehiculeDao = new VehiculeDAOImpl(file);
		VehiculeImpl.nbrVehicule = vehiculeDao.getLastIdVehicule();
		VehiculeImpl nouveauVehicule = new VehiculeImpl(categorie, marque, Integer.parseInt(annee), model, Integer.parseInt(kilometrage), plaqueImmatriculation, Float.parseFloat(poids), couleur, Integer.parseInt(capacite), Integer.parseInt(temps), commentaire);
		vehiculeDao.addVehicule(nouveauVehicule);
	}
	
	
	public static void supressionVehicule(String id) {
		File file = CsvFileHelper.getResource(FILE_NAME);
		VehiculeDAOImpl  vehiculeDao = new VehiculeDAOImpl(file);
		vehiculeDao.deleteVehicule(Integer.parseInt(id));
	}
	
	

}
