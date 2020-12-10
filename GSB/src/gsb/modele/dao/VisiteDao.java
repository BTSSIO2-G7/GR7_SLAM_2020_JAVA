package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {

// Retour d'une visite de la BDD grâce à une référence
	public static Visite rechercher(String uneReference) {
		Visite uneVisite = null;
		try {

			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visite where REFERENCE ='"+uneReference+"'");
			if (resultatReq.next()){				
				Visiteur unVisiteur = VisiteurDao.rechercher(resultatReq.getString(4));
				Medecin unMedecin = MedecinDao.rechercher(resultatReq.getString(5));
				uneVisite  = new Visite(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), unVisiteur, unMedecin);
			}
		}
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visite where REFERENCE ='"+uneReference+"'");  } 
		return uneVisite;
	}

// Insertion d'une visite passée en paramètre dans la BDD
	public static void creer(Visite uneVisite){
		String requeteInsertion;
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		String medecin = uneVisite.getUnMedecin().getCodeMed();		

		String visiteur = uneVisite.getUnVisiteur().getMatricule();


		requeteInsertion = "insert into visite values('"+reference+"','"+date+"','"+commentaire+"','"+visiteur+"','"+medecin+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}

// Retour de toutes les visites dans la BDD
	public static ArrayList<Visite> retournerListe(){
		ArrayList<Visite> colVisite = new ArrayList<Visite>();
		Visite uneVisite = null;

		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visite");
			while (resultatReq.next()){		
				Medecin unMedecin = MedecinDao.rechercher(resultatReq.getString(5));
				Visiteur unVisiteur = VisiteurDao.rechercher(resultatReq.getString(4));
				uneVisite  = new Visite(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), unVisiteur, unMedecin);
				colVisite.add(uneVisite);
			}
		} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visite");  } 
		return colVisite;
	}

// Modification du commentaire d'une visite de la BDD
	public static void changerCommentaire(Visite uneVisite, String unCommentaire) {
		String requeteInsertion;
		requeteInsertion = "update visite set COMMENTAIRE = '"+unCommentaire+"' where REFERENCE = '"+uneVisite.getReference()+"'";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();

	}

// Retour d'une liste de visites grâce à soit un matricule, soit une date
	public static ArrayList<Visite> rechercherListe(String matricule, String date) {
		ArrayList<Visite> colVisite = new ArrayList<Visite>();
		Visite uneVisite = null;

		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visite where matricule = '"+matricule+"' or datevisite = '"+date+"'");
			while (resultatReq.next()){		
				Visiteur unVisiteur= VisiteurDao.rechercher(resultatReq.getString(4));
				Medecin unMedecin= MedecinDao.rechercher(resultatReq.getString(5));
				uneVisite  = new Visite(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), unVisiteur, unMedecin);
				colVisite.add(uneVisite);
			}
		} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visite where matricule = '"+matricule+"' or datevisite = '"+date+"'");  } 
		return colVisite;
	}
}
