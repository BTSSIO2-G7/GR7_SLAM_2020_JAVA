package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	public static Medicament rechercherMedicament(String unDepotLegal){
		Medicament unMedicament = null;
		try{
		if (unDepotLegal==null) {
            throw new Exception("Donnée obligatoire : dépot légal");
        }
		else if (MedicamentDao.rechercher(unDepotLegal)==null) {
            throw new Exception("Médicament non existant");
        }
		unMedicament = MedicamentDao.rechercher(unDepotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
}
