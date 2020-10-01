package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.*;

public class LocaliteDao {
public static Localite rechercher(String unCodePostal) {
		Localite uneLocalite = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from LOCALITE where CODEPOSTAL ='"+unCodePostal+"'");
			if (resultatReq.next()){
				uneLocalite  = new Localite(resultatReq.getString(1), resultatReq.getString(2));
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from localite where CODEPOSTAL ='"+unCodePostal+"'");  } 
		return uneLocalite;
	}
	
	public static void creer(Localite uneLocalite){
		String requeteInsertion;
		String code = uneLocalite.getCodePostal();		
		String ville = uneLocalite.getVille();
		
		requeteInsertion = "insert into localite values('"+code+"','"+ville+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Localite> retournerListe(){
		ArrayList<Localite> colLocalite = new ArrayList<Localite>();
		Localite uneLocalite = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from localite");
			while (resultatReq.next()){		
				uneLocalite  = new Localite(resultatReq.getString(1), resultatReq.getString(2));
				colLocalite.add(uneLocalite);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from localite");  } 
		return colLocalite;
	}
}
