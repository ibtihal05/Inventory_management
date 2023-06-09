package gestion_stock_client;
import java.util.ArrayList;
import java.util.Scanner;

public class ListeClients {

    static private ArrayList <Client> clients = new ArrayList<Client>() ;
    
    static Scanner scan = new Scanner(System.in);

 public static ArrayList<Client> getClients(){
		return clients;
	}

 public static void setClients(ArrayList<Client> Clients){
		clients = Clients;
	}
	
  public static  ArrayList<Client> CreerListeClient(){
	     		return clients;
  		}
   
  		
  static public Client  saisirClient()
  {
	  
	   System.out.println("donnez le nom de Client");
	   String nom =scan.next();
	   System.out.println("donnez le prenom de client");
	   String Prenom =scan.next();
       System.out.println("l'adresee de client :");
       String adresse =scan.next();
       
       Client client = new Client(nom,Prenom,adresse);
   return client ;
   }
	
	
	
 static public void ajouterClient( ) {
		
		Client c=saisirClient();
		if(!clients.contains(c))
		{ clients.add(c);
		System.out.println("le client ete ajoute ");
		} 
		else {System.out.println("le client existe déjà");}
		
	}
	
 static public void supprimeClient(int num) {
	 for(int i=0; i<clients.size();i++) {
	 if(clients.get(i).getIdentifiant()==num)
	 { clients.remove(clients.get(i).getIdentifiant());
	 System.out.println("le client supprimé est :"+clients.get(i));
	 return;
	 }
	 else {System.out.println("le client n'existe pas");}
	 }
 }
 
 static public void modifierClient(int numclient)
 { 
	 int i;
	 for( i=0;i<clients.size();i++) //boucle pour trouver le client qu'on veut le modifie
	 { 
	 if(clients.get(i).getIdentifiant()==numclient)
	 {
		 System.out.println("veillez entree les nouvelles informations");
		 Client c=saisirClient(); //on utilise nouveau client pour la modifications apres on va le supprimer 
		 
	   clients.get(i).setNomclient(c.getNomclient());
	   clients.get(i).setPrenomClient(c.getPrenomClient());
	   clients.get(i).setAdresse(c.getAdresse());
	   
	   System.out.println("la commande a modifié est"+clients.get(i));
	   
	   supprimeClient(c.getIdentifiant()); //on doit supprimer client c car on a juste l'utiliser pour modifier l'ancien client
	    return;
	 }
	 }
 }

		
 static public void affichelisteclient() {
		for(int i =0;i<clients.size();i++) {
		System.out.println(clients.get(i));	
		}
	}
 
 static  void menu_gestion_des_clients(){
        int choix;
		System.out.println("vous voulez :\n 1-Créer une liste de clients\n 2-Ajouter client\n 3-Supprimer client\n 4-Modifier client\n 5-Afficher la liste client\n 6-afficher l'etat de fidelisation des clients\n 7-Retour\n 8-Quitter");
			choix=scan.nextInt();
			switch(choix) {
			case 1:
				ArrayList<Client> c=CreerListeClient();
				break;
			case 2:
				ajouterClient();
				break;
			case 3:
				System.out.println("entrez le numero de client :\n");
				choix=scan.nextInt();
				supprimeClient(choix);
			case 4:
				System.out.println("entrez le numero de client :\n");
				choix=scan.nextInt();
				modifierClient(choix);
				break;
			case 5:
				affichelisteclient();
				break;
			case 6:
				 CompteFidelite.afficherListeCompte();
				break;
			case 7:
				 MainClass.menu_gestion();
				break;
			case 8:
				 System.exit(0);
				break;
			default: menu_gestion_des_clients();
			}
			menu_gestion_des_clients();
		}
}
