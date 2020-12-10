package gsb.tests.dao;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class VisiteDaoTest {
	public static void main(String[] args) {

	// Rechercher
	Visite uneVisite = VisiteDao.rechercher("v0001");
	AffichageModele.afficherVisite(uneVisite);
	

	// Créer	
	Medecin unMedecin = MedecinDao.rechercher("m001");
	Visiteur unVisiteur = VisiteurDao.rechercher("a131");
	Visite nouvelleVisite = new Visite("v999","2001", "", unVisiteur, unMedecin);
	VisiteDao.creer(nouvelleVisite);
	
	
	}
}
