package numberPlay.util;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.util.Filter;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
	This class finds the top K of both integers and floats in a sized
	window
*/
public class TopKNumbersObserver implements ObserverI{
	//source: https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
	//source: https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
	//source: https://beginnersbook.com/2013/12/sort-arraylist-in-descending-order-in-java/
	ArrayList<ArrayList<Double>> topKs = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> topK = new ArrayList<Double>();
	private float previous;
	private int counter;
	private int size;
	
	/**
	 This sets the window size provided from the commandline
	 @param	size	the size of the window needed
	 */
	public TopKNumbersObserver(int size){
		this.size = size;
	}
	
	/**
	 This calculates the top K for ints from the file
	 @param	size	the int from a file
	 */
	@Override
	public void update(int value){
		counter = counter +1;
		if(value > previous){
			double newValue = Math.round(value*100.00)/100.00;
			topK.add(0,newValue);
		}
		Collections.sort(topK, Collections.reverseOrder());
		ArrayList<Double> mini = new ArrayList<Double>();
		ArrayList<Double> miniS = new ArrayList<Double>();
		if(counter<size){
			for(int i = 0;i < counter;i++){
				mini.add(topK.get(i));
			}
			topKs.add(mini);
		}else{
			for(int i = 0;i < size;i++){
				miniS.add(topK.get(i));
			}
			topKs.add(miniS);
		}	
	}
	
	/**
	 This calculates the top K for floats from the file
	 @param	size	the float from a file
	 */
	@Override
	public void update(float value){
		counter = counter +1;
		if(value > previous){
			double newValue = Math.round(value*100.00)/100.00;
			topK.add(0,newValue);
		}
		Collections.sort(topK, Collections.reverseOrder());
		ArrayList<Double> mini = new ArrayList<Double>();
		ArrayList<Double> miniS = new ArrayList<Double>();
		if(counter<size){
			for(int i = 0;i < counter;i++){
				mini.add(topK.get(i));
			}
			topKs.add(mini);
		}else{
			for(int i = 0;i < size;i++){
				miniS.add(topK.get(i));
			}
			topKs.add(miniS);
		}
	}
	
	/**
	 This returns the Top Ks from the input
	 @return		the final topKs
	 */
	@Override
	public ArrayList<ArrayList<Double>> updates(){
		return topKs;
	}
	
	/**
	 This returns the Top Ks from the input
	 @return		the final topKs
	 */
	@Override
	public ArrayList<Double> update(){
		return topK;
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
