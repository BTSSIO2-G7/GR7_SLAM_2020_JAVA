package gsb.tests;


import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.utils.AffichageModele;

public class OffrirTest {
	public static void main(String[] args) {
		
		Medicament unMedicament = new Medicament("3MYC7", "TRIMYCINE", "Triamcinolone (acétonide) + Néomycine + Nystatine", "Ce médicament...', 'Ce médicament...", null , 0, "CRT", "Corticoïde, antibiotique et antifongique à  usage local");
		Visite uneVisite = null;
		// Créer
		Offrir nouvelleOffre = new Offrir(unMedicament,uneVisite,12);
		AffichageModele.afficherOffrir(nouvelleOffre);
	}

}
