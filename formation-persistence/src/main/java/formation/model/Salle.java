package formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tSalle")
public class Salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODE_SALLE")
	private int code;
	@Override
	public String toString() {
		return "Salle [code=" + code + ", nom=" + nom + ", etage=" + etage + "]";
	}
	@Column(name = "Nom", length = 32, nullable = false)
	private String nom;
	@Column(name = "Etage", length = 2)
	private int etage;
	@OneToMany(mappedBy = "salle", fetch = FetchType.EAGER) // ATTENTION CHARGEMENT SYSTEMATIQUE!!! 
	private List<Personne> personnes;

	@Version
	private int version;
	
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
}
