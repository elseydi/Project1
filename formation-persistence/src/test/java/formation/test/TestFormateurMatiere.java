package formation.test;

import formation.Application;
import formation.dao.DaoFormateurMatiere;
import formation.dao.DaoFormateurMatiereImpl;
import formation.dao.DaoMatiere;
import formation.dao.DaoMatiereImpl;
import formation.dao.DaoPersonne;
import formation.dao.DaoPersonneImpl;
import formation.model.Formateur;
import formation.model.FormateurMatiere;
import formation.model.FormateurMatiereKey;
import formation.model.Matiere;

public class TestFormateurMatiere {

	public static void main(String[] args) {
		Formateur olivier = new Formateur();
		olivier.setPrenom("Olivier");
		DaoPersonne daoPersonne = Application.getInstance().getDaoPersonne();
		daoPersonne.insert(olivier);

		Matiere java = new Matiere();
		java.setIntitule("Java");
		DaoMatiere daoMatiere = Application.getInstance().getDaoMatiere();
		daoMatiere.insert(java);
		
		FormateurMatiereKey key = new FormateurMatiereKey(olivier, java);
		FormateurMatiere olivierJava = new FormateurMatiere();
		olivierJava.setKey(key);
		olivierJava.setNiveau("tous");
		
		DaoFormateurMatiere daoFormateurMatiere = Application.getInstance().getDaoFormateurMatiere();
		daoFormateurMatiere.insert(olivierJava);
		Application.close();	
			
	}

}
