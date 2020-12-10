/*
 * Créé le 17 nov. 2014
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
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
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
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
        // déclaration des sources d'évènements
        rechercher.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Liste des Visites");
        
        // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux exécuter à la fermeture de la JInternalFrame
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
						
				// On crée aussi une zone de recherche pour obtenir une visite détaillée
				pSaisie = new JPanel();
				visite = new JButton("Visite détaillée");
				visite.addActionListener(this);
				pSaisie.add(JTreference);
				pSaisie.add(visite);
				p.add(pSaisie);
				
				Container contentPane = getContentPane();
				contentPane.add(p);
				}
   		else if (source == visite){ // Quand on clique sur visite détaillée, une nouvelle page s'ouvre avec la visite passée en paramètre
   			Visite uneVisite = VisiteDao.rechercher(JTreference.getText());
   			fenetreContainer.ouvrirFenetre(new JIFVisiteFiche(uneVisite));
   		}
				

 } // fin actionPerformed

}
