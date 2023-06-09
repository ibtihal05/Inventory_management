package gestion_stock_client;

public class Achat {

	private int nbrachat;
    private String nomproduit;

    
    public Achat(String nomproduit) {
		    this.nomproduit = nomproduit;
		    this.nbrachat=0;
	}
	public int getNbrachat() {
		return nbrachat;
	}
	public void setNbrachat(int nbrachat) {
		this.nbrachat = nbrachat;
	}
	public String getNomproduit() {
		return nomproduit;
	}
	public void setNomproduit(String nomproduit) {
		this.nomproduit = nomproduit;
	}
	
	public int nombreachat(String nomproduitdonner) {
		if(nomproduit.equalsIgnoreCase(nomproduitdonner))
		{ nbrachat++;}
		return nbrachat;  
			
		}
}
