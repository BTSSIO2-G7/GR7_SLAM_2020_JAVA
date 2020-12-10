package gsb.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Visiteur;
import gsb.service.VisiteurService;
import gsb.utils.AffichageModele;
import junit.framework.TestCase;

class VisiteurServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	final void testRechercherVisiteurVide() {
		Visiteur unVisiteur = VisiteurService.rechercherVisiteur(null);
		AffichageModele.afficherVisiteur(unVisiteur);
	}

	@Test
	final void testRechercherVisiteurIncorrect() {
		Visiteur unVisiteur = VisiteurService.rechercherVisiteur("aeaeaeae");
		AffichageModele.afficherVisiteur(unVisiteur);
	}

	@Test
	final void testRechercherVisiteurCorrect() {
		Visiteur unVisiteur = VisiteurService.rechercherVisiteur("a131");
		AffichageModele.afficherVisiteur(unVisiteur);
	}
	
}
