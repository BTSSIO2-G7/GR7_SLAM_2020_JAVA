package gsb.tests;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class VisiteurDaoTest {
	public static void main(String[] args) {

	// Rechercher
	Visiteur unVisiteur = VisiteurDao.rechercher("a131");
	AffichageModele.afficherVisiteur(unVisiteur);
	
	// Créer
	Visiteur nouveauVisiteur = new Visiteur("z00",null, null, null, null, null, null, null, null, 0, null, null);
	VisiteurDao.creer(nouveauVisiteur);
	
	
	}
}
