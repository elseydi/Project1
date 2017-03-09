package formation.dao;

import java.util.List;

import formation.model.Formateur;
import formation.model.FormateurMatiere;


public interface DaoFormateur extends DaoGeneric<Formateur, Integer> {

	Formateur findByCompetences(List<FormateurMatiere> competences);



	
}
