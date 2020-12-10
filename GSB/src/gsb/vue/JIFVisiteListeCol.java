/*
 * Cr�� le 17 nov. 2014
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author Isabelle
 * 17 nov. 2014
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFVisiteListeCol extends JIFVisiteListe  implements ActionListener {
	
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton rechercher;
	private JButton visite;
	private JPanel pSaisie;
	protected MenuPrincipal fenetreContainer;

        
    public JIFVisiteListeCol(MenuPrincipal uneFenetreContainer) {
        super();
		fenetreContainer = uneFenetreContainer;

        rechercher = new JButton("Rechercher"); // Bouton de recherche de la visite
        pBoutons.add(rechercher);
        // d�claration des sources d'�v�nements
        rechercher.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Liste des Visites");
        
        // ajout d'un �couteur d'�v�nement pour la fermeture de la fen�tre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux ex�cuter � la fermeture de la JInternalFrame
            }
        });
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == rechercher){
   				
   				// Quand on clique sur rechercher, on affiche le tableau des visites
				String matricule = JTmatricule.getText();
				String date = JTdatevisite.getText();
				afficherTableau(matricule, date);
						
				// On cr�e aussi une zone de recherche pour obtenir une visite d�taill�e
				pSaisie = new JPanel();
				visite = new JButton("Visite d�taill�e");
				visite.addActionListener(this);
				pSaisie.add(JTreference);
				pSaisie.add(visite);
				p.add(pSaisie);
				
				Container contentPane = getContentPane();
				contentPane.add(p);
				}
   		else if (source == visite){ // Quand on clique sur visite d�taill�e, une nouvelle page s'ouvre avec la visite pass�e en param�tre
   			Visite uneVisite = VisiteDao.rechercher(JTreference.getText());
   			fenetreContainer.ouvrirFenetre(new JIFVisiteFiche(uneVisite));
   		}
				

 } // fin actionPerformed

}
