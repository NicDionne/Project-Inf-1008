/**
 * @author Ramy
 */

package project.vehicule;

public interface Vehicule {
	
	public int getId() ;

	public void setId(int id);

	public String getCategorie() ;

	public void setCategorie(String categorie) ;

	public String getMarque() ;

	public void setMarque(String marque) ;

	public int getAnnee() ;

	public void setAnnee(int annee) ;

	public String getModel() ;

	public void setModel(String model) ;

	public int getKilometrage() ;

	public void setKilometrage(int kilometrage) ;

	public String getPlaqueImmatriculation() ;

	public void setPlaqueImmatriculation(String plaqueImmatriculation) ;
	
	public String toString();
	
}
