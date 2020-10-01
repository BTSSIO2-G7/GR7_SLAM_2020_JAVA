package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.utils.AffichageModele;

public class VisiteDaoTest {
	public static void main(String[] args) {

	// Rechercher
	Visite uneVisite = VisiteDao.rechercher("v0001");
	AffichageModele.afficherVisite(uneVisite);
	
	// Créer
	Visite nouvelleVisite = new Visite("v9999",null, null, null, null);
	VisiteDao.creer(nouvelleVisite);
	
	
	}
}
