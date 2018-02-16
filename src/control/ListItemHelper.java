package control;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {
	
	
	public void insertItem(ListItem toAdd) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(int id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem toDelete = em.find(ListItem.class, id);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateListItem(ListItem toUpdate) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();		
		em.getTransaction().begin();
		//ListItem toUpdateTemp = em.find(ListItem.class, toUpdate.getId());
		//toUpdateTemp = toUpdate;
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllItems() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li", ListItem.class);
		List<ListItem> results = typedQuery.getResultList();
		em.close();
		return results;
	}
	
	public ListItem findById(int selectedId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li where li.id = :selectedId", ListItem.class);
		typedQuery.setParameter("selectedId",  selectedId);
		ListItem result = typedQuery.getSingleResult();
		em.close();
		return result;
	}
	
	public List<ListItem> findAllByStore(String selectedStore) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li where li.store = :selectedStore", ListItem.class);
		typedQuery.setParameter("selectedStore",  selectedStore);
		List<ListItem> results = typedQuery.getResultList();
		em.close();
		return results;
	}

	public List<ListItem> findAllByItem(String selectedItem) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
		EntityManager em = emfactory.createEntityManager();
		
		TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li where li.item = :selectedItem", ListItem.class);
		typedQuery.setParameter("selectedItem",  selectedItem);
		List<ListItem> results = typedQuery.getResultList();
		em.close();
		return results;
	}
}
