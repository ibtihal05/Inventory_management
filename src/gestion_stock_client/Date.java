package gestion_stock_client;

public class Date {
	private int Ann�e;
	private String Mois ;
	private String Jour;
	
		
		
		
		
		public Date(String jour, String mois, int ann�e) {
			
			Jour = jour;
			Mois = mois;
			Ann�e = ann�e;
		}
		
	



    public int getAnn�e() {
	return Ann�e;}
	public void setAnn�e(int ann�e) {
		Ann�e = ann�e;
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
	
	
	public void lireDate(String jour, String mois, int ann�e) {
		Jour=jour;
		Mois=mois;
		Ann�e=ann�e;
	}





	@Override
	public String toString() {
		return "Date [Ann�e=" + Ann�e + ", Mois=" + Mois + ", Jour=" + Jour + "]";
	}
	
	
	public void afficheDate () {
		System.out.println(this.toString());
	}
}
