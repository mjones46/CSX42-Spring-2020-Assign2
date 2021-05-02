package numberPlay.observer;

import java.util.ArrayList;

public interface ObserverI{
	void update(int value);
	void update(float value);
	ArrayList<Double> update();
	ArrayList<ArrayList<Double>> updates();
}
