package gsb.tests.unit;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;
import gsb.utils.AffichageModele;
import junit.framework.TestCase;

class VisiteServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	final void testRechercherVisiteVide() {
		Visite uneVisite = VisiteService.rechercherVisite(null);
		AffichageModele.afficherVisite(uneVisite);
		}
	
	@Test
	final void testRechercherVisiteIncorrecte() {
		Visite uneVisite = VisiteService.rechercherVisite("eaeaeae");
		AffichageModele.afficherVisite(uneVisite);
		}
	
	@Test
	final void testRechercherVisiteCorrecte() {
		Visite uneVisite = VisiteService.rechercherVisite("v0001");
		AffichageModele.afficherVisite(uneVisite);
		}	
	
	@Test
	final void testCreerVisiteExistante() {
		Medecin unMedecin = MedecinDao.rechercher("m001");
		Visiteur unVisiteur = VisiteurDao.rechercher("a131");
		Visite nouvelleVisite = new Visite("v0001","2001", "", unVisiteur, unMedecin);
		VisiteDao.creer(nouvelleVisite);	
		}
	
	@Test
	final void testCreerVisiteManquant() {
		Medecin unMedecin = MedecinDao.rechercher("");
		Visiteur unVisiteur = VisiteurDao.rechercher("");
		Visite nouvelleVisite = new Visite("v776","2001", "", unVisiteur, unMedecin);
		VisiteDao.creer(nouvelleVisite);	
		}
	
	@Test
	final void testCreerVisiteCorrecte() {
		Medecin unMedecin = MedecinDao.rechercher("m001");
		Visiteur unVisiteur = VisiteurDao.rechercher("a131");
		Visite nouvelleVisite = new Visite("v777","2001", "", unVisiteur, unMedecin);
		VisiteDao.creer(nouvelleVisite);	
		}

	@Test
	final void testRechercherListeVide() {
		ArrayList <Visite> lesVisites = VisiteService.rechercherListe(null, null);
		AffichageModele.afficherVisite(lesVisites.get(0));
	}

	@Test
	final void testRechercherListeCorrecte() {
		ArrayList <Visite> lesVisites = VisiteService.rechercherListe("a131", "2001");
		AffichageModele.afficherVisite(lesVisites.get(0));
	}

}
