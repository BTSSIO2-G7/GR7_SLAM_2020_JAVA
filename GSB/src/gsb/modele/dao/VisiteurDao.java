package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String unMatricule) {
		Visiteur unVisiteur = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visiteur where MATRICULE ='"+unMatricule+"'");
			if (resultatReq.next()){
				Localite uneLocalite= LocaliteDao.rechercher(resultatReq.getString(5));
				unVisiteur  = new Visiteur(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getString(6), uneLocalite, resultatReq.getString(8), resultatReq.getString(9), resultatReq.getInt(10), resultatReq.getString(11), resultatReq.getString(12));
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from visiteur where MATRICULE ='"+unMatricule+"'");  } 
		return unVisiteur;
	}
	
	public static void creer(Visiteur unVisiteur){
		String requeteInsertion;
		String matricule = unVisiteur.getMatricule();		
		String nom = unVisiteur.getNom();		
		String prenom = unVisiteur.getPrenom();		
		String login = unVisiteur.getLogin();		
		String mdp = unVisiteur.getMdp();		
		String adresse = unVisiteur.getAdresse();		
		String localite = unVisiteur.getUneLocalite().getVille();		
		String telephone = unVisiteur.getTelephone();		
		String dateentree = unVisiteur.getDateEntree();		
		int prime = unVisiteur.getPrime();		
		String codeunite = unVisiteur.getCodeUnite();		
		String nomunite = unVisiteur.getNomUnite();		
		
		requeteInsertion = "insert into visiteur values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+localite+"','"+telephone+"','"+dateentree+"','"+prime+"','"+codeunite+"','"+nomunite+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Visiteur> retournerListe(){
		ArrayList<Visiteur> colVisiteur = new ArrayList<Visiteur>();
		Visiteur unVisiteur = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from visiteur");
			while (resultatReq.next()){		
				Localite uneLocalite= LocaliteDao.rechercher(resultatReq.getString(5));
				unVisiteur  = new Visiteur(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getString(6), uneLocalite, resultatReq.getString(8), resultatReq.getString(9), resultatReq.getInt(10), resultatReq.getString(11), resultatReq.getString(12));
				colVisiteur.add(unVisiteur);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from visiteur");  } 
		return colVisiteur;
	}
}
