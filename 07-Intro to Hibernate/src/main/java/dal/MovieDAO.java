package dal;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import bo.Movie;

public class MovieDAO {
	
	private EntityManagerFactory emf;

	public MovieDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	
	public List<Movie> select(){
		EntityManager em = emf.createEntityManager(); 
		List<Movie> result = em.createQuery("from Movie", Movie.class).getResultList();
		em.close();
		return result;
	}
	
	public Movie selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Movie result = em.find(Movie.class, id);
		em.close();
		return result;
	}
	
	public void insert(Movie movie) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.persist(movie);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void update(Movie movie) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.merge(movie);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void delete(Movie movie) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.remove(em.merge(movie));
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}
