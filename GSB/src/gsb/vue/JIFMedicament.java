package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import gsb.modele.Medicament;
 

public class JIFMedicament extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected GridLayout pTexte1;
	protected JPanel pTexte2;
	protected JPanel pBoutons;
	protected JPanel pBoutonInfo;
	
	protected JLabel JLDepotLeg;
	protected JLabel JLNomCommer;
	protected JLabel JLCompo;
	protected JLabel JLEffets;
	protected JLabel JLContrIndi;
	protected JLabel JLdl;
	protected JLabel Jlqo;
	protected JLabel JLPrixEchant;
	protected JLabel JLCodeFam;
	protected JLabel JLLibellFam;
	
	protected JLabel JLvide;
	
	protected JTextField JTDepotLeg;
	protected JTextField JTNomCommer;
	protected JTextField JTCompo;
	protected JTextField JTEffets;
	protected JTextField JTContrIndi;
	protected JTextField JTPrixEchant;
	protected JTextField JTCodeFam;
	protected JTextField JTLibellFam; 
	   


	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        JPanel pTexte = new JPanel(new GridLayout(9,2));
    	
		JLDepotLeg = new JLabel("Référence");
		JLNomCommer = new JLabel("Nom commercial");
		JLCompo = new JLabel("Composition");
		JLEffets = new JLabel("Les effets");
		JLContrIndi = new JLabel("Contre indication");
		JLPrixEchant = new JLabel("Prix échantillon");
		JLCodeFam = new JLabel("Code famille");
		JLLibellFam =  new JLabel("Libellé famille");
		
		JTDepotLeg = new JTextField();
		JTDepotLeg.setMaximumSize(JTDepotLeg.getPreferredSize());
		JTNomCommer = new JTextField();
		JTCompo = new JTextField();
		JTEffets = new JTextField();
		JTContrIndi = new JTextField();
		JTPrixEchant = new JTextField();
		JTCodeFam = new JTextField();
		JTLibellFam = new JTextField();
         
		pTexte.add(JLDepotLeg);
		pTexte.add(JTDepotLeg);
		
		pTexte.add(JLNomCommer);
		pTexte.add(JTNomCommer);
		
		pTexte.add(JLCompo);
		pTexte.add(JTCompo);
		
		pTexte.add(JLEffets);
		pTexte.add(JTEffets);
		
		pTexte.add(JLContrIndi);
		pTexte.add(JTContrIndi);
		
		pTexte.add(JLPrixEchant);
		pTexte.add(JTPrixEchant);
		
		pTexte.add(JLCodeFam);
		pTexte.add(JTCodeFam);
		
		pTexte.add(JLLibellFam);
		pTexte.add(JTLibellFam);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}	
	public void remplirText(Medicament unMedic) {
		JTDepotLeg.setText(unMedic.getDepotLegal());
		JTNomCommer.setText(unMedic.getNomCommercial());
		JTCompo.setText(unMedic.getComposition());
		JTEffets.setText(unMedic.getEffets());
		JTContrIndi.setText(unMedic.getContreIndication());
		JTPrixEchant.setText(String.valueOf(unMedic.getPrixEchantillon()));
		JTCodeFam.setText(unMedic.getCodeFamille());
		JTLibellFam.setText(unMedic.getLibellefamille());
		
	}
	
	public void viderText() {
		JTDepotLeg.setText("");
		JTNomCommer.setText("");
		JTCompo.setText("");
		JTEffets.setText("");
		JTContrIndi.setText("");
		JTPrixEchant.setText("");
		JTCodeFam.setText("");
		JTLibellFam.setText("");
	}
}
