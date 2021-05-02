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
	This class writes to an outputfile the running average of integers
*/
public class RunningAverageData implements PersisterI, RunningAverageResultsI {
	private String outputFile;
	
	/**
		This is the constructor it sets the output file used
	*/
	public RunningAverageData(String outputFile) throws InvalidPathException, SecurityException, FileNotFoundException, IOException{
		this.outputFile=outputFile;
	}
	
	/**
	 This writes the running averages to an output file
	 @param	r	the final list of running averages
	 */
	@Override
	public void writeToFiles(ArrayList<Double> r){
		try{
			FileWriter outfile = new FileWriter(outputFile);
			for(int i=0;i<r.size();i++){
				outfile.write(r.get(i).toString()+"\n");
			}
			outfile.close();
		}catch(IOException e){
			System.out.println("Unable to write to file");
			System.exit(0);
		}finally{}
	}
	
	@Override
	public void store(ArrayList<Double> r){
	}
	
	@Override
	public void writeToFile(ArrayList<ArrayList<Double>> m){
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
