package gsb.utils;

import java.util.ArrayList;

import gsb.modele.*;

public class AffichageModele {
	

	public static void afficherLocalite(Localite uneLocalite) {
		System.out.println("Localité :"+uneLocalite.getVille());
	}
	
	public static void afficherLesLocalites(ArrayList<Localite> lesLocalites) {
		for(Localite uneLocalite : lesLocalites){
			System.out.println("Localité :"+uneLocalite.getVille());
		}
	}
	
	public static void afficherMedecin(Medecin unMedecin) {
		System.out.println("Nom du médecin :"+unMedecin.getNom());
	}
	
	public static void afficherMedicament(Medicament unMedicament) {
		System.out.println("Médicament :"+unMedicament.getNomCommercial());
	}
	
	public static void afficherOffrir(Offrir uneOffre) {
		System.out.println("Quantité offerte :"+uneOffre.getQteOfferte());
	}
	
	public static void afficherStocker(Stocker unStock) {
		System.out.println("Stock :"+unStock.getQteStock());
	}
	
	public static void afficherVisite(Visite uneVisite) {
		System.out.println("Référence visite :"+uneVisite.getReference());
		System.out.println("Visiteur :"+uneVisite.getUnVisiteur().getMatricule());
		System.out.println("Medecin :"+uneVisite.getUnMedecin().getCodeMed());
	}
	
	public static void afficherVisiteur(Visiteur unVisiteur) {
		System.out.println("Nom du visiteur :"+unVisiteur.getNom());
	}

	public static void afficherOffre(Offrir uneOffre) {
		System.out.println("Quantité offerte :"+uneOffre.getQteOfferte());
		
	}

}
