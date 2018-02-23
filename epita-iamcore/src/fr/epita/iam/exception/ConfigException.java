package fr.epita.iam.exception;

/**
 * This class allows to update an Identity using user inputs
 *  @author shikha Ritu
 *
 */

public class ConfigException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Did not find configuration properties";
	}

}
