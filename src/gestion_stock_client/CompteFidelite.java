package gestion_stock_client;
import gestion_stock_client.ListeProduits;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class CompteFidelite {
	static Scanner scan=new Scanner(System.in);

	String nom,prenom,adresse,password;
	int numCarte;
	double montansInformatique=0,montansElectronique=0,montansKits=0;
	double nmbrAchatInformatique=0,nmbrAchatElectronique=0,nmbrAchatKits=0;
	
	static ArrayList<CompteFidelite> ListeFidelite=new ArrayList<>();
	
	public CompteFidelite(String nom,String prenom,String adresse, String password)
	{
		this.nom=nom;
		this.prenom=prenom;
	    this.adresse=adresse;
		this.password=password;
		this.numCarte=CompteFidelite.ListeFidelite.size();
		
		
	}
	
	static void creer_nv_compte_fidelite()
	  {
		String nom,prenom,adresse,password;
		
		System.out.println("entrez nom de client \n");
		nom=scan.next();
		System.out.println("entrez prenom de client \n");
		prenom=scan.next();
		System.out.println("entrez adresse de client \n");
		adresse=scan.next();
		System.out.println("entrez mot de passe de client \n");
		password=scan.next();
		CompteFidelite c=new CompteFidelite(nom,prenom,adresse,password);
		ListeFidelite.add(c);
	 }
	
	static void afficherListeCompte()
	{ 
		System.out.println("liste des comptes fidelite :");
		for(CompteFidelite c : ListeFidelite )
	    {
			System.out.println("\n"+c); }
	}
	
	void updateMontonsNmbrAchat(int ref,int option)
	   {
		   String type=ListeProduits.getProduits().get(ref).getTypeProduit();
		   
		   switch(option) 
		   {
		   case 1: //vente
		   
		     if (type=="informatiques" || type=="mobiles") 
		        { this.montansInformatique+=ListeProduits.getProduits().get(ref).getPrixProduit();
		          this.nmbrAchatInformatique++;
		        }
		     else if(type=="electroniques" || type=="electromenager") 
		    	 {this.montansElectronique+=ListeProduits.getProduits().get(ref).getPrixProduit();
		    	  this.nmbrAchatElectronique++;
		    	 }
		     else 
		    	 {this.montansKits+=ListeProduits.getProduits().get(ref).getPrixProduit();
		    	  this.nmbrAchatKits++;
		    	 }
		   break;
		   case 2: //retours
			  if(type=="informatiques" || type=="mobiles") 
			  {
				  montansInformatique-=ListeProduits.getProduits().get(ref).getPrixProduit();
			      this.nmbrAchatInformatique--;
			  }
			  else if(type=="electroniques" || type=="electroménager")
			  {
				  montansElectronique-=ListeProduits.getProduits().get(ref).getPrixProduit();
			     this.nmbrAchatElectronique--;
		      }
			  else {
				  montansKits+=ListeProduits.getProduits().get(ref).getPrixProduit();
				  this.nmbrAchatKits--;
			  }
		   break;
		  
		   }
			   
       }
	 
	  double remise(int ref)
	 {
		  double remise;
		  String type=ListeProduits.getProduits().get(ref).getTypeProduit();
	       //le client va utiliser le remise
		   if (type=="informatiques" || type=="mobiles") 
	        { 
			   remise =this.montansInformatique*0.05;
	           this.montansInformatique=0;
	        }
	     else if(type=="electroniques" || type=="electroménager") 
	    	 {
	    	 remise=this.montansElectronique*0.1;
	    	 this.montansElectronique=0;
	    	 }
	     else 
	    	 {
	    	 remise=this.montansKits*0.15;
	    	 this.montansKits=0;
	    	 }
    return remise;
	 }
	 
	 void consulterCompteFidelite()
	 {
	   String passwordUser;
	   
	 System.out.println("veuillez entrer votre mot de pass");
	 passwordUser=scan.next();
	 if(passwordUser.equalsIgnoreCase(this.password)) //verifier le mot de passe
	   {   
		 //affichage de les informations de client 
		 System.out.println(" nom:"+this.nom+"\n prenom:"+this.prenom+" \n adresse:"+this.adresse);
		 
		 // informations sur les montants d’achats , les remises et le nombre de produits achetés
		 System.out.println("produits informatiques et mobiles: \n votre montants ="+this.montansInformatique+" DA \n le remise="+this.montansInformatique*0.05+" DA\n le nombre de produits que vous avez achete est :"+this.nmbrAchatInformatique+"DA \n");
		 System.out.println("produits électronique et électroménager: \n votre montants ="+this.montansElectronique+" DA le remise="+this.montansElectronique*0.1+" DA\n le nombre de produits que vous avez achete est : "+this.nmbrAchatElectronique+"DA \n");
		 System.out.println("Kits solaires: \n votre montants ="+this.montansKits+"DA \n le remise="+this.montansKits*0.15+" DA\n le nombre de produits que vous avez achete est : "+this.nmbrAchatKits+"DA \n");
		
	   }
	 else {
		 System.out.println("incorrect password,veuillez reessayer !");
		 this.consulterCompteFidelite();
	       }
	 MainClass.menu_client();
	 }

}
