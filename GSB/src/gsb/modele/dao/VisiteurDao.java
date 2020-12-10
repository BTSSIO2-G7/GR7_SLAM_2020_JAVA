package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {

// Recherche d'une visite dans la BDD
	public static Visiteur rechercher(String unMatricule) {
		Visiteur unVisiteur = null;
		try {

			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visiteur where MATRICULE ='"+unMatricule+"'");
			if (resultatReq.next()){
				Localite uneLocalite = LocaliteDao.rechercher(resultatReq.getString(7));
				unVisiteur  = new Visiteur(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getString(6), uneLocalite,  resultatReq.getString(8), resultatReq.getString(9), resultatReq.getString(10));
			}
		}
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visiteur where MATRICULE ='"+unMatricule+"'");  } 
		return unVisiteur;
	}

// Insertion dans la BDD d'un visiteur passé en paramètre
	public static void creer(Visiteur unVisiteur){
		String requeteInsertion;
		String matricule = unVisiteur.getMatricule();		
		String nom = unVisiteur.getNom();		
		String prenom = unVisiteur.getPrenom();		
		String login = unVisiteur.getLogin();		
		String mdp = unVisiteur.getMdp();		
		String adresse = unVisiteur.getAdresse();		
		String codepostal = unVisiteur.getLaLocalite().getCodePostal();
		String dateentree = unVisiteur.getDateEntree();		
		String codeunite = unVisiteur.getCodeUnite();		
		String nomunite = unVisiteur.getNomUnite();		

		requeteInsertion = "insert into visiteur values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+codepostal+"','"+dateentree+"','"+codeunite+"','"+nomunite+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}

// Retour de tous les visiteurs de la BDD
	public static ArrayList<Visiteur> retournerListe(){
		ArrayList<Visiteur> colVisiteur = new ArrayList<Visiteur>();		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select MATRICULE from visiteur");
			while (resultatReq.next()){		
				String matricule= resultatReq.getString(1);
				colVisiteur.add(VisiteurDao.rechercher(matricule));
			}
		} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visiteur");  } 
		return colVisiteur;
	}
}
