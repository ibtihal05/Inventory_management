package gestion_stock_client;

public class Commandes {

	private int  Numcommande;
	private Client client ;
	private Produit produit;
	private double Montant ;
	private String Etat ;
	private Date date ;
	public static int cpt =0;
	
public Commandes( Client client, Produit produit,Date date, double montant, String etat) {
	    cpt++;
		Numcommande = cpt;
		this.client = client;
		this.produit = produit;
		this.date=date;
		Montant = montant;
		Etat = etat;
	}
	
	
public int getNumcommande() {
		return Numcommande;
	}
public void setNumcommande(int numcommande) {
		Numcommande = numcommande;
	}
public Client getClient() {
		return client;
	}
public void setClient(Client client) {
		this.client = client;
	}
public Produit getProduit() {
		return produit;
	}
public void setProduit(Produit produit) {
		this.produit = produit;
	}
public Date getDate() {
		return date;
	}
public void setDate( Date date) {
		this.date = date;
	}

public double getMontant() {
		return Montant;
	}
public void setMontant(double montant) {
		Montant = montant;
	}
public String getEtat() {
		return Etat;
	}
public void setEtat(String etat) {
		Etat = etat;
	}
	

	
	@Override
public String toString() {
		return "Commandes [Numcommande=" + Numcommande + ", client=" + client + ", produit=" + produit + ", Montant="
				+ Montant + ", Etat=" + Etat + ", date=" + date + "]";
	}


public void Affichecommande() {
		System.out.println(this.toString());
	}

}
