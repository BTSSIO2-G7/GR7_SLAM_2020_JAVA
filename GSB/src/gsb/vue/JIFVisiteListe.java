/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Visite;
import gsb.service.VisiteService;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFVisiteListe extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JDesktopPane desktopPane;


	protected JLabel JLmatricule;
	protected JLabel JLdatevisite;

	protected JTextField JTmatricule;
	protected JTextField JTdatevisite;
	protected JTextField JTreference;
	protected JInternalFrame myJInternalFrame;


	// Ce constructeur de classe permet d'afficher les informations nécessaires à la demande et l'affichage d'une liste de visites
	public JIFVisiteListe() {
		p = new JPanel();  // panneau principal de la fenêtre
		pBoutons = new JPanel();    // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9,2));

		JLmatricule = new JLabel("Matricule visiteur");
		JLdatevisite = new JLabel("Date de la visite");

		JTmatricule = new JTextField(20);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTdatevisite = new JTextField();
		JTreference = new JTextField(20);
		JTreference.setMaximumSize(JTreference.getPreferredSize());

		pTexte.add(JLdatevisite);
		pTexte.add(JTdatevisite);
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void afficherTableau(String matricule, String date) { // Affichage d'un tableau de visites
		ArrayList <Visite> lesVisites = VisiteService.rechercherListe(matricule, date);

		int nbLignes = lesVisites.size();

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getUnMedecin().getCodeMed();
			data[i][2] = uneVisite.getCommentaire();
			i++;
		}
		String[] columnNames = {"Référence", "Code medecin", "Commentaire"};
		JTable table = new JTable(data, columnNames);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 100));
		p.add(scroll);

		this.setTitle("Tableau des Visites");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		p.add(scroll);
	}



}
