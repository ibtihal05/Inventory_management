package gestion_stock_client;

public class Date {
	private int Année;
	private String Mois ;
	private String Jour;
	
		
		
		
		
		public Date(String jour, String mois, int année) {
			
			Jour = jour;
			Mois = mois;
			Année = année;
		}
		
	



    public int getAnnée() {
	return Année;}
	public void setAnnée(int année) {
		Année = année;
	}
	public String getMois() {
		return Mois;
	}
	public void setMois(String mois) {
		Mois = mois;
	}
	public String getJour() {
		return Jour;
	}
	public void setJour(String jour) {
		Jour = jour;
	}
	
	
	public void lireDate(String jour, String mois, int année) {
		Jour=jour;
		Mois=mois;
		Année=année;
	}





	@Override
	public String toString() {
		return "Date [Année=" + Année + ", Mois=" + Mois + ", Jour=" + Jour + "]";
	}
	
	
	public void afficheDate () {
		System.out.println(this.toString());
	}
}
