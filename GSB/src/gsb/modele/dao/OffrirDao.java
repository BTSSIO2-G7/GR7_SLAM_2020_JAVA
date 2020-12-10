package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Stocker;
import gsb.modele.Visite;

public class OffrirDao {

// Récupération d'une offre dans la BDD grâce au dépot légal et la référence
	public static Offrir rechercher(String unDepotLegal, String uneReference) {
		Offrir uneOffre = null;
		try {

			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from offrir where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE = '"+uneReference+"'");
			if (resultatReq.next()){
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(2));
				Visite uneVisite= VisiteDao.rechercher(resultatReq.getString(3));
				uneOffre  = new Offrir(unMedicament, uneVisite, resultatReq.getInt(1));
			}
		}
		catch(Exception e) {  
			System.out.println("select * from offrir where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE = '"+uneReference+"'");  } 
		return uneOffre;
	}

// Insertion d'une nouvelle offre dans la BDD grâce à l'objet passé en paramètre
	public static void creer(Offrir uneOffre){
		String requeteInsertion;
		int qteofferte = uneOffre.getQteOfferte();		
		String depotlegal = uneOffre.getUnMedicament().getDepotLegal();		
		String reference = uneOffre.getUneVisite().getReference();

		requeteInsertion = "insert into offrir values("+qteofferte+",'"+depotlegal+"','"+reference+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);

		String matricule = uneOffre.getUneVisite().getUnVisiteur().getMatricule();		
		Stocker unStock = StockerDao.rechercher(depotlegal, matricule);
		int qtestock = unStock.getQteStock()-qteofferte;
		unStock.setQteStock(qtestock);
		StockerDao.modifierStock(unStock);
		ConnexionMySql.fermerConnexionBd();

	}

// Retour de toutes les offres de la BDD
	public static ArrayList<Offrir> retournerListe(String uneReference){
		ArrayList<Offrir> colOffrir = new ArrayList<Offrir>();
		Offrir uneOffre = null;

		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from offrir where reference = '"+uneReference+"'");
			while (resultatReq.next()){		
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(2));
				Visite uneVisite= VisiteDao.rechercher(resultatReq.getString(3));
				uneOffre  = new Offrir(unMedicament, uneVisite, resultatReq.getInt(1));
				colOffrir.add(uneOffre);
			}
		} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from offrir");  } 
		return colOffrir;
	}

}
