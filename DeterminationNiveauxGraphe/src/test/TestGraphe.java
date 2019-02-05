/**
 *
 */
package test;

import metier.Graphe;

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
										          {0,0,0,0,1,0,1},
										          {0,0,0,0,1,1,0},
										          {0,0,0,0,0,1,0},
										          {0,0,0,0,0,0,0},
										          {0,0,0,0,0,1,0}};

	public static final int MATRICE_TEST3[][] =  {{0,1,0},
										          {0,0,1},
										          {0,0,0}};


	/**
	 * Test de la crésation d'un graphe via le constructeur à 2 paramètres
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

        	System.out.print("\nListe de ses sucesseurs : ");

        	// Affichage des successeurs du sommet courant
        	for (int j = 0; j < grapheTest.getListeSommet().get(i).getSuccesseurs().size(); j++) {
        		System.out.print(grapheTest.getListeSommet().get(i).getSuccesseurs().get(j).getId() + ", ");
        	}
        }
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testCreationGraphe();
		Graphe grapheTest = new Graphe(MATRICE_TEST3.length,MATRICE_TEST3);
		for (int i = 0; i < grapheTest.getListeSommet().size(); i++){
			 System.out.println(grapheTest.getListeSommet().get(i).toString());
		}
		System.out.println("############################################");
		grapheTest.determinationNiveau();


	}

}
