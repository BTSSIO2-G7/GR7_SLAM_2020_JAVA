package gsb.tests;


import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.utils.AffichageModele;

public class OffrirTest {
	public static void main(String[] args) {
		
		Medicament unMedicament = new Medicament("3MYC7", "TRIMYCINE", "Triamcinolone (ac�tonide) + N�omycine + Nystatine", "Ce m�dicament...', 'Ce m�dicament...", null , 0, "CRT", "Cortico�de, antibiotique et antifongique � usage local");
		Visite uneVisite = null;
		// Cr�er
		Offrir nouvelleOffre = new Offrir(unMedicament,uneVisite,12);
		AffichageModele.afficherOffrir(nouvelleOffre);
	}

}
