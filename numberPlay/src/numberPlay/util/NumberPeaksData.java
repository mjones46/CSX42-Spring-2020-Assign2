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
	This class writes to an output file the peaks of both integers and
	floats
*/
public class NumberPeaksData implements PersisterI, NumberPeaksResultsI {
	private String outputFile;
	
	/**
	This is the constructor for the output file
	*/
	public NumberPeaksData(String outputFile) throws InvalidPathException, SecurityException, FileNotFoundException, IOException{
		this.outputFile=outputFile;
	}
	
	/**
	This writes the peaks to an output file
	@param p	the final list of peaks
	*/
	@Override
	public void writeToFiles(ArrayList<Double> p){
		try{
			FileWriter outfile = new FileWriter(outputFile);
			for(int i=0;i<p.size();i++){
				outfile.write(p.get(i).toString()+"\n");
			}
			outfile.close();
		}catch(IOException e){
			System.out.println("Unable to write to file");
			System.exit(0);
		}finally{}
	}
	
	@Override
	public void store(ArrayList<Double> p){
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
