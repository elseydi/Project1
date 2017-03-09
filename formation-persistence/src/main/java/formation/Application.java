package formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formation.dao.DaoFormateur;
import formation.dao.DaoFormateurImpl;
import formation.dao.DaoFormateurMatiere;
import formation.dao.DaoFormateurMatiereImpl;
import formation.dao.DaoMatiere;
import formation.dao.DaoMatiereImpl;
import formation.dao.DaoPersonne;
import formation.dao.DaoPersonneImpl;
import formation.dao.DaoSalle;
import formation.dao.DaoSalleImpl;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf;
	private final DaoFormateurMatiere daoFormateurMatiere;
	private final DaoMatiere daoMatiere;
	private final DaoPersonne daoPersonne;
	private final DaoFormateur daoFormateur;
	private final DaoSalle daoSalle;

	private Application() {
		emf = Persistence.createEntityManagerFactory("formation");
		daoFormateurMatiere = new DaoFormateurMatiereImpl();
		daoMatiere = new DaoMatiereImpl();
		daoPersonne = new DaoPersonneImpl();
		daoSalle = new DaoSalleImpl();
		daoFormateur=new DaoFormateurImpl();

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public DaoFormateurMatiere getDaoFormateurMatiere() {
		return daoFormateurMatiere;
	}

	public DaoMatiere getDaoMatiere() {
		return daoMatiere;
	}

	public DaoPersonne getDaoPersonne() {
		return daoPersonne;
	}

	public DaoSalle getDaoSalle() {
		return daoSalle;
	}

	public DaoFormateur getDaoFormateur() {
		return daoFormateur;
	}

	private void closeEmf() {
		emf.close();
	}

	public static void close() {
		if (instance != null) {
			instance.closeEmf();
			instance = null;
		}
	}
}
