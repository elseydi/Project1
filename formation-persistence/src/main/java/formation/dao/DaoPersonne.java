package formation.dao;

import java.util.List;

import formation.model.Formateur;
import formation.model.Personne;
import formation.model.Stagiaire;

public interface DaoPersonne extends DaoGeneric<Personne, Integer> {
	public List<Personne> findByNom(String nom);
	public List<Formateur> findAllFormateur();
	public List<Stagiaire> findAllStagiaire();
}
