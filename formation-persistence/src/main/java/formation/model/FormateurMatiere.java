package formation.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class FormateurMatiere {
	@EmbeddedId
	FormateurMatiereKey key;
	@Column(name = "Niveau", length = 100)
	private String niveau;
	@Version
	private int version;
	
	public FormateurMatiere() {
	}

	public FormateurMatiereKey getKey() {
		return key;
	}

	public void setKey(FormateurMatiereKey key) {
		this.key = key;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		FormateurMatiere other = (FormateurMatiere) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}
