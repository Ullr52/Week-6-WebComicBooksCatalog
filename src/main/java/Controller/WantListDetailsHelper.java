package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ComicBooksList;
import model.WantListDetails;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Feb 19, 2022
 */
public class WantListDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebComicBooksCatalog");
	
	public void insertNewWantListDetails(WantListDetails c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		}
		public List<WantListDetails> getComicsList() {
		EntityManager em = emfactory.createEntityManager();
		List<WantListDetails> allWantDetails = em.createQuery("SELECT d FROM WantListDetails d").getResultList();
		return allWantDetails;
		}
		
		
		/**
		 * @param parseInt
		 * @return
		 */
		public WantListDetails searchForComicById(Integer tempId) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			WantListDetails found = em.find(WantListDetails.class, tempId);
			em.close();
			return found;
		}
		
		/**
		 * @param listToUpdate
		 */
		public void updateCustomerList(WantListDetails listToUpdate) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(listToUpdate);
			em.getTransaction().commit();
			em.close();
		}
		
		/**
		 * @param comicListToDelete
		 */
		public void deleteComicList(WantListDetails comicListToDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<WantListDetails> typedQuery = em.createQuery("SELECT detail from WantListDetails detail where detail.id= :selectedId", WantListDetails.class);
			typedQuery.setParameter("selectedId", comicListToDelete.getId());
			
			typedQuery.setMaxResults(1);
			
			WantListDetails result = typedQuery.getSingleResult();
			
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			
		
		}
		

}
