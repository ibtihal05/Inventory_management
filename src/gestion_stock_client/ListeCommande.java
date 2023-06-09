package gestion_stock_client;

import java.util.Scanner;
import java.util.ArrayList;
import gestion_stock_client.Achat;
import gestion_stock_client.ListeAchat;
public class ListeCommande {
	 static Scanner scan = new Scanner(System.in);
	 static Scanner sc =new Scanner (System.in);
			
	     
  static ArrayList<Commandes> ListesCommandes =new ArrayList<Commandes>();     
	
	public ArrayList<Commandes> getListesCommande() {
		return ListesCommandes;
	}

 public void setListesCommande(ArrayList<Commandes> listesCommandes) {
		ListesCommandes=listesCommandes;
	}
		
     
		
	static public  Commandes Saisircommande() {
			
			System.out.println("le client :\n");
			Client client1 =ListeClients.saisirClient();
			System.out.println("donnez les produits ");
			Produit produit ;
			produit = ListeProduits.SaisirProduit();
			System.out.println("donnez la date/n"
					+"le Jour:");
			String jour =sc.next();
			System.out.println("Le mois:");
			String mois =sc.next();
			System.out.println("L'année:");
	    	int année =sc.nextInt();
		    Date date = new Date(jour,mois,année);
			System.out.println("Donnez le nombre L'etat de la commande");
			String Etat =sc.next();
			System.out.println("Donnez le montant");
			double montant =sc.nextDouble();
			
			Commandes Commande1=new Commandes(client1,produit,date,montant,Etat) ;
			
			
	          
			return Commande1;
			
			
		}
	     
   static public void ajoutCommande()
		{
	     Commandes c=Saisircommande(); 
		 if (! ListesCommandes.contains(c))
		{   ListesCommandes.add(c);
		    
		}else { System.out.println("la commande  existe déja");}
		}
   static public void supprimeCommande(int numCommande ) 
   {
	     Commandes c=ListesCommandes.get(numCommande);
	     
			 if(!ListesCommandes.contains(c)) {
				 
				System.out.println("la commande n'éxiste pas");
		 }else {
			 ListesCommandes.remove(c);
			 System.out.println("la commande supprimer est:"+c.toString());
		 }

		 }
			
		 
   static public void modifierCommande(int numcommande)
	 { for(int i=0;i<ListesCommandes.size();i++)
		 { 
		 if(ListesCommandes.get(i).getNumcommande()==numcommande)
		 {
			 Commandes c=Saisircommande();
			System.out.println("la commande a modifié est"+ListesCommandes.get(i));
			 
			ListesCommandes.get(i).setClient(c.getClient());
			ListesCommandes.get(i).setProduit(c.getProduit());
			ListesCommandes.get(i).setMontant(c.getMontant());
			ListesCommandes.get(i).setEtat(c.getEtat());
			
		   supprimeCommande(c.getNumcommande());
		 }
		 
          else
            {System.out.println("le produit n'est pas disponible");}
		 }
	 }
   
	static public void AfficherListeCommande() {
				for(int i=0;i<ListesCommandes.size();i++)
				{ System.out.println(ListesCommandes.get(i));
					
				}
			}
	
	static public ArrayList<Commandes> CreerListeCommandes()
    {
  	return ListesCommandes;
			}
	
	static public void Afficherlistedescommandessatisfaites() {
				 
				 for(int i=0;i<ListesCommandes.size();i++)
				 { if (ListesCommandes.get(i).getEtat().equalsIgnoreCase("Satisfaite"))
				 { System.out.println(ListesCommandes.get(i));
				 
				 }}
			 } 
	static public void AfficherCommandeReservé() {
					 for(int i=0;i<ListesCommandes.size();i++)
					 { if (ListesCommandes.get(i).getEtat().equalsIgnoreCase("Réservée"))
					 { System.out.println(ListesCommandes.get(i));
					 }
				 }
					 
				 }
		//pour afficher le nombre d'achats d'un produit donne
	static void  AfficherProduiLePlustCommercialisé() {

		int max=0;
		for(int i=0;i<ListeAchat.getAchats().size();i++)
		{if (ListeAchat.getAchats().get(max).getNbrachat()<ListeAchat.getAchats().get(i).getNbrachat()) {
			max=i;
		}
		System.out.println("le produit le plus commercialisé est"+ListeAchat.getAchats().get(max).getNomproduit());
		}
	}
		
	static void  AfficherProduitLeMoinsCommercialisé() 
	{      
		    int min=0;
			for(int i=0;i<ListeAchat.getAchats().size();i++)
			{
			if(ListeAchat.getAchats().get(min).getNbrachat()>ListeAchat.getAchats().get(i).getNbrachat()) {
				min=i;
				
			}
			  }
			System.out.println("le produit le moin commercialisé est"+ListeAchat.getAchats().get(min).getNomproduit());		
	
	}
	static void AfficherAchatsProduit()
	{
		System.out.println(" donnez le nom de produit : ");
		String nom=scan.next();
		int i=ListeAchat.Nombreachat(nom);
		System.out.println("le nombre d'achat de le produit "+nom+" = "+i);
	}
	// Achats d’un produit donné sur une période donnée, par ville 
	static void AfficherAchatsProduitParVille()
	{
		System.out.println(" donnez le nom de produit :\n");
		String nom=scan.next();
		System.out.println("donnez la ville : ");
		String ville=scan.next();
		int i=ListeAchat.Nombreachat(nom);
		System.out.println("le nombre d'achat de le produit "+nom+" dans la ville : "+ville+" = "+i);
	}
				 
	
	
	static void menu_gestion_des_commandes(){
		System.out.println("vous voules :\n 1-Créer une liste de commandes\n 2- Ajouter une commande\n 3-Supprimer une commande\n 4-Modifier une commande\n.5- Afficher la liste des commandes satisfaites\n 6-Afficher la liste des commandes en instance (réservées)\n 7-Afficher le produit le plus commercialisé\n 8- Afficher le produit le moins commercialisé sur une période donnée\n 9-Achats d’un produit donné\n 10-Achats d’un produit donné sur une période donnée,par ville\n 11-retour\n 12-Quitter");
		int choix=scan.nextInt();
		switch(choix) {
		case 1:
			ArrayList<Commandes> c=CreerListeCommandes();
			break;
		case 2:
			ajoutCommande();
			break;
		case 3:
			System.out.println("entrez le numero de commande :\n");
			choix=scan.nextInt();
			supprimeCommande(choix);
		case 4:
			System.out.println("entrez le numero de commande :\n");
			choix=scan.nextInt();
			modifierCommande(choix);
			break;
		case 5:
			Afficherlistedescommandessatisfaites();
			break;
		case 6:
			AfficherCommandeReservé();
			break;
		case 7:
			AfficherProduiLePlustCommercialisé(); //le produit le plus commercialise
			break;
		case 8:
			AfficherProduitLeMoinsCommercialisé(); //le produit le moins commercialise
			break;
		case 9:
			 AfficherAchatsProduit();
			break;
		case 10:
			 AfficherAchatsProduitParVille();
			break;
		case 11:
			MainClass.menu_gestion();
			break;
		case 12:
		    System.exit(0);
			break;
		default : menu_gestion_des_commandes();
		}
		menu_gestion_des_commandes();
	}
}
