package gestion_stock_client;

import java.util.Scanner;
import java.util.ArrayList;


public class ListeProduits {
	static Scanner sc =new Scanner(System.in);
	
	static private  ArrayList<Produit> Produits=new ArrayList<>();

	static public ArrayList<Produit> getProduits() {
				return Produits;
			}

	static public void setProduits(ArrayList<Produit> produits) {
				Produits = produits;
			}
		
	static public ArrayList<Produit> CréerListeProduit(){
		System.out.println(" la liste ete cree ");
				return Produits;
			}
			
	public static Produit SaisirProduit()
	{
	
				System.out.println("donner le nom de produit");
				String nomproduit = sc.next();
				System.out.println("donnez le prix de produit");
				double prix =sc.nextDouble();
				System.out.println("donner le descriptif de produit");
				String descriptif =sc.next();
				System.out.println("donner le type de produit");
				String Type=sc.next();
				System.out.println("donnez les caracteristique de produit");
				String caracteristique=sc.next();
				
				Produit Produit1 =new Produit(nomproduit,descriptif,prix,Type,caracteristique);
			 
				return Produit1;
			}
		   

	static public void ajoutProduit( )
			{
		     Produit p=SaisirProduit();
			 if (!Produits.contains(p)) {
			   Produits.add(p);
			System.out.println("le produit ete ajoute \n\n\n");
			if( ListeAchat.searchAchatByName(p.getNomProduit())==-1) //nouveau produit, il n'existe pas dans liste achat donc on doit l'ajouter pour avoir son nombre dachat
			 {
				 Achat a=new Achat(p.getNomProduit());
				 ListeAchat.getAchats().add(a);
			 }  
			}
			 else { System.out.println("produit existe déja");}
		
			}
			
	static public void supprimeProduit(int numproduit){
				Produit p=Produits.get(numproduit);
				 if(!Produits.contains(p)) {
					 
					System.out.println("le produit n'éxiste pas\n\n");
			 }else {
				 Produits.remove(p);
				 System.out.println("le produit supprimer est:"+p.toString()+"\n\n");
			 }

			 }
				
			 
	 static public void modifierProduit(int numproduit)
	    { 
		    for(int i=0;i<Produits.size();i++)
			 { 
		    	if(Produits.get(i).getNumproduit()== numproduit)
			   { 
				 Produit p=SaisirProduit();
				 System.out.println("le produit a modifié est"+Produits.get(i));
				 
			   Produits.get(i).setNomProduit(p.getNomProduit());
			   Produits.get(i).setDescriptif(p.getDescriptif());
			   Produits.get(i).setPrixProduit(p.getPrixProduit());
			   Produits.get(i).setTypeProduit(p.getTypeProduit());
			   Produits.get(i).setCaracteristique(p.getCaracteristique());
			   supprimeProduit(p.getNumproduit());
			     }
			 }
		    System.out.println(" le produit ete modifie ");
	    }
			
	 static public void afficherListeProduit() {
					for(int i=0;i<Produits.size();i++)
					{ System.out.println(Produits.get(i)); }
				menu_gestion_des_produits();		
				}
	 static public void afficherListeProduitPourClient() {
			for(int i=0;i<Produits.size();i++)
			{ System.out.println(Produits.get(i)); }
				MainClass.menu_client();
		}
			 
	
	static void menu_gestion_des_produits(){
		 Scanner scan = new Scanner(System.in);
			 int choix;
		System.out.println("vous voules :\n 1-Créer une liste de produits\n 2-Ajouter produit\n 3-Supprimer produit\n 4-Modifier produit\n 5-Afficher la liste Produit par type de produit\n 6-retour\n 7-Quitter\n");
		choix=scan.nextInt();
		switch(choix) {
		case 1:
			CréerListeProduit();
			break;
		case 2:
			ajoutProduit();
			break;
		case 3:
			System.out.println("entrez le numero de produit :\n");
			choix=scan.nextInt();
			supprimeProduit(choix);
		case 4:
			System.out.println("entrez le numero de produit :\n");
			choix=scan.nextInt();
			modifierProduit(choix);
			break;
		case 5:
			 afficherListeProduit();
			break;
		case 6:
			 MainClass.menu_gestion();
			break;
		case 7:
			System.exit(0);
			break;
		default : menu_gestion_des_produits();
		}
      menu_gestion_des_produits();
	}
	
	static int searchProduitByName(String nom) {//si on a le nom du produit et on veut avoir son indice dans ListeProduits
		   int i=0;
		   while( !nom.equalsIgnoreCase(Produits.get(i).getNomProduit()) && i<Produits.size()) i++;
		  
		   if(i<Produits.size()) return i; //lindice de produit
		   else return -1; //le produit n'existe pas
	   }
		
}
