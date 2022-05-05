/**
 * @author Ramy
 */

package project.vehicule.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.vehicule.CsvFile;
import project.vehicule.CsvFileHelper;

public class CsvFileImpl implements CsvFile {

    public final static char SEPARATOR = ',';

    private File file;
    private List<String> lines;
    private List<String[] > data;

    public CsvFileImpl(File file) {
        this.file = file;
        init();
    }

    private void init() {
        lines = CsvFileHelper.readFile(file);

        data = new ArrayList<String[] >(lines.size());
        String sep = new Character(SEPARATOR).toString();
        for (String line : lines) {
            String[] oneData = line.split(sep);
            data.add(oneData);
        }
    }

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String[]> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public boolean addElementEndOfFile(ArrayList<String> line) {
		
		FileWriter pw;
		
		try {
			Iterator<String> iter = line.iterator();
			if (iter.hasNext() == false){
				return false;
			}
			pw = new FileWriter(file, true);
			while(iter.hasNext()) {
        		String current  = iter.next();
				pw.append(current);
				if (iter.hasNext()) pw.append(",");
        	}
        	pw.append("\n");
            pw.flush();
            pw.close();
        } catch (IOException e) {
			e.printStackTrace();
		}
        
		return false;
	}

	@Override
	public boolean addLineBeginOfFile(ArrayList<String> line) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLineById(int id) {

		BufferedReader reader;
		boolean find = false;
		try {
			reader = new BufferedReader(new FileReader(file));
			String element = Integer.toString(id);
			String currentLine;
			String newList = "";
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.startsWith(element)) {
					find = true;
					continue;
				}
				newList = newList + currentLine + "\n";
			} 
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
			writer.write(newList); 
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
		return find;
	}
}
