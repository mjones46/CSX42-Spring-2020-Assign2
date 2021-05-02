package numberPlay.util;

import java.lang.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandle{
	private String checkNumber;
	private int checkVal;
	//a string that is set for debuggin purposes

	private static class ExceptHandleGet{
		/**
		 @param	w	any custom ExceptionHandle
		 @ExceptionHandle
		 @throws	ExceptionHandle(wordHandler)
		 */
		public static ExceptionalHandle wordHandler(ExceptionHandle w){
			return new ExceptionalHandle(){
				@Override
				public void run() throws Exception{
					if(!Pattern.matches("[0-9.[ \t\n\f\r]]*", w.getNumber())){
						throw new Exception("Invalid characters were found in the input file or the file contained no valid characters, program will exit, no output will be generated.");
					}
				}
			};
		}
		/**
		 @param	w	any custom ExceptionHandle
		 @ExceptionHandle
		 @throws	ExceptionHandle(wordHandler)
		 */
		/*public static ExceptionHandle valueHandler(ExceptionHandle p) {
			return new ExceptionalHandle(){
				@Override
				public void run() throws Exception{
					if(p.getVal() <= 0){
						throw new Exception("Invalid number entered. Please enter a whole number greater than 0.");
					}
				}
			};
		}*/
	}
	/**
	 This throws custom exception wordHandler
	 @ExceptionHandle
	 @throws	ExceptionHandle(wordHandler)
	 */
	public ExceptionHandle(String checkNumber) throws Exception{//, int checkVal) throws Exception{
		this.checkNumber = checkNumber;
		//this.checkVal = checkVal;
		ExceptionalUtil.excepthandling("Could not process: ", ExceptHandleGet.wordHandler(this));//, ExceptHandleGet.valueHandler(this));
	}

	/**
	 This sets the word to be checked
	 @param	checkWord	a String that may not be alphanumberic
	 */
	public void setNumber(String checkNumber){
		this.checkNumber = checkNumber;
	}

	/**
	 This returns the word that was set
	 @return	the word that was set before
	 */
	public String getNumber(){
		return checkNumber;
	}

	public void setVal(int checkVal){
		this.checkVal = checkVal;
	}

	public int getVal(){
		return checkVal;
	}
}

interface ExceptionalHandle{
	void run() throws Exception;
}

final class ExceptionalUtil{
	/**
	 This goes through all the possible errors 0 or wordHandle
	 @param errorMsg		the message to let the user know an error occured
	 @param excepthandlers	takes 0 to 1(Only one custom exception) to handle
	 @ExceptionHandle
	 @throws	ExceptionHandle(wordHandle)
	 */
	public static void excepthandling(String errorMsg, ExceptionalHandle... excepthandlers) throws Exception {
		for (ExceptionalHandle eh : excepthandlers) {
			try {
				eh.run();
			}catch (Exception e) {
				throw new Exception(errorMsg.concat(e.getMessage()), e);
			}
		}
	}
}
