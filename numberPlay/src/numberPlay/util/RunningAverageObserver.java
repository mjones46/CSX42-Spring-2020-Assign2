package numberPlay.util;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.util.Filter;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
	This class finds the running average for integers in a window size
*/
public class RunningAverageObserver implements ObserverI{
	ArrayList<ArrayList<Double>> run = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> finalL = new ArrayList();
	ArrayList<Integer> runA = new ArrayList();
	private int counter;
	private int size;
	private int total;
	private int truesize;

	public RunningAverageObserver(int size){
		this.size = size;
	}

	/**
	This finds the average of integers in the file
	@param value	the data from the input file
	*/
	@Override
	public void update(int value){
		counter =  counter + 1;
		total = total + value;
		truesize = truesize + 1;
		int newtotal = 0;
		runA.add(value);
		if(truesize < size){
			double average = Math.round(((double)total/truesize)*100.00)/100.00;
			finalL.add(average);
		}else{
			for(int i = counter - size; i < runA.size();i++){
				newtotal = newtotal + runA.get(i);
			}
			double average = Math.round(((double)newtotal/size)*100.00)/100.00;
			finalL.add(average);
		}
	}
	
	@Override
	public void update(float value){}
	
	/**
	This return the final list of averages
	*/
	@Override
	public ArrayList<Double> update(){
		return finalL;
	}
	
	/**
	This return the final list of averages
	*/
	@Override
	public ArrayList<ArrayList<Double>> updates(){
		return run;
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
