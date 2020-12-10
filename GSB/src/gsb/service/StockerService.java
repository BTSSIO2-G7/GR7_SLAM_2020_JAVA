package gsb.service;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class StockerService {
	public static Stocker rechercherStocker(String unDepotLegal, String unMatricule){

	Stocker unStock = null;
	try{
	if (unDepotLegal==null || unMatricule==null) {
        throw new Exception("Donnée obligatoire : code");
    }
	unStock = StockerDao.rechercher(unDepotLegal, unMatricule);
	}
	catch(Exception e){
		System.out.println( e.getMessage());
	}
	return unStock;
}
}
