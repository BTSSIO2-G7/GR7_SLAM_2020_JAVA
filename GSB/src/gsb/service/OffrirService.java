package gsb.service;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;

public class OffrirService {
	public static Offrir rechercherOffrir(String unDepotLegal, String uneReference){
		Offrir uneOffre = null;
		try{
		if (unDepotLegal==null || uneReference==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		uneOffre = OffrirDao.rechercher(unDepotLegal, uneReference);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneOffre;
	}
}
