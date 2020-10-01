package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

public class OffrirDao {
	public static Offrir rechercher(String unDepotLegal, String uneReference) {
		Offrir uneOffre = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from offre where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE'"+uneReference+"'");
			if (resultatReq.next()){
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(2));
				Visite uneVisite= VisiteDao.rechercher(resultatReq.getString(3));
				uneOffre  = new Offrir(unMedicament, uneVisite, resultatReq.getInt(1));
			}
	}
	catch(Exception e) {  
		System.out.println("select * from offre where MED_DEPOTLEGAL ='"+unDepotLegal+"' AND REFERENCE'"+uneReference+"'");  } 
		return uneOffre;
	}
	
	public static void creer(Offrir uneOffre){
		String requeteInsertion;
		int qteofferte = uneOffre.getQteOfferte();		
		String depotlegal = uneOffre.getUnMedicament().getDepotLegal();		
		String reference = uneOffre.getUneVisite().getReference();
		
		requeteInsertion = "insert into offrir values('"+qteofferte+"','"+depotlegal+"','"+reference+"')";
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
				Medicament unMedicament= MedicamentDao.rechercher(resultatReq.getString(2));
				Visite uneVisite= VisiteDao.rechercher(resultatReq.getString(3));
				uneOffre  = new Offrir(unMedicament, uneVisite, resultatReq.getInt(1));
				colOffrir.add(uneOffre);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from localite");  } 
		return colOffrir;
	}
}
