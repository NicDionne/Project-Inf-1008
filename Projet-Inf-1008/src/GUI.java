import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI {

	protected GUI upperMenu = null;
	protected JFrame frame = null;
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permetant d'afficher un message au client
	 */
	public void showMessage(String message, String titre)
	{
		JOptionPane.showMessageDialog(null,message, titre, JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permetant le retour au menu plus g�n�rale que celui pr�sent.
	 * Par exemple si nous somme dans le menu de location, nous irons au menu principale.
	 */
	public void toUpperMenu()
	{
		frame.setVisible(false);
		upperMenu.getJFrame().setVisible(true);
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permetant � tout moment lors du processus de cr�ation de la nouvelle page
	 * un retour au menu plus g�n�rale que celui pr�sent.
	 * Par exemple si nous somme dans le menu de location, nous irons au menu principale.
	 */
	public void cancelCreation()
	{
		upperMenu.getJFrame().setVisible(true);
	}
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permettant de saisir une entrer de la part de l'utilisateur, ce dernier bloque l'utilisateur
	 * tant qu'il n'aura pas repondu ou quitter
	 * 
	 * @param message : String correspondant au message que l'on veut envoyer
	 * @param titre : String du titre de la boite message
	 * @return : Int Entrer de la part de l'utilisateur, -1 si l'utilisateur annule
	 */
	public int inputBoxInt(String message, String titre)
	{
		String input;
		int entrer;
		while(true)
		{
			input = JOptionPane.showInputDialog(null,message,titre,JOptionPane.INFORMATION_MESSAGE);
			if(input == null)
			{
				return -1;
			}
			try
			{
			entrer = Integer.parseInt(input);
			return entrer;
			}
			catch(Exception e) {
				showMessage("Un mauvaise entrer a ete fait, Seul nombre entier � moin de 10 chiffres sont accepter","Erreur");
			}
		}
		
		
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permettant de cach� l'interface utilisateur.
	 */
	public void hide()
	{
		frame.setVisible(false);
	}
	public JFrame getJFrame()
	{
		return frame;
	}
	
}
