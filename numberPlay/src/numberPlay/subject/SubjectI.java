package numberPlay.subject;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;

import java.util.ArrayList;

public interface SubjectI{
	void process(String n);
	void register(ObserverI o, FilterI f);
	void notifyObserver(String n);
	ArrayList<Double> completes(int i);
	ArrayList<ArrayList<Double>> complete(int i);
}
