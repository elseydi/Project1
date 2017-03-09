package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.Application;
import formation.model.FormateurMatiere;
import formation.model.FormateurMatiereKey;

public class DaoFormateurMatiereImpl implements DaoFormateurMatiere {

	@Override
	public void insert(FormateurMatiere obj) {
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
	public FormateurMatiere update(FormateurMatiere obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		FormateurMatiere fm = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			fm = em.merge(obj);
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
		return fm;
	}

	@Override
	public void delete(FormateurMatiere obj) {
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
	public FormateurMatiere findByKey(FormateurMatiereKey key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		FormateurMatiere fm = null;
		fm = em.find(FormateurMatiere.class, key);
		em.close();
		return fm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FormateurMatiere> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<FormateurMatiere> liste = null;
		Query query = em.createQuery("FROM FormateurMatiere fm ");
		liste = query.getResultList(); // Evidemment il ne peux pas savoir que notre requete ne renvoie que des Personnes
		em.close();
		return liste;
	}
}
