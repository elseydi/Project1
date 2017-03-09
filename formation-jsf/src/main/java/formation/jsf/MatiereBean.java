package formation.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import formation.Application;
import formation.dao.DaoMatiere;
import formation.model.Matiere;

@ManagedBean
@RequestScoped
public class MatiereBean {
	private Integer matiereCode;
	private Matiere currentMatiere=new Matiere();

	private DaoMatiere matiereDao = Application.getInstance().getDaoMatiere();

	public Integer getMatiereCode() {
		return matiereCode;
	}

	public void setMatiereCode(Integer matiereCode) {
		this.matiereCode = matiereCode;
	}

public Matiere getCurrentMatiere() {
		return currentMatiere;
	}

	public void setCurrentMatiere(Matiere currentMatiere) {
		this.currentMatiere = currentMatiere;
	}

public String edit()
{
	if(currentMatiere.getCode()!=null){
		currentMatiere=matiereDao.findByKey(matiereCode);
		return "matiereEdit";
	}
	else{
		return "matieres";
	}
	
	
}

public String delete()
{
	currentMatiere=matiereDao.findByKey(matiereCode);
	if(currentMatiere.getCode()!=null){
		matiereDao.delete(currentMatiere);
		return "matieres";
	}
	else
	{
		return "matieres";
		
	}
	
	
}


public String add()
{
	//currentMatiere=new Matiere();
	
	
	return "matiereEdit";
}

public String save()
{
	//System.out.println(currentMatiere.getIntitule());
	if(currentMatiere.getCode()==null)
	{
	matiereDao.insert(currentMatiere);
	}
	else
	{
		matiereDao.update(currentMatiere);
	}
	return "matieres";
}

public String cancel()
{
	//currentMatiere=new Matiere();
	
	
	return "matieres";
}

	public List<Matiere> getMatieres() {
		return matiereDao.findAll();
	}

}
