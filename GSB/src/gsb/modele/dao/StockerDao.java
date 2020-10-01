package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {
	public static Stocker rechercher(String unDepotLegal, String uneReference) {
		Stocker unStock = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from offre where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE'"+uneReference+"'");
			if (resultatReq.next()){
				Visiteur unVisiteur= VisiteurDao.rechercher(resultatReq.getString(2));
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(3));
				unStock  = new Stocker(resultatReq.getInt(1), unVisiteur, unMedicament);
			}
	}
	catch(Exception e) {  
		System.out.println("select * from offre where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE'"+uneReference+"'");  } 
		return unStock;
	}
	
	public static void creer(Stocker unStock){
		String requeteInsertion;
		int qtestock = unStock.getQteStock();		
		String depotlegal = unStock.getUnMedicament().getDepotLegal();		
		String matricule = unStock.getUnVisiteur().getMatricule();		
		requeteInsertion = "insert into offrir values('"+qtestock+"','"+matricule+"','"+depotlegal+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Stocker> retournerListe(){
		ArrayList<Stocker> colStocker = new ArrayList<Stocker>();
		Stocker unStock = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from localite");
			while (resultatReq.next()){		
				Visiteur unVisiteur= VisiteurDao.rechercher(resultatReq.getString(2));
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(3));
				unStock  = new Stocker(resultatReq.getInt(1), unVisiteur, unMedicament);
				colStocker.add(unStock);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from localite");  } 
		return colStocker;
	}
}
