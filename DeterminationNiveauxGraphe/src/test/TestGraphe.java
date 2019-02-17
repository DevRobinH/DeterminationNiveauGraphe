
package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import metier.Graphe;
import metier.Sommet;

/**
 * @author q.massellamany
 *
 */
public class TestGraphe {

	/** Définition de jeu de jeu  */
	public static final int MATRICE_TEST1[][] =  {{0,0,0,1,0,0,0,0},
												  {0,0,0,1,1,0,0,0},
												  {0,0,0,0,1,0,0,1},
												  {0,0,0,0,0,1,1,1},
												  {0,0,0,0,0,0,1,0},
												  {0,0,0,0,0,0,0,0},
												  {0,0,0,0,0,0,0,0},
												  {0,0,0,0,0,0,0,0}};

	public static final int MATRICE_TEST2[][] =  {{0,1,0,1,0,0,0},
												  {0,0,1,0,0,0,1},
												  {0,0,0,0,0,0,1},
												  {0,0,0,0,1,1,0},
												  {0,0,0,0,0,1,0},
												  {0,0,0,0,0,0,0},
												  {0,0,0,0,0,1,0}};

	public static final int MATRICE_TEST3[][] =  {{0,1,1,0,0,0},
												  {0,0,0,1,0,0},
												  {0,1,0,1,0,0},
												  {0,0,0,0,1,1},
												  {0,0,0,0,0,1},
												  {0,0,0,0,0,0}};


	/**
	 * Test de la création d'un graphe via le constructeur à 2 paramètres
	 * Test de la méthode initListeSommet permmetant la tradcution
	 * de la matrice d'adjacence en liste de sommet
	 */
	public static void testCreationGraphe() {
		Graphe grapheTest = new Graphe(MATRICE_TEST1.length,MATRICE_TEST1);

		// On boucle sur chaque sommet du graphe
		for(int i = 0; i < grapheTest.getListeSommet().size(); i++) {

			System.out.print("\nSommet " + grapheTest.getListeSommet().get(i).getId() + " :");
			System.out.print("\nListe de ses prédecesseurs : ");

			// Affichage des prédecesseurs du sommet courant
			for (int j = 0; j <  grapheTest.getListeSommet().get(i).getPredecesseurs().size(); j++) {
				System.out.print(grapheTest.getListeSommet().get(i).getPredecesseurs().get(j).getId() + ", ");
			}

			System.out.print("\nListe de ses successeurs : ");

			// Affichage des successeurs du sommet courant
			for (int j = 0; j < grapheTest.getListeSommet().get(i).getSuccesseurs().size(); j++) {
				System.out.print(grapheTest.getListeSommet().get(i).getSuccesseurs().get(j).getId() + ", ");
			}
		}
	}
	
	public static void testDeterminationNiveaux () {
		// Jeux d'essai
		ArrayList<int[][]> jeuxTest = new ArrayList<>();
		jeuxTest.add(MATRICE_TEST1);
		jeuxTest.add(MATRICE_TEST2);
		jeuxTest.add(MATRICE_TEST3);
		
		// Lancement de la batterie de test
		for (int i = 0; i <jeuxTest.size(); i++) {
			System.out.println("JEUX DE TEST " + (i+1) );
			System.out.println("Matrice d'ajacence du graphe :");
			System.out.println(afficheMatrice(jeuxTest.get(i)));
			HashMap<String,ArrayList<Sommet>> niveaux = new HashMap<>();
			Graphe grapheTest = new Graphe(jeuxTest.get(i).length,jeuxTest.get(i));
			niveaux = grapheTest.determinationNiveau();
			
			// Affichage du resultat
			System.out.println("Résultat : ");
			for (Entry<String, ArrayList<Sommet>> entree : niveaux.entrySet())
			{
			  System.out.print("\nNiveau : " + entree.getKey() + "\n");
			  for(int j = 0; j < entree.getValue().size(); j++) {
			      System.out.print(entree.getValue().get(j).getId() + " "); 
			  }
			}
			System.out.println("\n\n###########################################"
					+ "#########################################################"
					+ "####################################\n\n");
		}
		
	}

	
	/**
	 * Affichage d'une matrice au format [a b b b b]
	 * @param la matrice à afficher
	 */
	public static String afficheMatrice (int[][] matrice) {
	    StringBuilder formatM = new StringBuilder("[");
	    for (int i = 0; i < matrice.length; i++) {
	    	for(int j = 0 ; j < matrice[i].length; j++) {
	    		formatM.append(" " +matrice[i][j] + " ");
	    	}
	    	formatM.append("]\n");
	    	if (i < matrice.length - 1) {
	    		formatM.append("[");
	    	}
	    }
		return formatM.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testCreationGraphe();
		testDeterminationNiveaux();		

	}

}
