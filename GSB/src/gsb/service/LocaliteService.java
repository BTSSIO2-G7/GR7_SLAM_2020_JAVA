package gsb.service;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteService {
	public static Localite rechercherLocalite(String unCodePostal){
		Localite uneLocalite = null;
		try{
		if (unCodePostal==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		uneLocalite = LocaliteDao.rechercher(unCodePostal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneLocalite;
	}
}
