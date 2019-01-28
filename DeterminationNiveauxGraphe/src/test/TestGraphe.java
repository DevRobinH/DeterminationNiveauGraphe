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


	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Graphe grapheTest = new Graphe(MATRICE_TEST1.length,MATRICE_TEST1);

        for(int i = 0; grapheTest.getListeSommet().size() < i; i++) {

        	System.out.println("Sommet " + grapheTest.getListeSommet().get(i) + " :");
        	System.out.println(" Liste de ses prédecesseurs : ");

        	for (int j = 0; grapheTest.getListeSommet().get(i).getPredecesseurs().size() < j; j++) {
        		System.out.print(grapheTest.getListeSommet().get(i).getPredecesseurs().get(j).getId() + ", ");
        	}

        	System.out.println(" Liste de ses sucesseurs : ");

        	for (int j = 0; grapheTest.getListeSommet().get(i).getSuccesseurs().size() < j; j++) {
        		System.out.print(grapheTest.getListeSommet().get(i).getSuccesseurs().get(j).getId() + ", ");
        	}
        }
	}

}
