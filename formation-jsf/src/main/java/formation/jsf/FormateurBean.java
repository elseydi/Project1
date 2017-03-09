package formation.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import formation.Application;
import formation.dao.DaoFormateur;
import formation.model.Formateur;
import formation.model.FormateurMatiere;
import formation.model.Matiere;

@ManagedBean
@RequestScoped
public class FormateurBean {

	//private List<FormateurMatiere> competences;
	private double cout;
	private Formateur currentFormateur = new Formateur();

	private DaoFormateur daoFormateur = Application.getInstance().getDaoFormateur();

	

	

//	public List<FormateurMatiere> getCompetences() {
//		return competences;
//	}
//
//	public void setCompetences(List<FormateurMatiere> competences) {
//		this.competences = competences;
//	}

	public Formateur getCurrentFormateur() {
		return currentFormateur;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public void setCurrentFormateur(Formateur currentFormateur) {
		this.currentFormateur = currentFormateur;
	}

//	public String edit() {
//		if (currentFormateur.getCompetences() != null) {
//			currentFormateur = daoFormateur.findByCompetences(competences);
//			return "formateurEdit";
//		} else {
//			return "formateurs";
//		}
//
//	}
//
//	public String delete() {
//		currentFormateur = daoFormateur.findByCompetences(competences);
//		if (currentFormateur.getCompetences() != null) {
//			daoFormateur.delete(currentFormateur);
//			return "formateurs";
//		} else {
//			return "formateurs";
//
//		}
//
//	}

	public String add() {
		// currentMatiere=new Matiere();

		return "formateurEdit";
	}

	public String save() {
		// System.out.println(currentMatiere.getIntitule());
		if (currentFormateur.getCompetences() == null) {
			daoFormateur.insert(currentFormateur);
		} else {
			daoFormateur.update(currentFormateur);
		}
		return "formateurs";
	}

	public String cancel() {
		// currentMatiere=new Matiere();

		return "formateurs";
	}

	public List<Formateur> getFormateurs() {
		return daoFormateur.findAll();
	}

}
