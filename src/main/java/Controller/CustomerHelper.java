package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Feb 19, 2022
 */
public class CustomerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebComicBooksCatalog");

	public void insertCustomer(Customer c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		}
	public List<Customer> showAllCustomers() {
		EntityManager em = emfactory.createEntityManager();
		List<Customer> allShoppers = em.createQuery("SELECT c FROM Customer c").getResultList();
		return allShoppers;
		}
	/**
	 * @param customerName
	 * @return
	 */
	public Customer findCustomer(String customerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select ch from Customer ch where ch.customerName = :selectedName",
		Customer.class);
		typedQuery.setParameter("selectedName", customerName);
		typedQuery.setMaxResults(1);
		Customer foundCustomer;
		try {
			foundCustomer = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCustomer = new Customer(customerName);
		}
		em.close();
		return foundCustomer;
	}
}
