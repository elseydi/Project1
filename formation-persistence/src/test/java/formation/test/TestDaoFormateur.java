package formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import formation.Application;
import formation.dao.DaoPersonne;
import formation.dao.DaoSalle;
import formation.model.Adresse;
import formation.model.Civilite;
import formation.model.Formateur;
import formation.model.Personne;
import formation.model.Salle;
import formation.model.Stagiaire;

public class TestDaoFormateur {

	public static void main(String[] args) throws ParseException {
		DaoPersonne daoPersonne = Application.getInstance().getDaoPersonne();
		DaoSalle daoSalle = Application.getInstance().getDaoSalle()	;
		Stagiaire cyrille = new Stagiaire();
		cyrille.setPrenom("Cyrille");
		daoPersonne.insert(cyrille);
		cyrille.setNom("Richard");
		cyrille.setEntreprise("Pôle");
		daoPersonne.update(cyrille);
		
		Formateur olivier = new Formateur();
		olivier.setPrenom("Spam");
		olivier.setNom("Egg");
		olivier.setCivilite(Civilite.Mlle);
		daoPersonne.insert(olivier);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //On définit ce qu'on veut
		
		try {
			olivier.setDateNaissance(sdf.parse("30/03/1945"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		olivier.setAdresse(new Adresse(5, "Boulevard Glandu", "05627", "Melun-sur-Oise"));
		olivier.setCout(900000);
		
		olivier = (Formateur) daoPersonne.update(olivier);
		olivier.setCout(150);
		olivier = (Formateur) daoPersonne.update(olivier);
		
		Salle salle = new Salle();
		salle.setNom("Rouge");
		salle.setEtage(1);
		daoSalle.insert(salle);
		olivier.setSalle(salle);
		
		daoPersonne.update(olivier);
		
		Personne p = null;
		p = daoPersonne.findByKey(olivier.getId());
		System.out.println(p.getSalle());
		
		salle = daoSalle.findByKey(salle.getCode());
		System.out.println("Liste de personnes : " + salle.getPersonnes());
		
		p = daoPersonne.findByKey(olivier.getId());
		System.out.println(p.getCivilite().getTitre() + " " + p.getPrenom() + " " + p.getNom());
		System.out.println("Tout le monde : " + daoPersonne.findAll());
		System.out.println("Liste de formateurs : " + daoPersonne.findAllFormateur());
		Application.close();
	}

}
