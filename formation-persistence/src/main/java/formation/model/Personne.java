package formation.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "tPersonne")
@NamedQueries({
	@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
	@NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom=:nom")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Prenom", length = 100, nullable = false)
	private String prenom;
	@Column(name = "Nom", length = 150)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "Civilite")
	private Civilite civilite;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Naissance")
	private Date dateNaissance;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero", column = @Column(name = "PNUMERO")),
		@AttributeOverride(name = "rue", column = @Column(name = "PRUE", length = 200)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "CP")),
		@AttributeOverride(name = "ville", column = @Column(name = "VILLE"))
	})
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "ID_SALLE")
	private Salle salle;
	@Version
	private int version;

	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	} 
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	public Personne() {
	}
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Personne other = (Personne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
