package gsb.tests;

import java.util.ArrayList;
import gsb.modele.*;
import gsb.modele.dao.*;
import gsb.utils.AffichageModele;

public class MedecinDaoTest {

	public static void main(String[] args) {

	// Rechercher
	Medecin unMedecin = MedecinDao.rechercher("m001");
	AffichageModele.afficherMedecin(unMedecin);
	
	// Créer
	Medecin nouveauMedecin = new Medecin("m999","Speb", null, null, null, null, null, null);
	MedecinDao.creer(nouveauMedecin);
	
	
	}
}
