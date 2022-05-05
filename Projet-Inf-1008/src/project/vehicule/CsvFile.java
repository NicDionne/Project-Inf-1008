/**
 * @author Ramy
 */

package project.vehicule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface CsvFile {
	
	File getFile();

    List<String[] > getData();
    
    boolean addElementEndOfFile(ArrayList<String> line);
    
    boolean addLineBeginOfFile(ArrayList<String> line);
    
    boolean deleteLineById(int id);

}
