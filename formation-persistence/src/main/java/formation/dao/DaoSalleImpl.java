package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import formation.Application;
import formation.model.Salle;

public class DaoSalleImpl implements DaoSalle {

	@Override
	public void insert(Salle obj) {
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
	public Salle update(Salle obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		Salle s = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			s = em.merge(obj);
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
		return s;
	}

	@Override
	public void delete(Salle obj) {
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
	public Salle findByKey(Integer key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Salle s = null;
		s = em.find(Salle.class, key);
		em.close();
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Salle> liste = null;
		// Le FETCH pour précharger la liste de personnes
		// Le DISTINCT pour ne pas avoir pleins d'objets en doublons!!!!!!
		Query query = em.createQuery("SELECT DISTINCT s FROM Salle s LEFT OUTER JOIN FETCH s.personnes");
		liste = query.getResultList(); // Evidemment il ne peux pas savoir que notre requete ne renvoie que des Personnes
		em.close();
		return liste;
	}

	@Override
	public List<Salle> findByNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salle findByKeyLazy(Integer key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Salle salle = null;
		Query query = em.createQuery("FROM Salle s LEFT OUTER JOIN FETCH s.personne WHERE s.code=:code");
		query.setParameter("code", key);
		try {
			salle = (Salle)query.getSingleResult();
		} catch (NoResultException e) { // S'il n'y a pas de résultat
			e.printStackTrace();
		}
		em.close();
		return salle;
	} 

}
