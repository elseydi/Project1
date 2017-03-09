package formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MATIERE")
public class Matiere {
	@Id
	@GeneratedValue
	@Column(name = "CODE")
	private Integer code;
	@Column(name = "LIBELLE", length = 100)
	private String intitule;

	@Column(name = "Dur�e", length = 100)
	private Long dur�e;
	@Version
	private int version;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dur�e == null) ? 0 : dur�e.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
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
		Matiere other = (Matiere) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dur�e == null) {
			if (other.dur�e != null)
				return false;
		} else if (!dur�e.equals(other.dur�e))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getDur�e() {
		return dur�e;
	}

	public void setDur�e(Long dur�e) {
		this.dur�e = dur�e;
	}

	public Matiere() {
	}
}
