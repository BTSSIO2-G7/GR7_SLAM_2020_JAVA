package gsb.service;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteService {
	public static Visite rechercherVisite(String uneReference){
		Visite uneVisite = null;
		try{
			if (uneReference==null) {
				throw new Exception("Donnée obligatoire : référence");
			}			
			else if (VisiteDao.rechercher(uneReference)==null) {
				throw new Exception("Référence non existante");
			}
			else {
				uneVisite = VisiteDao.rechercher(uneReference);
			}
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneVisite;
	}

	public static Visite creerVisite(Visite uneVisite){

		try{

			if (VisiteDao.rechercher(uneVisite.getReference())!=null) {
				throw new Exception("Visite déjà existante");
			}
			
			else if (MedecinDao.rechercher(uneVisite.getUnMedecin().getCodeMed())==null){
				throw new Exception("Médecin non existant");				
			}
			
			else if (VisiteurDao.rechercher(uneVisite.getUnVisiteur().getMatricule())==null){
				throw new Exception("Visiteur non existant");				
			}	
			
			else {
				VisiteDao.creer(uneVisite);
			}
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneVisite;
	}

	public static ArrayList<Visite> rechercherListe(String matricule, String date) {
		ArrayList<Visite> lesVisites=null;
		try{
			if (matricule==null && date==null) {
				throw new Exception("Donnée obligatoire : matricule visiteur ou date");
			}
			else {
				lesVisites = VisiteDao.rechercherListe(matricule, date);
			}
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return lesVisites;
	}


}
