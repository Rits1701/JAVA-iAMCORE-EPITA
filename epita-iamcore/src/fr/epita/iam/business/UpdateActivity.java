package fr.epita.iam.business;

import java.util.List;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.IdentityDAO;

/**
 * This class allows to update an Identity using user inputs
 *  @author shikha RITU
 *
 */
public class UpdateActivity extends Activity{

	/**
	 * This method can user input and update an existing identity
	 * @param scanner: Get user inputs
	 */
	public static void execute(Scanner scanner){
		System.out.println("Identity Update");
		IdentityDAO identityDAO = new IdentityDAO();
		List<Identity> identities = identityDAO.readAll();
		System.out.println("Select an Identity id");
		for(Identity i : identities){
			System.out.println("ID: "+i.getUid()+ " \n"+i);
		}
		String identity_id = scanner.nextLine();
		Identity foundIdentity = identityDAO.find(identity_id);
		if (foundIdentity == null){
			System.out.println("Identity Not Found : "+identity_id);
		}
		else{
			System.out.println("Do you want to update identity: "+identity_id+"  y/n");
			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("y")){
				while(answer.equalsIgnoreCase("y")){
					System.out.println("Choose the field to update"); 
					System.out.println("1, DisplayName"); 
					System.out.println("2, Email"); 
					System.out.println("3, Password");
					System.out.println("4, Update");
					String options = scanner.nextLine();
					switch(options.toLowerCase()){
						case "1":
							System.out.println("Please enter new Displayname");
							String displayName = scanner.nextLine();
							foundIdentity.setDisplayName(displayName);
							break;
						case "2":
							System.out.println("Please enter new Email");
							String email = scanner.nextLine();
							foundIdentity.setEmail(email);
							break;
						case "3":
							System.out.println("Please enter new Password");
							String password = scanner.nextLine();
							foundIdentity.setPassword(password);
							break;
						case "4":
							answer = "n";
							break;
						default:
							answer = "y";
					}
				}
				
				//persist the identity somewhere
				System.out.println("This is the identity you updated: \n"+foundIdentity);
				identityDAO.update(foundIdentity);
				System.out.println("Update Done");
				
			}
			else{
				System.out.println("Update cancel");
			}
		}
	
	}
}
