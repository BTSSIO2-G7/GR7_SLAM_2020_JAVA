package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {
	public static Visite rechercher(String uneReference) {
		Visite uneVisite = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visite where REFERENCE ='"+uneReference+"'");
			if (resultatReq.next()){
				Medecin unMedecin = MedecinDao.rechercher(resultatReq.getString(4));
				Visiteur unVisiteur = VisiteurDao.rechercher(resultatReq.getString(5));
				uneVisite  = new Visite(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), unMedecin, unVisiteur);
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from visite where REFERENCE ='"+uneReference+"'");  } 
		return uneVisite;
	}
	
	public static void creer(Visite uneVisite){
		String requeteInsertion;
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		String medecin = uneVisite.getUnMedecin().getCodeMed();
		String visiteur = uneVisite.getUnVisiteur().getMatricule();
		
		requeteInsertion = "insert into visite values('"+reference+"','"+date+"','"+commentaire+"','"+medecin+"','"+visiteur+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Visite> retournerListe(){
		ArrayList<Visite> colVisite = new ArrayList<Visite>();
		Visite uneVisite = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visite");
			while (resultatReq.next()){		
				Medecin unMedecin = MedecinDao.rechercher(resultatReq.getString(4));
				Visiteur unVisiteur = VisiteurDao.rechercher(resultatReq.getString(5));
				uneVisite  = new Visite(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), unMedecin, unVisiteur);
				colVisite.add(uneVisite);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visite");  } 
		return colVisite;
	}
}
