/*
 * Créé le 17 nov. 2014
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import gsb.modele.Offrir;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;

/**
 * @author Isabelle
 * 17 nov. 2014
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class JIFVisiteMaj extends JIFVisite  implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton rechercher; 
	private JButton modifier; 



	public JIFVisiteMaj() {
		super();

		rechercher = new JButton("Rechercher");
		pBoutons.add(rechercher);

		// déclaration des sources d'évènements
		rechercher.addActionListener(this);
		setTitle("Mise à Jour d'une Visite");

	}

	public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
		if (source == rechercher){

			String reference = JTreference.getText(); 
			JTreference.setEditable(false);
			JTdatevisite.setEditable(false);
			JTmatricule.setEditable(false);
			JTcodemed.setEditable(false);


			if (VisiteDao.rechercher(reference).getCommentaire()!=null) {
				modifier = new JButton("Modifier");
				pBoutons.add(modifier);        
				modifier.addActionListener(this);}

			afficherFormulaire(reference);
			remplirText(VisiteDao.rechercher(reference));

		}

		else if (source == modifier){
			Offrir offre1 = new Offrir (MedicamentDao.rechercher(JTmedOffre1.getText()), 
					VisiteDao.rechercher(JTreference.getText()), 
					Integer.parseInt(JTqteOffre1.getText()));

			Offrir offre2 = new Offrir (MedicamentDao.rechercher(JTmedOffre2.getText()), 
					VisiteDao.rechercher(JTreference.getText()), 
					Integer.parseInt(JTqteOffre2.getText()));

			modifierVisite(offre1, offre2);
		}
	} // fin actionPerformed

}
