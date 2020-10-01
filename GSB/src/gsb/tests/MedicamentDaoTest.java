package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.utils.AffichageModele;

public class MedicamentDaoTest {

	public static void main(String[] args) {

	// Rechercher
	Medicament unMedicament = MedicamentDao.rechercher("BACTIG10");
	AffichageModele.afficherMedicament(unMedicament);
	
	// Créer
	Medicament nouveauMedicament = new Medicament("SPOVID",null, null, null, null, 0, null, null);
	MedicamentDao.creer(nouveauMedicament);
	
	
	}
}
