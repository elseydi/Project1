package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.Application;
import formation.model.Matiere;

public class DaoMatiereImpl implements DaoMatiere {

	@Override
	public void insert(Matiere obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public Matiere update(Matiere obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		Matiere m = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			m = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return m;
	}

	@Override
	public void delete(Matiere obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Matiere findByKey(Integer key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Matiere m = null;
		m = em.find(Matiere.class, key);
		em.close();
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matiere> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Matiere> liste = null;
		Query query = em.createQuery("FROM Matiere m ");
		liste = query.getResultList(); // Evidemment il ne peux pas savoir que notre requete ne renvoie que des Personnes
		em.close();
		return liste;
	}


}
