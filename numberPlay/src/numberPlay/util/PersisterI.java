package numberPlay.util;

import java.util.ArrayList;

/**
* To be implemented by classes that persist generated output data.
*/
public interface PersisterI {
	void close();
	void writeToFiles(ArrayList<Double> j);
	void writeToFile(ArrayList<ArrayList<Double>> m);
}
