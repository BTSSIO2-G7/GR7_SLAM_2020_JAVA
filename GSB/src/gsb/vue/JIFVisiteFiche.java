package gsb.vue;


import javax.swing.JFrame;

import gsb.modele.Visite;

public class JIFVisiteFiche extends JIFVisite {

	private static final long serialVersionUID = 1L;

	public JIFVisiteFiche(Visite uneVisite) {
		super();
		remplirText(uneVisite); // Remplissage d'une fiche avec les informations d'une visite
		
		this.setTitle("Fiche de Visite");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
	


}
