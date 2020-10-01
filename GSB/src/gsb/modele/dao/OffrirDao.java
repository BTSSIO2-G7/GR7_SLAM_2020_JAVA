package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Offrir;

public class OffrirDao {
	public static Offrir rechercher(String unCodePostal) {
		Offrir uneOffre = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from localite where CODEPOSTAL ='"+unCodePostal+"'");
			if (resultatReq.next()){
				uneOffre  = new Offrir(resultatReq.getString(1), resultatReq.getString(2));
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from localite where CODEPOSTAL ='"+unCodePostal+"'");  } 
		return uneOffre;
	}
	
	public static void creer(Offrir uneOffre){
		String requeteInsertion;
		String code = uneOffre.getCodePostal();		
		String ville = uneOffre.getVille();
		
		requeteInsertion = "insert into localite values('"+code+"','"+ville+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Offrir> retournerListe(){
		ArrayList<Offrir> colOffrir = new ArrayList<Offrir>();
		Offrir uneOffre = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from localite");
			while (resultatReq.next()){		
				uneOffre  = new Offrir(resultatReq.getString(1), resultatReq.getString(2));
				colOffrir.add(uneOffre);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from localite");  } 
		return colOffrir;
	}
}
