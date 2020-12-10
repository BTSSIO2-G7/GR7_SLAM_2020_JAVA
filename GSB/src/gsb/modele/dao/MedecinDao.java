package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedecinDao {
	
// Recherche dans la BDD grâce à un code médecin
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from medecin where CODEMED ='"+codeMedecin+"'");
		try {
			if (reqSelection.next()) {
				Localite uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), uneLocalite, reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8) );	
			};
			}
		catch(Exception e) {
			System.out.println("Erreur requete : select * from medecin where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}

// Insertion dans la BDD d'un nouveau Medecin grâce à un objet passé en paramètre
	public static void creer(Medecin unMedecin){
		String requeteInsertion;
		String code = unMedecin.getCodeMed();
		String nom = unMedecin.getNom();
		String prenom = unMedecin.getPrenom();
		String adresse = unMedecin.getAdresse();
		String telephone = unMedecin.getTelephone();
		String potentiel = unMedecin.getPotentiel();
		String specialite = unMedecin.getSpecialite();
		String localite = unMedecin.getLaLocalite().getCodePostal();
		
		requeteInsertion = "insert into medecin values('"+code+"','"+nom+"','"+prenom+"','"+adresse+"','"+localite+"','"+telephone+"','"+potentiel+"','"+specialite+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
	}

// Retour de tous les médecins de la BDD
	public static ArrayList<Medecin> retournerListe(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from medecin");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerListe()");
		}
		return collectionDesMedecins;
	}
	
}
