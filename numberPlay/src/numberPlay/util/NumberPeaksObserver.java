package numberPlay.util;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.util.Filter;

import java.util.ArrayList;
import java.util.Collections;

/**
	This class finds the peaks of both integers and floats in a window
	size
*/
public class NumberPeaksObserver implements ObserverI{
	ArrayList<ArrayList<Double>> p = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> peaks = new ArrayList<Double>();
	private float previous;
	
	/**
	This finds the peaks of the integers in the file
	@param value	the data form the input file
	*/
	@Override
	public void update(int value){
		if(value < previous){
			peaks.add(Math.round(((double)previous)*100.00)/100.00);
		}else{	
			previous = value;
		}
	}
	
	/**
	This finds the peaks of the floats in the file
	@param value	the data form the input file
	*/
	@Override
	public void update(float value){
		if(value < previous){
			peaks.add(Math.round(((double)previous)*100.00)/100.00);
		}else{
			previous = value;
		}
	}
	
	/**
	This returns the final list of peaks
	*/
	@Override
	public ArrayList<Double> update(){
		return peaks;
	}
	
	/**
	This returns the final list of peaks
	*/
	@Override
	public ArrayList<ArrayList<Double>> updates(){
		return p;
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
