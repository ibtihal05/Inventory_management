package gestion_stock_client;

public class Produit {

	static int cpt=0;
	private int numproduit ;
	private  String NomProduit;
	private  String Descriptif ;
	private double PrixProduit ;
	String typeProduit ;
	private String caracteristique;
	
	
	
	
	public Produit( String nomProduit, String descriptif, double prixProduit, String typeProduit, String caracteristique) {
		cpt++;
		this.numproduit = cpt;
		NomProduit = nomProduit;
		Descriptif = descriptif;
		PrixProduit = prixProduit;
		this.typeProduit = typeProduit;
		this.caracteristique = caracteristique;
		
	}
	
	
	public int getNumproduit() {
		return numproduit;
	}



	public void setNumproduit(int numproduit) {
		this.numproduit = numproduit;
	}



	public String getNomProduit() {
		return NomProduit;
	}



	public void setNomProduit(String nomProduit) {
		NomProduit = nomProduit;
	}



	public String getDescriptif() {
		return Descriptif;
	}



	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}



	public double getPrixProduit() {
		return PrixProduit;
	}



	public void setPrixProduit(double prixProduit) {
		PrixProduit = prixProduit;
	}



	public String getTypeProduit() {
		return typeProduit;
	}



	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	@Override
	public String toString() {
		return "Produit [numproduit=" + numproduit + ", NomProduit=" + NomProduit 
				+ ", Descriptif=" + Descriptif + ", PrixProduit=" + PrixProduit + ", typeProduit=" + typeProduit
				+ ", caracteristique=" + caracteristique + "]";
	}


	public String getCaracteristique() {
		return caracteristique;
	}



	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	public void affiche () {
		System.out.println(this.toString());
	}



}
