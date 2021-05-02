package numberPlay.util;

import java.util.ArrayList;
/**
* NumberPeaksResultsI defines an interface to be implemented by 
* classes that intend to store peaks in the input number stream.
*/
public interface NumberPeaksResultsI {
	void store(ArrayList<Double> p);
}
