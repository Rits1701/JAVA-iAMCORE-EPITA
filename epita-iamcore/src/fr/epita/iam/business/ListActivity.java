package fr.epita.iam.business;

import java.util.List;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.IdentityDAO;


/**
 * ListActivity is a class that allows to Get list of an Identity using
 * user inputs
 *  @author shikha RITU
 *
 */

public class ListActivity extends Activity{
		public static void execute(){
			System.out.println("Identity Listing");
			IdentityDAO identityDAO = new IdentityDAO();
			List<Identity> identities = identityDAO.readAll();
			for(int i = 0; i < identities.size(); i++){
				System.out.println( i+ "." + identities.get(i).toString());
				
			}
		}		

}
