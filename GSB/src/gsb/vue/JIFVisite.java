/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import gsb.service.MedecinService;
import gsb.service.VisiteurService;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFVisite extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;

	protected JTable table;
	protected String[][] data;


	protected JLabel JLreference;
	protected JLabel JLdatevisite;
	protected JLabel JLcommentaire;
	protected JLabel JLmatricule;
	protected JLabel JLcodemed;

	protected JTextField JTreference;
	protected JTextField JTdatevisite;
	protected JTextField JTcommentaire;
	protected JTextField JTmatricule;
	protected JTextField JTcodemed;
	
	protected JLabel JLmedOffre1;
	protected JLabel JLqteOffre1;
	protected JLabel JLmedOffre2;
	protected JLabel JLqteOffre2;

	protected JTextField JTmedOffre1;
	protected JTextField JTqteOffre1;
	protected JTextField JTmedOffre2;
	protected JTextField JTqteOffre2;

	public JIFVisite() {
		p = new JPanel();  // panneau principal de la fenêtre
		pBoutons = new JPanel();    // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9,2));

		JLreference = new JLabel("Référence");
		JLdatevisite = new JLabel("Date de la visite");
		JLcommentaire = new JLabel("Commentaire");
		JLmatricule = new JLabel("Matricule visiteur");
		JLcodemed = new JLabel("Code médecin");

		JTreference = new JTextField(20);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JTdatevisite = new JTextField();
		JTcommentaire = new JTextField();
		JTmatricule = new JTextField();    
		JTcodemed = new JTextField();

		pTexte.add(JLreference);
		pTexte.add(JTreference);
		pTexte.add(JLdatevisite);
		pTexte.add(JTdatevisite);
		pTexte.add(JLcommentaire);
		pTexte.add(JTcommentaire);
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		pTexte.add(JLcodemed);
		pTexte.add(JTcodemed);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void remplirText(Visite uneVisite) 	
	{  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
		JTreference.setText(uneVisite.getReference());        
		JTdatevisite.setText(uneVisite.getDate());
		JTcommentaire.setText(uneVisite.getCommentaire());
		JTmatricule.setText(uneVisite.getUnVisiteur().getMatricule());    
		JTcodemed.setText(uneVisite.getUnMedecin().getCodeMed());
	}

	public void viderText() 	
	{  // méthode qui permet de vider les zones de texte 
		JTreference.setText("");        
		JTdatevisite.setText("");
		JTcommentaire.setText("");
		JTmatricule.setText("");    
		JTcodemed.setText("");
	}

	public void soumettreText() 	
	{  // méthode qui permet d'envoyer une visite à la BDD
		String ref = JTreference.getText();
		String date = JTdatevisite.getText();
		String matricule = JTmatricule.getText(); 
		String code = JTcodemed.getText();

		Visiteur unVisiteur = VisiteurService.rechercherVisiteur(matricule);
		Medecin unMedecin = MedecinService.rechercherMedecin(code);
		Visite uneVisite = new Visite(ref, date, "", unVisiteur, unMedecin);

		VisiteDao.creer(uneVisite);
	}

	public void modifierVisite(Offrir offre1, Offrir offre2) 	
	{  // méthode qui permet de modifier l'état d'une visite et d'ajouter des offres
		String ref = JTreference.getText();
		String date = JTdatevisite.getText();
		String commentaire = JTcommentaire.getText();
		String matricule = JTmatricule.getText(); 
		String code = JTcodemed.getText();

		Visiteur unVisiteur = VisiteurService.rechercherVisiteur(matricule);
		Medecin unMedecin = MedecinService.rechercherMedecin(code);
		Visite uneVisite = new Visite(ref, date, commentaire, unVisiteur, unMedecin);

		OffrirDao.creer(offre1);
		OffrirDao.creer(offre2);


		VisiteDao.changerCommentaire(uneVisite, commentaire);

	}

	public void afficherFormulaire(String reference) {
		// Méthode permettant d'afficher un formulaire d'insertion de médicaments
		
		JLmedOffre1 = new JLabel("Médicament 1");
		JLqteOffre1 = new JLabel("Quantité offerte");
		JLmedOffre2 = new JLabel("Médicament 2");
		JLqteOffre2 = new JLabel("Quantité offerte");

		JTmedOffre1 = new JTextField();
		JTqteOffre1 = new JTextField();
		JTmedOffre2 = new JTextField();
		JTqteOffre2 = new JTextField();   
		
		pTexte.add(JLmedOffre1);		
		pTexte.add(JTmedOffre1);

		pTexte.add(JLqteOffre1);		
		pTexte.add(JTqteOffre1);

		pTexte.add(JLmedOffre2);		
		pTexte.add(JTmedOffre2);

		pTexte.add(JLqteOffre2);
		pTexte.add(JTqteOffre2);

		this.setTitle("Mise à Jour d'une Visite : " + reference);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}




}
