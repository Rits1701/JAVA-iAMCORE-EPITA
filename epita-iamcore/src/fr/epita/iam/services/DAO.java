package fr.epita.iam.services;


import java.util.List;


import fr.epita.iam.exception.DAOInitializationException;

/**
 * This interface defines the operations required to update the table 
 * of the database
 * @author shikha RITU
 *
 * @param <T>: T is a user defined type
 * 
 */
public interface DAO<T> {
	/**
	 *  Create a row in the table associated with entity T
	 * @param entity: A class in the datamodel
	 * 
	 */
	public void create(T entity) throws DAOInitializationException;
	
	/**
	 * Update the value of a row in the table associated with entity T
	 * @param entity: A class in the datamodel
	 */
	public void update(T entity) throws DAOInitializationException;
	
	/**
	 * Delete row in table associate with entity T
	 * @param entity: A class in the datamodel
	 */
	public void delete(T entity) throws DAOInitializationException;
	
	/**
	 * Find a entity in the table associated giving an ID
	 * @param id, id of the identities
	 * @return void 
	 */
    public T find(final Object id)throws DAOInitializationException;
    
    /**
     * Search entity giving some keywords
     * @param keywords;
     * @param entity;
     * @return list of entity of type T
     * 
     */
    List<T> search(String[] keywords, T entity)throws DAOInitializationException;
	/**
	 * Read all entities of type T 
	 * @return list of entity of type T
	 * 
	 */
	List<T> readAll() throws DAOInitializationException;

}