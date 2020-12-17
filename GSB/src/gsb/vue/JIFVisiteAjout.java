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
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author Isabelle
 * 17 nov. 2014
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
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
        // déclaration des sources d'évènements
        ajouter.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajout d'une visite");
        
        // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {

            }
        });
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == ajouter){ // Quand on clique sur le bouton ajout, les informations sont soumises à la BDD
   			soumettreText();
   		}
 } // fin actionPerformed

}
