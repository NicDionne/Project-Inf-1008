import java.util.ArrayList;
/**
 * 
 * @author Nicolas Dionne
 *
 *Interface fesant le lien entre nos classe du domaine et nos base de donnees
 * par l'entremise de fa�ade. Nous utilisons des objet d'acc�s de donn�es. 
 * 
 * Chaque Objet d'acces de donnees permets d'effectuer les operations CRUD de base
 * (cr�er, lire, mettre � jour, supprimer) 
 * 
 */
public interface DAO<T> {
	//Affin de sauvegarder
	void  save(T t);
	//Afin d'obtenir une liste des objet avec l'identifiant
	ArrayList<T> get(int id); 
	//Afin de detruire un objet
	void delete(T t); 
}
	
	
