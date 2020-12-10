package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {

// Recherche d'un stock dans la BDD grâce au dépot légal et au matricule
	public static Stocker rechercher(String unDepotLegal, String unMatricule) {
		Stocker unStock = null;
		try {

			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from stocker where MED_DEPOTLEGAL = '"+unDepotLegal+"' AND MATRICULE = '"+unMatricule+"'");
			if (resultatReq.next()){
				Visiteur unVisiteur= VisiteurDao.rechercher(resultatReq.getString(2));
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(3));
				unStock  = new Stocker(resultatReq.getInt(1), unVisiteur, unMedicament);
			}
		}
		catch(Exception e) {  
			System.out.println("select * from stocker where MED_DEPOTLEGAL = '"+unDepotLegal+"' AND MATRICULE = '"+unMatricule+"'");  } 
		return unStock;
	}

// Ajout d'un stock dans la BDD grâce à l'objet passé en paramètre
	public static void creer(Stocker unStock){
		String requeteInsertion;
		int qtestock = unStock.getQteStock();		
		String depotlegal = unStock.getUnMedicament().getDepotLegal();		
		String matricule = unStock.getUnVisiteur().getMatricule();		
		requeteInsertion = "insert into stocker values("+qtestock+",'"+matricule+"','"+depotlegal+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}

// Modification d'une quantité de stock grâce au stock passé en paramètre
	public static void modifierStock(Stocker unStock){
		String requeteInsertion;
		int qtestock = unStock.getQteStock();		
		String depotlegal = unStock.getUnMedicament().getDepotLegal();		
		String matricule = unStock.getUnVisiteur().getMatricule();
		requeteInsertion = "update stocker set QTESTOCK = "+qtestock+" where MATRICULE = '"+matricule+"' AND MED_DEPOTLEGAL = '"+depotlegal+"'";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}

// Retour de tout les stocks de la BDD
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
