package numberPlay.util;

import java.util.ArrayList;
/**
* RunningAverageResultsI defines an interface to be implemented by
* classes that intend to store the running average for each number
* processed in a stream of numbers.
*/
public interface RunningAverageResultsI {
	void store(ArrayList<Double> r);
}
