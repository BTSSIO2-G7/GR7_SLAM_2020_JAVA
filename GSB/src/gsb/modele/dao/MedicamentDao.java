package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;

public class MedicamentDao {
	public static Medicament rechercher(String unDepotLegal) {
		Medicament unMedicament = null;
		try {
			
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from medicament where MED_DEPOTLEGAL ='"+unDepotLegal+"'");
			if (resultatReq.next()){
				unMedicament  = new Medicament(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getInt(6),resultatReq.getString(7), resultatReq.getString(8));
			}
	}
	catch(Exception e) {  
		System.out.println("Erreur requete : select * from medicament where CODEPOSTAL ='"+unDepotLegal+"'");  } 
		return unMedicament;
	}
	
	public static void creer(Medicament unMedicament){
		String requeteInsertion;
		String depot = unMedicament.getDepotLegal();
		String nom = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreindication = unMedicament.getContreIndication();
		double prixechantillon = unMedicament.getPrixEchantillon();
		String codefamille = unMedicament.getCodeFamille();
		String libellefamille = unMedicament.getLibellefamille();
				

		requeteInsertion = "insert into medicament values('"+depot+"','"+nom+"','"+composition+"','"+effets+"','"+contreindication+"','"+prixechantillon+"','"+codefamille+"','"+libellefamille+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}
	
	public static ArrayList<Medicament> retournerListe(){
		ArrayList<Medicament> colMedicament = new ArrayList<Medicament>();
		Medicament unMedicament = null;
		
		try {
			ResultSet resultatReq =ConnexionMySql.execReqSelection("select * from medicament");
			while (resultatReq.next()){		
				unMedicament  = new Medicament(resultatReq.getString(1), resultatReq.getString(2), resultatReq.getString(3), resultatReq.getString(4), resultatReq.getString(5), resultatReq.getInt(6),resultatReq.getString(7), resultatReq.getString(8));
				colMedicament.add(unMedicament);
			}
			} // fin try
		catch(Exception e) {  
			System.out.println("Erreur requete : select * from medicament");  } 
		return colMedicament;
	}
}
