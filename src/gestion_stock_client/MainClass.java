package gestion_stock_client;

import java.util.Scanner;

public class MainClass {
	static Scanner scan = new Scanner(System.in);
	static int choix;
	
	public static void main(String[] args){
		System.out.println("\n***************************************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t\tSOCIETE A3marDarek ELECTRONICS,BIENVENUE! ");
		System.out.println("***************************************************************************************************************************************************************");
        int quitter=0;
        //l'utilisateur est soit un responsable comercial ou bien un client
		do {
		System.out.println("vous etes un : \n 1-responsable comercial! \n 2-client!");
		choix=scan.nextInt();
		
		switch(choix)
		{
		case 1:
			 final String correctPassword = "0000"; //que le responsable comerciel peut acceder a cette option
		     String password;
		     System.out.println("veuillez entrer le mot de passe :");
		     password=scan.next();
		    while(!correctPassword.equalsIgnoreCase(password)) // on verifie le mot de passe
		    { 
			System.out.println("incorrect password,veuillez reessayer !");
			 password=scan.next();
		    }
		    menu_responsable();
		  break;
		case 2:
			menu_client();
		  break;
		default: System.out.println("vous devez choisir choix 1 ou choix 2 !");
		         System.exit(0);
		}
		System.out.println("si vous voullez quitter entrez 1");
		quitter=scan.nextInt();
		
       }while(quitter!=1);
	}
	
	static void menu_responsable(){

	  {	
	 System.out.println("vous vouler aller à :\n 1-la gestion \n 2-vente \n 3-retours \n 4-creer un compte fidelite\n 5-verifie menu de client\n 6-quitter");
	 choix=scan.nextInt();
	  switch(choix) {
		case 1:
			menu_gestion();
			break;
		case 2:
			vente();
			break;
		case 3:
			retours();
			break;
		case 4:
			CompteFidelite.creer_nv_compte_fidelite();
			break;
		case 5:
			menu_client();
			break;
		case 6:
			System.exit(0);
			break;
		
		default: System.out.println("vous devez choisir 1,2,3,4 ou 5 !");
		       menu_responsable();
	      }
	  }
	
	 }
	
	 static void menu_gestion() {
		 
		System.out.println(" choisez :\n 1-Gestion des produits\n 2-Gestion des clients\n 3-Gestion des commandes\n 4-Reourner\n 5-Quitter ");
		choix=scan.nextInt();
		
		switch(choix) {
		case 1:
			ListeProduits.menu_gestion_des_produits();
			break;
		case 2:
			ListeClients.menu_gestion_des_clients();
			break;
		case 3:
			ListeCommande.menu_gestion_des_commandes();
			break;
		case 4:
			menu_responsable();
		    break;
		case 5:
			System.exit(0);
			break;
	
		default: System.out.println("vous devez choisir 1,2,3 ou 4!");
		         menu_gestion();
		}
		
	}
	 
		static void vente(){
			int i,ref,clientFidele;
			double prixTotal=0;
			
			System.out.println("Avais le client  une carte de fidelite ? \n -tapez 1 si oui!\n -tapez 2 si non! \n");
			clientFidele=scan.nextInt();
			
			System.out.println("saisez le reference du produit\n");
			ref=scan.nextInt();
			
			while(ref!=-1)
			{
				//on ajout le prix de produit a le prix total :
			    prixTotal+=ListeProduits.getProduits().get(ref).getPrixProduit();
			    
			    // on incremente le nombreDachats:
			    i=ListeAchat.searchAchatByName(ListeProduits.getProduits().get(ref).getNomProduit());
			    ListeAchat.getAchats().get(i).setNbrachat((ListeAchat.getAchats().get(i).getNbrachat())+1);
			  
			    if(clientFidele==1)
			    {
			    	System.out.println("entrez le numero de la carte fidelite du client");
			    	i=scan.nextInt();
			    	//si le client a une compte fidelite on fait un update a son compte :
			    	CompteFidelite.ListeFidelite.get(i).updateMontonsNmbrAchat(ref,1);
			    	//et on pose a lui d'utiliser le remise:
			    	System.out.println("est ce que le client veut utiliser le remise ? \n -tapez 1 si oui! \n tapez 2 si non! \n");
			    	//on utilise le variable compteFidele pour avoir son avis:
			    	clientFidele=scan.nextInt(); 
			    	if(clientFidele==1) //le client a entre 1 donc il veut utiliser le remise
			    	{
			    	prixTotal-=CompteFidelite.ListeFidelite.get(i).remise(ref);
			    	}
			    }
			    
			    //et a la fin on supprime le produit achete
			    ListeProduits.supprimeProduit(i);
			    
			    //avoir s'il y a encore un autre produit ou non 
			    System.out.println("s'il n'y a pas un autre produit tapez -1 sinon saisez le reference de produit \n");
				ref=scan.nextInt();
			}
			
            System.out.println(" le montant total est : "+prixTotal+" DA");
			menu_responsable();	
		}
		
	   static void retours(){
	   	int  i,clientFidele;
	   	double remb=0;
	   	String nom;
	   	
	   	System.out.println("le client a une carte de fidelite :\n 1-oui!\n 2-non!");
			clientFidele=scan.nextInt();
		
		//le produit qu'on veut rembourser n'existe plus dans notre ListeProduit car on a le supprime quand il etait vendu donc on cherche a un produit avec le meme nom( par exemple tablete )pour avoir le prix comme suite : 
		System.out.println("saisez le nom du produit \n");
			nom=scan.next();
			i=ListeProduits.searchProduitByName(nom);
			
			while (i!=-1)
			{
			    remb+=ListeProduits.getProduits().get(i).getPrixProduit();
			    i=ListeAchat.searchAchatByName(ListeProduits.getProduits().get(i).getNomProduit());
			    ListeAchat.getAchats().get(i).setNbrachat( ListeAchat.getAchats().get(i).getNbrachat() -1 );
			    if(clientFidele==1)
			    {
			    	System.out.println("entrez le numero de la carte fidelite du client");
			    	i=scan.nextInt();
			    	remb-=CompteFidelite.ListeFidelite.get(i).remise(i);
			    }
			    
			  //le responsable doit saiser le produit retourne dans la liste produit 
			    ListeProduits.ajoutProduit();
			    
			  //avoir s'il y a encore un autre produit ou non
			    System.out.println("s'il n'y a pas un autre produit tapez -1 sinon entrez le nom du produit \n");
				nom=scan.next();
				i=ListeProduits.searchProduitByName(nom);	
			}
			
			System.out.printf(" le remboursement total est %d DA",remb);
			menu_responsable();
		}
	   
		static void menu_client(){
		       int i;
			  
		       System.out.println("vous voulez :\n 1-afficher_liste\n 2-consulter votre compte fidelite");
			   choix=scan.nextInt();
		    	
			   switch(choix) {
				case 1:
					ListeProduits.afficherListeProduitPourClient();
				break;
				case 2:
					System.out.println("veuillez entrer le numero de votre carte fidelite:");
					i=scan.nextInt();
					CompteFidelite.ListeFidelite.get(i).consulterCompteFidelite();
					
				break;
				default: System.out.println("vous devez choisir 1 ou 2 !");
			              menu_client(); 
		             	}
	                  }	
}
