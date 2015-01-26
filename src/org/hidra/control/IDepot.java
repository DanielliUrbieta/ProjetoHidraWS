package org.hidra.control;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;

/**
 * @author Danielli Urbieta e Pedro Souza

 * @param <Depot>
 * 
 */
@WebService
public interface IDepot<Depot> {

	/**
	 * @param myRepo
	 *
	 *
	 */
	@WebMethod
	public void init(@WebParam(name = "myRepo") Depot myRepo);


	/**
	 * @param myDepot
	 * @throws IOException
	 */
	@WebMethod
	public void create(@WebParam(name = "myDepot")Depot myDepot) throws IOException;

	/**
	 * @param file
	 * @throws NoFilepatternException
	 * @throws GitAPIException
	 * @throws IOException
	 */
	@WebMethod
	public void add(@WebParam(name = "file")String file) throws NoFilepatternException,
			GitAPIException, IOException;

	/**
	 * @param message
	 * @throws GitAPIException
	 */
	@WebMethod
	public void commit(@WebParam(name = "message")String message) throws GitAPIException;

	/**
	 * @param file
	 * @throws NoWorkTreeException
	 * @throws GitAPIException
	 */
	@WebMethod
	public void removeFile(@WebParam(name = "file")String file)
			throws NoWorkTreeException, GitAPIException;

	/**
	 * @param myDepot
	 * @throws InvalidRemoteException
	 * @throws TransportException
	 * @throws GitAPIException
	 * @throws IOException
	 */
	@WebMethod
	public void clone(@WebParam(name = "myDepot")Depot myDepot) throws InvalidRemoteException,
			TransportException, GitAPIException, IOException;

	/**
	 *
	 * @throws NoWorkTreeException
	 * @throws GitAPIException
	 *
	 */
	@WebMethod
	public void status() throws NoWorkTreeException,
			GitAPIException;

	/**
	 * @throws NoHeadException
	 * @throws GitAPIException
	 * @throws RevisionSyntaxException
	 * @throws AmbiguousObjectException
	 * @throws IOException
	 *
	 */
	@WebMethod
	public void getLogs() throws NoHeadException, GitAPIException,
			RevisionSyntaxException, AmbiguousObjectException, IOException;

	/**
	 */
	@WebMethod
	public void showBranch();

	/**
	 * @param nameBranch
	 */
	@WebMethod
	public void createBranch(@WebParam(name = "nameBranch")String nameBranch);

	/**
	 * @param nameBranch
	 */
	@WebMethod
	public void deleteBranch(@WebParam(name = "nameBranch")String nameBranch);


	/**
	 * @param branch1
	 * @param branch2
	 */
	@WebMethod
	public void getDiff(@WebParam(name = "branch1")String branch1,@WebParam(name = "branch2") String branch2);

	/**
	 * @param repository
	 * @param ref
	 * @return abstractTreeIterators
	 */
	@WebMethod
	public AbstractTreeIterator prepareTreeParser(@WebParam(name = "repository")Repository repository,
			String ref);

	/**
	 * @param git
	 */
	@WebMethod
	public void pull(@WebParam(name = "git")Git git);

}
