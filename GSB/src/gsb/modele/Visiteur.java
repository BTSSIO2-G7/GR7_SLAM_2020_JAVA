package gsb.modele;

public class Visiteur {

	protected  String  matricule;
	protected  String  nom;
	protected  String  prenom;
	protected  String  login;
	protected  String  mdp;
	protected  String  adresse;
	protected  Localite  laLocalite;
	protected  String  dateEntree;
	protected  String  codeUnite;
	protected  String  nomUnite;
	
	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse, Localite uneLocalite,
			 String dateEntree, String codeUnite, String nomUnite) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.laLocalite = uneLocalite;
		this.dateEntree = dateEntree;
		this.codeUnite = codeUnite;
		this.nomUnite = nomUnite;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Localite getLaLocalite() {
		return laLocalite;
	}

	public void setLaLocalite(Localite laLocalite) {
		this.laLocalite = laLocalite;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}


	public String getCodeUnite() {
		return codeUnite;
	}

	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}

	public String getNomUnite() {
		return nomUnite;
	}

	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}
	
	
}
