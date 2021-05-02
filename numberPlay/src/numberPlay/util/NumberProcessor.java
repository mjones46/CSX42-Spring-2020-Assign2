package numberPlay.util;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.InvalidPathException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
	This class registers,processes and generates output for an observer
	with respect to its filter
*/
public class NumberProcessor implements SubjectI{
	Map<FilterI, List<ObserverI>> observers;
	
	/**
	This calls notifyObserver
	@param line		the file input
	*/
	@Override
	public void process(String line){
		notifyObserver(line);
	}
	
	/**
	This handles when processing is done for a specific observer
	@param i	the location of the observer in the list
	@return n	the data from the observer
	*/
	@Override
	public ArrayList<ArrayList<Double>> complete(int i){
		ArrayList<ArrayList<Double>> n = new ArrayList<ArrayList<Double>>();
		for(Map.Entry<FilterI,List<ObserverI>> entry : observers.entrySet()){
			if(entry.getKey().getEvent()=="PROCESSING_COMPLETE"){
				ObserverI o = entry.getValue().get(i);
				n = o.updates();
			}
		}
		return n;
	}
	
	/**
	This handles when processing is done for a specific observer
	@param i	the location of the observer in the list
	@return n	the data from the observer
	*/
	@Override
	public ArrayList<Double> completes(int i){
		ArrayList<Double> n = new ArrayList<Double>();
		for(Map.Entry<FilterI,List<ObserverI>> entry : observers.entrySet()){
			if(entry.getKey().getEvent()=="PROCESSING_COMPLETE"){
				ObserverI o = entry.getValue().get(i);
				n = o.update();
			}
		}
		return n;
	}
	
	/**
	This puts the filters and their observers into a HashMap
	@param o	the observer that requires a filter
	@param f	the filter for the desired observer
	*/
	@Override
	public void register(ObserverI o, FilterI f){
		if(!observers.containsKey(f)){
			observers.put(f,new ArrayList<ObserverI>());
		}
		observers.get(f).add(o);
	}
	
	/**
	This determines if the line is an integer or a float and call the
	required observers
	@param line		the file input
	*/
	@Override
	public void notifyObserver(String line){
		int lineInteger = 0;
		float lineFloat = 0;
		for(Map.Entry<FilterI,List<ObserverI>> entry : observers.entrySet()){
			FilterI f = entry.getKey();
			for(ObserverI o: entry.getValue()){
				if(Pattern.matches("[\t\n\f\r]*", line) || Pattern.matches("[a-zA-Z]*", line)){
					System.out.println("Incorrect file input, numbers must be on every line.");
					System.exit(0);
				}if(Pattern.matches("[0-9.]*", line)){
					try{
						lineInteger = Integer.parseInt(line);
						if(f.getEvent()=="INTEGER_EVENT"){
							o.update(lineInteger);
						}
					}catch(NumberFormatException e){
						try{
							lineFloat = Float.parseFloat(line);
							if(f.getEvent()=="FLOATING_POINT_EVENT"){
								o.update(lineFloat);
							}
						}catch(NumberFormatException eh){
							System.out.println("Invalid input, neither a integer or a float. Please retry.");
							System.exit(0);
						}finally{}
					}finally{}
				}
			}
		}
	}
	
	/**
	This makes a HashMap of Filters and Observers
	*/
	public NumberProcessor(){
		observers = new HashMap<FilterI,List<ObserverI>>();
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
