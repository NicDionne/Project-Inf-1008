/**
 * @author Ramy
 */

package project.vehicule;

import java.util.List;

import project.vehicule.impl.VehiculeImpl;

public interface VehiculeDAO {
	List<VehiculeImpl> findAllVehicules();
	int getNbrVehicule();
	int getLastIdVehicule();
	boolean findVehiculeById(int id);
	VehiculeImpl getVehiculeById(int id);
	boolean addVehicule(VehiculeImpl vehicule);
	boolean deleteVehicule(VehiculeImpl vehicule);
	boolean deleteVehicule(int id);
	void AfficherAllVehicules();
}
