package gestion_stock_client;
import java.util.ArrayList;

public class ListeAchat {

	/*private ArrayList<Achat> ListeAchat=new ArrayList<>();
	
	public ArrayList<Achat> getListeAchat() {
		return ListeAchat;
	}

	public void setListeAchat(ArrayList<Achat> listeAchat) {
		ListeAchat = listeAchat;
	}*/
	
	static private ArrayList<Achat> achats=new ArrayList<>();
	
	
	static public ArrayList<Achat> getAchats() {
		return achats;
	}

	static public void setAchats(ArrayList<Achat> Achats) {
		achats = Achats;
	}
	
	static public int Nombreachat(String nomprduit)
	 {  
		for (int i=0;i<achats.size();i++)
		{
	      if ( achats.get(i).getNomproduit().equalsIgnoreCase(nomprduit))
	          {
	    	  return achats.get(i).getNbrachat();
	          }
		}
		return 0;
	  }

		static int searchAchatByName(String nom) {
			   int i=0;
			   while( i<achats.size() && !nom.equalsIgnoreCase(achats.get(i).getNomproduit()) )
			   {  i++;}
			   if(i>=achats.size()) {return -1;} //le produit n'existe pas dans la liste achat
			   else return i;
		   }

}
