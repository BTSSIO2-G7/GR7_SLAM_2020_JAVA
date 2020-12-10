package gsb.tests.dao;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.AffichageModele;

public class VisiteurDaoTest {
	public static void main(String[] args) {

	// Rechercher
	Visiteur unVisiteur = VisiteurDao.rechercher("a131");
	AffichageModele.afficherVisiteur(unVisiteur);
	
	Localite uneLocalite = LocaliteDao.rechercher("11302");
	// Créer
	Visiteur nouveauVisiteur = new Visiteur("z10","Spib", "Spab", "spabin", "spabbert", "spabville", uneLocalite , "2002", "BO", "BOUNCER");
	VisiteurDao.creer(nouveauVisiteur);
	
	
	}
}
