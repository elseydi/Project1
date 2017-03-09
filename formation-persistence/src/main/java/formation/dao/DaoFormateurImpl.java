package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.Application;
import formation.model.Formateur;

public class DaoFormateurImpl implements DaoFormateur {

	@Override
	public void insert(Formateur obj) {
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
	public Formateur update(Formateur obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		Formateur m = null;
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
	public void delete(Formateur obj) {
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
	public Formateur findByKey(Integer key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Formateur m = null;
		m = em.find(Formateur.class, key);
		em.close();
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formateur> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Formateur> liste = null;
		Query query = em.createQuery("FROM Matiere m ");
		liste = query.getResultList(); // Evidemment il ne peux pas savoir que notre requete ne renvoie que des Personnes
		em.close();
		return liste;
	}


}
