package formation.dao;

import java.util.List;

import formation.model.Salle;

public interface DaoSalle extends DaoGeneric<Salle, Integer>{
	public List<Salle> findByNom();
	public Salle findByKeyLazy(Integer key);
}
