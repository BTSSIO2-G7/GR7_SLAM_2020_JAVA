package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	public static Medicament rechercherMedicament(String unDepotLegal){
		Medicament unMedicament = null;
		try{
		if (unDepotLegal==null) {
            throw new Exception("Donn�e obligatoire : d�pot l�gal");
        }
		else if (MedicamentDao.rechercher(unDepotLegal)==null) {
            throw new Exception("M�dicament non existant");
        }
		unMedicament = MedicamentDao.rechercher(unDepotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
}
