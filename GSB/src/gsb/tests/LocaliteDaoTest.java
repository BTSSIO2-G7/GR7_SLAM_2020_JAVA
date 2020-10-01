package gsb.tests;

import java.util.ArrayList;
import gsb.modele.*;
import gsb.modele.dao.*;
import gsb.utils.AffichageModele;

public class LocaliteDaoTest {
	
	public static void main(String[] args) {
		
		// Rechercher
		Localite uneLocalite = LocaliteDao.rechercher("13012");
		AffichageModele.afficherLocalite(uneLocalite);
		
		// Créer
		Localite nouvelleLocalite = new Localite("11302","Speb");
		
		LocaliteDao.creer(nouvelleLocalite);
		
		// Lister
		ArrayList<Localite> colLocalites = new ArrayList<Localite>();
		colLocalites = LocaliteDao.retournerListe();
		AffichageModele.afficherLesLocalites(colLocalites);
	}
}
