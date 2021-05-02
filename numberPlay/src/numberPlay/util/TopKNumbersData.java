package numberPlay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import java.lang.String;
import java.lang.StringBuffer;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

/**
	This class writes to an output file the top Ks for both integers and
	floats
*/
public class TopKNumbersData implements PersisterI, TopKNumbersResultsI {
	private String outputFile;
	
	/**
	 This is the constructor that sets the outputfile string
	 */
	public TopKNumbersData(String outputFile) throws InvalidPathException, SecurityException, FileNotFoundException, IOException{
		this.outputFile=outputFile;
	}
	
	/**
	 This writes the top ks to an output file
	 @param	k	the final list of top ks
	 */
	@Override
	public void writeToFile(ArrayList<ArrayList<Double>> k){
		try{
			FileWriter outfile = new FileWriter(outputFile);
			for(int i=0;i<k.size();i++){
				outfile.write(k.get(i).toString()+"\n");
			}
			outfile.close();
		}catch(IOException e){
			System.out.println("Unable to write to file");
			System.exit(0);
		}finally{}
	}
	
	@Override
	public void store(ArrayList<ArrayList<Double>> k){
	}

	@Override
	public void writeToFiles(ArrayList<Double> m){
	}

	@Override
	public void close(){
	}
	
	/*@Override
	public String toString(){
		return "";
	}
	
	@Override
	public boolean equals(FilterI p){
	return true;
	}
	
	@Override
	public int hasCode(){
	return 1;
	}*/
}
