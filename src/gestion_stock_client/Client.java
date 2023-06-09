package gestion_stock_client;

public class Client {
	private int Identifiant ;
	private String Nomclient;
	private String PrenomClient;
	private String Adresse ;
	
	

	public Client(String nomclient, String prenomClient,String adresse)
	{
		Identifiant =ListeClients.getClients().size();
		Nomclient = nomclient;
		PrenomClient = prenomClient;
		Adresse =adresse;
	}
	public String getNomclient() {
		return Nomclient;
	}
	public void setNomclient(String nomclient) {
		Nomclient = nomclient;
	}
	public String getPrenomClient() {
		return PrenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}
	
	public int getIdentifiant() {
		return Identifiant;
	}
	public void setIdentifiant(int identifiant) {
		Identifiant = identifiant;
	}
	
	
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	
	}
	
	
	public String toString() {
		return "Client [Identifiant=" + Identifiant + ", Nomclient=" + Nomclient + ", PrenomClient=" + PrenomClient
				+ ", Adresse=" + Adresse + "]";
	}


	
	public void afficheclient() {
		System.out.println(this.toString());
	}
	
	
	
	
	
	

}
