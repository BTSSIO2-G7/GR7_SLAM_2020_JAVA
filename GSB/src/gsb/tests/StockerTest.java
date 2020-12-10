package gsb.tests;


import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.utils.AffichageModele;

public class StockerTest {
	public static void main(String[] args) {
		
		Localite uneLocalite = new Localite("11302","Speb");
		Visiteur unVisiteur = new Visiteur("a131", "Villechalane", "Louis", "lvillachane", "jux7g", "8 rue des Charmes", uneLocalite , "2005-12-21 00:00:00", "SW", "SWISS");
		Medicament unMedicament = new Medicament("3MYC7", "TRIMYCINE", "Triamcinolone (acétonide) + Néomycine + Nystatine", "Ce médicament...', 'Ce médicament...", null , 0, "CRT", "Corticoïde, antibiotique et antifongique à  usage local");
		
		// Créer
		Stocker nouveauStockage = new Stocker(12,unVisiteur,unMedicament);
		AffichageModele.afficherStocker(nouveauStockage);
	}

}
