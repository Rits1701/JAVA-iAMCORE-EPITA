package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exception.DAOInitializationException;

/**
 * This class Implements DAO interface
 * 
 * @author shikha RITU
 * @param <T>: T is a user defined type
 * 
 */
public class IdentityDAO implements DAO<Identity> {
	
	
	private Connection connection;
	/**
	 * 
	 */
	public IdentityDAO(){
		connection = Connector.getConnection();
	}

	/* (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#create(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void create(Identity entity) throws DAOInitializationException{
		
		connection = Connector.getConnection();
		try {
			String sql = "insert into IDENTITIES (DISPLAY_NAME, EMAIL, "
					+ "PASSWORD, ISADMIN)"
					+" values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql,
											Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getDisplayName());
			statement.setString(2, entity.getEmail());
			statement.setString(3, entity.getPassword());
			int isAdmin = (entity.isAdmin())?1:0;
			statement.setInt(4, isAdmin);
			statement.executeUpdate();
			
			
			Connector.releaseConnection();
		} catch (SQLException e) {
			Logger.getLogger(IdentityDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
		 
		
	}
	/* (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#update(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void update(Identity entity) throws DAOInitializationException{
		connection = Connector.getConnection();
		try {
			String sql = "UPDATE IDENTITIES "
					+ "SET DISPLAY_NAME=?,"
					+ "EMAIL=?,"
					+ "PASSWORD=?,"
					+ "ISADMIN=?"
					+ "WHERE IDENTITY_ID=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getDisplayName());
			statement.setString(2, entity.getEmail());
			statement.setString(3, entity.getPassword());
			int isAdmin = (entity.isAdmin())?1:0;
			statement.setInt(4, isAdmin);
			statement.setString(5, entity.getUid());
			statement.execute();
			statement.close();
		
		} catch (SQLException e) {
			Logger.getLogger(IdentityDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		 
		
	}
	/* (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#delete(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void delete(Identity identity) throws DAOInitializationException{
		connection = Connector.getConnection();
		try {
			String sql = "delete from IDENTITIES "
					+" where IDENTITY_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, identity.getUid());
			statement.executeUpdate();
			statement.close();
			Connector.releaseConnection();
		} catch (SQLException e) {
			Logger.getLogger(IdentityDAO.class.getName()).log(Level.SEVERE, null, e);
			
		}
		 
		
	}
	/* (non-Javadoc)
	 * @see fr.epita.iam.services.DAO#readAllIdentities()
	 */
	@Override
	public List<Identity> readAll() throws DAOInitializationException{
		connection = Connector.getConnection();
		Map<String, Identity> identities = new HashMap<String, Identity>();
		try {
			String sql = "select * from IDENTITIES i left join ATTRIBUTE a on "
					+ "i.identity_id=a.identity_id";
			ResultSet result = connection.prepareStatement(sql).executeQuery();
			
			while(result.next()){
				String uid = result.getString("IDENTITY_ID");
				String displayName = result.getString("display_name");
				String email = result.getString("email");
				String password = result.getString("PASSWORD");
				boolean isadmin = (result.getInt("ISADMIN")==1)? true:false;
			/*	String name = result.getString("name");
				String value = result.getString("value");*/
				
				Identity identity;
					if (identities.containsKey(uid)){
						identity = identities.get(uid);
						/*if (name != null){
							identity.setAttribute(name, value);
						}*/
					}
					else{
						identity = new Identity(uid, displayName, 
								email, password);
						identity.setAdmin(isadmin);
						/*if (name != null){
							identity.setAttribute(name, value);
						}*/
						identities.put(identity.getUid(), identity);
					}
				
					
					identities.put(identity.getUid(), identity);
					

			}
			
			Connector.releaseConnection();
		} catch (SQLException e) {
			Logger.getLogger(IdentityDAO.class.getName()).log(Level.SEVERE, null, e);
			
		}
		List<Identity> result = new ArrayList<Identity>();
		for (Identity i :identities.values()){
			result.add(i);
		}
		return result;
	}


	@Override
	public Identity find(Object id) throws DAOInitializationException {
		Identity identity = null;
		connection = Connector.getConnection();
		try {
			String sql = "select * from IDENTITIES where IDENTITY_ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id.toString()));
			
			ResultSet result = statement.executeQuery();
			if (result.next()){
				String uid = result.getString("identity_id");
				String displayName = result.getString("display_name");
				String email = result.getString("email");
				String psswd = result.getString("password");
				identity = new Identity(uid, displayName, email,psswd);
			}
			Connector.releaseConnection();
		} catch (SQLException e) {
			Logger.getLogger(IdentityDAO.class.getName()).log(Level.SEVERE, null, e);
		
		}
		 
		
		return identity;
	}

	@Override
	public List<Identity> search(String[] keywords, Identity entity) throws DAOInitializationException {
		// TODO Auto-generated method stub
		return null;
	}

}
