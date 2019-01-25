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


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int matrice[][] = {{0,0,0,1,0,0,0,0},
				           {0,0,0,1,1,0,0,0},
				           {0,0,0,0,1,0,0,1},
				           {0,0,0,0,0,1,1,1},
				           {0,0,0,0,0,0,1,0},
				           {0,0,0,0,0,0,0,0},
				           {0,0,0,0,0,0,0,0},
				           {0,0,0,0,0,0,0,0}};

		int nbSommet = 8;

		Graphe grapheTest = new Graphe(nbSommet,matrice);

        System.out.println(grapheTest.getListeSommet().get(1).getSuccesseurs().get(1).getId());
	}

}
