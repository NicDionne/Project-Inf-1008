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
