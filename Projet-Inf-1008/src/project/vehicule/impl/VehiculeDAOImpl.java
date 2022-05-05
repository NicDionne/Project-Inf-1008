/**
 * @author Ramy
 */

package project.vehicule.impl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import project.vehicule.CsvFile;
import project.vehicule.VehiculeDAO;


public class VehiculeDAOImpl implements VehiculeDAO {

	
    private CsvFile csvFile;

    private  List<String[]> data;
    
    private VehiculeDAOImpl() {
        super();
    }

    public VehiculeDAOImpl(File file) {
        this();
        this.csvFile = new CsvFileImpl(file);
        data = csvFile.getData();
    }
	
	@Override
	public List<VehiculeImpl> findAllVehicules() {
		List<VehiculeImpl> vehicules = new ArrayList<VehiculeImpl>();
	    for(String[] oneData : data) {
	    	VehiculeImpl vehicule = tabToVehicule(oneData);
	    	vehicules.add(vehicule);
	    }

	    return vehicules;
	}

	private VehiculeImpl tabToVehicule(String[] tab) {
	    VehiculeImpl vehicule = new VehiculeImpl();
		
	    vehicule.setId(Integer.parseInt(tab[0]));
	    vehicule.setCategorie(tab[1]);
	    vehicule.setMarque(tab[2]);
	    vehicule.setAnnee(Integer.parseInt(tab[3]));
	    vehicule.setModel(tab[4]);
	    vehicule.setKilometrage(Integer.parseInt(tab[5]));
	    vehicule.setPlaqueImmatriculation(tab[6]);
	    vehicule.setPoids(Float.parseFloat(tab[7]));
	    vehicule.setCouleur(tab[8]);
	    vehicule.setCapacite(Integer.parseInt(tab[9]));
	    vehicule.setTemps(Integer.parseInt(tab[10]));
	    vehicule.setCommentaire(tab[11]);
	    
	    return vehicule;
	}

	@Override
	public int getNbrVehicule() {
		return data.size();
	}

	@Override
	public boolean findVehiculeById(int id) {
	    for(String[] oneData : data) {
	    	if (id == Integer.parseInt(oneData[0])) {
	    		return true;
	    	}
	    }
		return false;
	}

	@Override
	public VehiculeImpl getVehiculeById(int id) {
		for(String[] oneData : data) {
			if (id == Integer.parseInt(oneData[0])) {
				VehiculeImpl vehicule = tabToVehicule(oneData);
				return vehicule;
			}
	    }
		return null;
	}

	@Override
	public boolean addVehicule(VehiculeImpl vehicule) {
		ArrayList<String> line =  new ArrayList<String>();
		if (! findVehiculeById(vehicule.getId()) && vehicule != null) {
			line.add(Integer.toString(vehicule.getId()));
			line.add(vehicule.getCategorie());
			line.add(vehicule.getMarque());
			line.add(Integer.toString(vehicule.getAnnee()));
			line.add(vehicule.getModel());
			line.add(Integer.toString(vehicule.getKilometrage()));
			line.add(vehicule.getPlaqueImmatriculation());
			line.add(Float.toString(vehicule.getPoids()));
			line.add(vehicule.getCouleur());
			line.add(Integer.toString(vehicule.getCapacite()));
			line.add(Integer.toString(vehicule.getTemps()));
			line.add(vehicule.getCommentaire());
			System.out.println("[AddVehicule] " + vehicule.toString());
			csvFile.addElementEndOfFile(line);
		}
		
		return false;
	}

	@Override
	public boolean deleteVehicule(VehiculeImpl vehicule) {
		System.out.println("[RemoveVehicule] " + vehicule.toString());
		return (csvFile.deleteLineById(vehicule.getId()));
	}
	
	@Override
	public boolean deleteVehicule(int id) {
		return (csvFile.deleteLineById(id));
	}
	

	@Override
	public int getLastIdVehicule() {
		int id = 0;
		for(String[] oneData : data) {
			if (id < Integer.parseInt(oneData[0])) {
				id = Integer.parseInt(oneData[0]);
			}
	    }
		return id;
	}

	@Override
	public void AfficherAllVehicules() {
		
		System.out.println("\nListe des vehicules\n");
		int index = 1;
		for(String[] oneData : data) {
	    	VehiculeImpl vehicule = tabToVehicule(oneData);
	    	System.out.println(index + "- " + vehicule.toString());
	    	index++;
	    }
		
	}

}
