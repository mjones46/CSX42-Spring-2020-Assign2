package numberPlay.util;

import numberPlay.filter.FilterI;

/**
	This class Filters the events that can occur for an observer
*/
public class Filter implements FilterI{
	//source: https://www.geeksforgeeks.org/enum-customized-value-java/
	private String event;
	
	public enum Event{
		INTEGER_EVENT("INTEGER_EVENT"),FLOATING_POINT_EVENT("FLOATING_POINT_EVENT"),PROCESSING_COMPLETE("PROCESSING_COMPLETE");//,, ;
		
		private String event;
		Event(String event){
			this.event = event;
		}
		public String getEvent(){
			return event;
		}
	}
	
	/**
	 This is the constructor for the filter
	 @param	event	the event type
	 */
	public Filter(String event){
		this.event = event;
	}
	
	/**
	 This gets the filter of an observer
	 @return	the constructor string
	 */
	@Override
	public String getEvent(){
		return this.event;
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
