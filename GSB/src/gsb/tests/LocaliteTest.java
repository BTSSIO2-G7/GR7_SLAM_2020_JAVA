package gsb.tests;


import gsb.modele.Localite;
import gsb.utils.AffichageModele;

public class LocaliteTest {
	public static void main(String[] args) {
		
		// Créer
		Localite nouvelleLocalite = new Localite("11302","Speb");
		AffichageModele.afficherLocalite(nouvelleLocalite);
	}

}
