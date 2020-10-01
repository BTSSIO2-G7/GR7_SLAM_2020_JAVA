package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Stocker;

public class StockerDao {
	public static Stocker rechercher(String unCodePostal) {
		Stocker unStock = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from stock where CODEPOSTAL ='"+unCodePostal+"'");
			if (resultatReq.next()){
				unStock  = new Stocker(resultatReq.getString(1), resultatReq.getString(2));
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from stock where CODEPOSTAL ='"+unCodePostal+"'");  } 
		return unStock;
	}
	
	public static void creer(Stocker unStock){
		String requeteInsertion;
		String code = unStock.getCodePostal();		
		String ville = unStock.getVille();
		
		requeteInsertion = "insert into stock values('"+code+"','"+ville+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Stocker> retournerListe(){
		ArrayList<Stocker> colStock = new ArrayList<Stocker>();
		Stocker unStock = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from stock");
			while (resultatReq.next()){		
				unStock  = new Stocker(resultatReq.getString(1), resultatReq.getString(2));
				colStock.add(unStock);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from stock");  } 
		return colStock;
	}
}
