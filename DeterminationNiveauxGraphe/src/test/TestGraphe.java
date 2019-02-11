/**
 *
 */
package test;

import java.util.ArrayList;
import java.util.HashMap;

import metier.Graphe;
import metier.Sommet;

/**
 * @author q.massellamany
 *
 */
public class TestGraphe {

	/** D�finition de jeu de jeu  */
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

	public static final int MATRICE_TEST3[][] =  {{0,1,0},
			{0,0,1},
			{0,0,0}};


	/**
	 * Test de la cr�sation d'un graphe via le constructeur � 2 param�tres
	 * Test de la m�thode initListeSommet permmetant la tradcution
	 * de la matrice d'adjacence en liste de sommet
	 */
	public static void testCreationGraphe() {
		Graphe grapheTest = new Graphe(MATRICE_TEST1.length,MATRICE_TEST1);

		// On boucle sur chaque sommet du graphe
		for(int i = 0; i < grapheTest.getListeSommet().size(); i++) {

			System.out.print("\nSommet " + grapheTest.getListeSommet().get(i).getId() + " :");
			System.out.print("\nListe de ses pr�decesseurs : ");

			// Affichage des pr�decesseurs du sommet courant
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
		HashMap<String,ArrayList<Sommet>> niveaux = new HashMap<>();
		Graphe grapheTest = new Graphe(MATRICE_TEST2.length,MATRICE_TEST2);
		for (int i = 0; i < grapheTest.getListeSommet().size(); i++){
			System.out.println(grapheTest.getListeSommet().get(i).toString());
		}

		System.out.println("############################################");
		niveaux = grapheTest.determinationNiveau();
		System.out.println("############################################");
		/*for (int i = 0; i < grapheTest.getListeSommet().size(); i++){
			 System.out.println(grapheTest.getListeSommet().get(i).toString());
		}*/
		System.out.println("Resultat : ");
		for (String i : niveaux.keySet()) {
			System.out.print("\nNiveau : " + i + "\n");

			for (ArrayList<Sommet> j : niveaux.values()) {
				/*for (int k = 0; k < j.size(); k++) {
					System.out.print(j.get(k).getId() + " ");
				}*/
				System.out.println(j.size());
			}
			System.out.println(niveaux.toString());
		}
	}

}
