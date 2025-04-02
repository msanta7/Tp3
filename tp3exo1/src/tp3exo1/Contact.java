package tp3exo1;

public class Contact {
	String nom,prenom;
	String numTel;
	String type;
	
	public Contact(String nom,String prenom,String numTel,String type)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.numTel=numTel;
		this.type=type;
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

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + ", type=" + type + "]";
	}

}
