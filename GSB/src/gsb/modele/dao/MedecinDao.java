package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medecin;


public class MedecinDao {
	public static Medecin rechercher(String unCodeMed) {
		Medecin unMedecin = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from medecin where CODEMED ='"+unCodeMed+"'");
			if (resultatReq.next()){
				Localite uneLocalite = LocaliteDao.rechercher(resultatReq.getString(8));
				unMedecin  = new Medecin(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getString(6), resultatReq.getString(7), uneLocalite);
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from medecin where CODEPOSTAL ='"+unCodeMed+"'");  } 
		return unMedecin;
	}
	
	public static void creer(Medecin unMedecin){
		String requeteInsertion;
		String code = unMedecin.getCodeMed();
		String nom = unMedecin.getNom();
		String prenom = unMedecin.getPrenom();
		String adresse = unMedecin.getAdresse();
		String telephone = unMedecin.getTelephone();
		String potentiel = unMedecin.getPotentiel();
		String specialite = unMedecin.getSpecialite();
		String localite = unMedecin.getUneLocalite().getVille();
		
		requeteInsertion = "insert into medecin values('"+code+"','"+nom+"','"+prenom+"','"+adresse+"','"+telephone+"','"+potentiel+"','"+specialite+"','"+localite+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Medecin> retournerListe(){
		ArrayList<Medecin> colMedecin = new ArrayList<Medecin>();
		Medecin unMedecin = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from medecin");
			while (resultatReq.next()){		
				Localite uneLocalite = LocaliteDao.rechercher(resultatReq.getString(8));
				unMedecin  = new Medecin(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getString(6), resultatReq.getString(7), uneLocalite);
				colMedecin.add(unMedecin);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from medecin");  } 
		return colMedecin;
	}
}
