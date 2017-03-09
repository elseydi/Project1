package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.Application;
import formation.model.Formateur;
import formation.model.Personne;
import formation.model.Stagiaire;

public class DaoPersonneImpl implements DaoPersonne {

	@Override
	public void insert(Personne obj) {
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
	public Personne update(Personne obj) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		EntityTransaction tx = null;
		Personne p = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			p = em.merge(obj);
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
		return p;
	}

	@Override
	public void delete(Personne obj) {
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
	public Personne findByKey(Integer key) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Personne p = null;
		p = em.find(Personne.class, key);
		em.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Personne> liste = null;
		// Query query = em.createQuery("SELECT p FROM Personne p");
		// AVEC LES REQUETES NOMMEES:
		Query query = em.createNamedQuery("Personne.findAll");
		liste = query.getResultList(); // Evidemment il ne peux pas savoir que notre requete ne renvoie que des Personnes
		return liste;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> findByNom(String nom) {
		List<Personne> liste = null;
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Query query = em.createNamedQuery("Personne.findByNom");
		query.setParameter("nom", nom);
		liste = query.getResultList();
		return liste;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formateur> findAllFormateur() {
		List<Formateur> liste = null;
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("SELECT DISTINCT f FROM Formateur f LEFT OUTER JOIN f.competences");
		liste = query.getResultList();
		return liste;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stagiaire> findAllStagiaire() {
		List<Stagiaire> liste = null;
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("SELECT s FROM Stagiaire s");
		liste = query.getResultList();
		return liste;
	}


}
