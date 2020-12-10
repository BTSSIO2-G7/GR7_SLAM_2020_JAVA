package gsb.tests.dao;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class StockerStock {
	public static void main(String[] args) {
for (Visiteur unVisiteur : VisiteurDao.retournerListe()) {
	for (Medicament unMedicament : MedicamentDao.retournerListe()) {
		Stocker unStock = new Stocker (20, unVisiteur, unMedicament);
		StockerDao.creer(unStock);
	}
}
	}
}
