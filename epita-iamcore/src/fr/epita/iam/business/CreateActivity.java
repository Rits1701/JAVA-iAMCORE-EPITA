package fr.epita.iam.business;

import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.IdentityDAO;


/**
 * CreateActivity is a class that allows to create an Identity using
 * user inputs
 *  @author shikha RITU
 *
 */
public class CreateActivity extends Activity{
	
	/**
	 * This method get a string as input and generate associated Date
	 * @throws ParseException
	 */
	
	/**
	 * This method create an Identity from user inputs
	 * @param scanner: Get the user input 
	 */
	public static void execute(Scanner scanner){
		System.out.println("Identity Creation");
		System.out.println("Please input the displayName");
		String displayName = scanner.nextLine();
		System.out.println("Please input the email address");
		String email = scanner.nextLine();
		System.out.println("Please input the password");
		String password = scanner.nextLine();
		
		Identity identity = new Identity("",displayName,
								email, password);
		
	
		//persist the identity somewhere
		System.out.println("This is the identity you created\n"+identity);
		IdentityDAO identityDAO = new IdentityDAO();
		identityDAO.create(identity);
		System.out.println("Creation Done");
		
	}
}
