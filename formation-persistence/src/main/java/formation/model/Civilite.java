package formation.model;

public enum Civilite {
	M("Monsieur"), Mme("Madame"), Mlle("Mademoiselle");
	
	private String civilite;
	
	private Civilite(String civilite) {
		this.civilite = civilite;
	}
	
	public String getTitre() {
		return civilite;
	}
}
