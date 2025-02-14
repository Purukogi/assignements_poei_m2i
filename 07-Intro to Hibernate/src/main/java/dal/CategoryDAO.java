package dal;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import bo.Category;

public class CategoryDAO {
	
	private EntityManagerFactory emf;

	public CategoryDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}

	public List<Category> select(){
		
		EntityManager em = emf.createEntityManager(); //open connection
		List<Category> result = em.createQuery("from Category", Category.class).getResultList();
		em.close();
		return result;
		
	}
	
	public Category selectById(int id) {
		
		EntityManager em = emf.createEntityManager();
		Category result = em.find(Category.class, id);
		em.close();
		return result;
				
	}
	
	public void insert(Category category) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.persist(category);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void update(Category category) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.merge(category);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void delete(Category category) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.remove(em.merge(category));
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

}
