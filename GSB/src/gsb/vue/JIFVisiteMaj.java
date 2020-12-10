/*
 * Cr�� le 17 nov. 2014
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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

        // d�claration des sources d'�v�nements
        rechercher.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Mise � Jour d'une Visite");
        
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
		if (source == rechercher){
	        
		    String reference = JTreference.getText(); 
		    
		    if (VisiteDao.rechercher(reference).getCommentaire()!=null) {
	        modifier = new JButton("Modifier");
	        pBoutons.add(modifier);        
	        modifier.addActionListener(this);}
		    
			afficherTableau();
   			remplirText(VisiteDao.rechercher(reference));
   			
   		}
		else if (source == modifier){
			System.out.println((String) table.getValueAt(0,1));
			Offrir offre1 = new Offrir (MedicamentDao.rechercher( 
					(String) table.getValueAt(0,1)), 
					VisiteDao.rechercher(JTreference.getText()), 
					Integer.parseInt((String) table.getValueAt(0,2)));
			
			Offrir offre2 = new Offrir (MedicamentDao.rechercher( 
					(String) table.getValueAt(1,1)), 
					VisiteDao.rechercher(JTreference.getText()), 
					0);
			
   			modifierVisite(offre1, offre2);
   		}
 } // fin actionPerformed

}
