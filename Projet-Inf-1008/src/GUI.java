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
	 * Methode permetant le retour au menu plus générale que celui présent.
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
	 * Methode permettant de saisir une entrer de la part de l'utilisateur, ce dernier bloque l'utilisateur
	 * tant qu'il n'aura pas repondu ou quitter
	 * 
	 * @param message : String correspondant au message que l'on veut envoyer
	 * @param titre : String du titre de la boite message
	 * @return : Int Entrer de la part de l'utilisateur, null si l'utilisateur annule
	 */
	public int inputBoxInt(String message, String titre)
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null,message,titre,JOptionPane.INFORMATION_MESSAGE));
	}
	
	/**
	 * @author Nicolas Dionne
	 * 
	 * Methode permettant de caché l'interface utilisateur.
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
