package gsb.tests;


import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.utils.AffichageModele;

public class VisiteurTest {
	public static void main(String[] args) {
		
		// Créer
		Localite nouvelleLocalite = new Localite("11302","Speb");
		Visiteur nouveauVisiteur = new Visiteur("a131", "Villechalane", "Louis", "lvillachane", "jux7g", "8 rue des Charmes",nouvelleLocalite, "2005-12-21 00:00:00", "SW", "SWISS");
		AffichageModele.afficherVisiteur(nouveauVisiteur);
	}

}
