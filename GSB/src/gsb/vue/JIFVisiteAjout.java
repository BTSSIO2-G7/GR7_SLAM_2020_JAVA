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
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author Isabelle
 * 17 nov. 2014
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFVisiteAjout extends JIFVisite  implements ActionListener {
	
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton ajouter; 
        
    public JIFVisiteAjout() {
        super();
        JTcommentaire.setEditable(false);
        ajouter = new JButton("Ajouter"); // Ajout d'un bouton d'ajout
        pBoutons.add(ajouter);
        // d�claration des sources d'�v�nements
        ajouter.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout d'une visite");
        
        // ajout d'un �couteur d'�v�nement pour la fermeture de la fen�tre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {

            }
        });
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == ajouter){ // Quand on clique sur le bouton ajout, les informations sont soumises � la BDD
   			soumettreText();
   		}
 } // fin actionPerformed

}
