package gsb.tests.dao;


import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import gsb.utils.AffichageModele;

public class OffrirDaoTest {
	
	public static void main(String[] args) {
		
		

		// Créer
		Medicament unMedicament = MedicamentDao.rechercher("ADIMOL9");
		Visite uneVisite = VisiteDao.rechercher("v0002");
		System.out.println(uneVisite.getUnVisiteur());
		Offrir nouvelleOffre = new Offrir(unMedicament,uneVisite, 6);
		OffrirDao.creer(nouvelleOffre);
		
		// Rechercher
		Offrir uneOffre = OffrirDao.rechercher("3MYC7", "v0001");
		AffichageModele.afficherOffre(uneOffre);
		
	}

}
