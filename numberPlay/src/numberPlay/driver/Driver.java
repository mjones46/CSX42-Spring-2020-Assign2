package numberPlay.driver;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;

import numberPlay.util.ExceptionHandle;
import numberPlay.util.FileProcessor;
import numberPlay.util.Filter;
import numberPlay.util.NumberPeaksData;
import numberPlay.util.NumberPeaksObserver;
import numberPlay.util.NumberPeaksResultsI;
import numberPlay.util.NumberProcessor;
import numberPlay.util.PersisterI;
import numberPlay.util.RunningAverageData;
import numberPlay.util.RunningAverageData;
import numberPlay.util.RunningAverageObserver;
import numberPlay.util.RunningAverageResultsI;
import numberPlay.util.TopKNumbersData;
import numberPlay.util.TopKNumbersObserver;
import numberPlay.util.TopKNumbersResultsI;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.InvalidPathException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**@author Melissa Jones */

public class Driver {
	public static void main(String[] args) {
		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 * FIXME Refactor commandline validation using the validation design taught in class.
		 */
		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || 
				(args[0].equals("${inputNumStream}")) || 
				(args[1].equals("${runAvgWindowSize}")) || 
				(args[2].equals("${runAvgOutFile}")) ||
				(args[3].equals("${k}")) ||
				(args[4].equals("${topKNumOutFile}")) ||
				(args[5].equals("${numPeaksOutFile}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
		int window = 0;
		int topK = 0;
		try{
			window = Integer.parseInt(args[1]);
			topK = Integer.parseInt(args[3]);
			if(window <= 0 || topK <= 0){
				System.out.println("The window size for Top K and Running Average cannot be less than zero, they must also be an integer. Please try again.");
				System.exit(0);
			}
		}catch(NumberFormatException f){
			System.out.println("You did a bad thing. Why did you do it, are you proud of yourself?");
			System.exit(0);
		}finally{}
		SubjectI newNumber = new NumberProcessor();
		ObserverI runningAvgO = new RunningAverageObserver(window);
		ObserverI topKO = new TopKNumbersObserver(topK);
		ObserverI peaksO = new NumberPeaksObserver();
		//source: https://www.geeksforgeeks.org/enum-in-java/
		String integerEvent = "INTEGER_EVENT";
		String floatingPointEvent = "FLOATING_POINT_EVENT";
		String processingCompleteEvent = "PROCESSING_COMPLETE";
		FilterI integer = new Filter(integerEvent);
		FilterI floater = new Filter(floatingPointEvent);
		FilterI complete = new Filter(processingCompleteEvent);
		newNumber.register(runningAvgO,integer);
		newNumber.register(topKO,integer);
		newNumber.register(peaksO,integer);
		newNumber.register(topKO,floater);
		newNumber.register(peaksO,floater);
		newNumber.register(runningAvgO,complete);
		newNumber.register(topKO,complete);
		newNumber.register(peaksO,complete);
		String line = "";
		ArrayList<Double> run = new ArrayList<Double>();
		ArrayList<Double> hi = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> top = new ArrayList<ArrayList<Double>>();
		try{
			FileProcessor inputfile = new FileProcessor(args[0]);
			PersisterI runningAvgR = new RunningAverageData(args[2]);
			PersisterI topKR = new TopKNumbersData(args[4]);
			PersisterI numPeaksR = new NumberPeaksData(args[5]);
			while(true){
				line = inputfile.poll();
				if(line != null){
					newNumber.process(line);
				}else{
					run = newNumber.completes(0);
					top = newNumber.complete(1);
					hi = newNumber.completes(2);
					runningAvgR.writeToFiles(run);
					topKR.writeToFile(top);
					numPeaksR.writeToFiles(hi);
					break;
				}
			}
		}catch(IOException ex){
			System.out.println("The file doesn't exist. Please try again");
			System.exit(0);
		}finally{}
	}
}
