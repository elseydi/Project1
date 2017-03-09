package formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue(value = "FORMATEUR")
public class Formateur extends Personne{
	@Column(name = "Cout")
	private double cout;
	@OneToMany(mappedBy = "key.formateur")
	private List<FormateurMatiere> competences;

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public List<FormateurMatiere> getCompetences() {
		return competences;
	}

	public void setCompetences(List<FormateurMatiere> competences) {
		this.competences = competences;
	}
	
}
