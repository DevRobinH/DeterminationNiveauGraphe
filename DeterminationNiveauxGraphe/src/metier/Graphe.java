/*
 * Graphe.java                            21/01/2019
 * 3il 2nd ann�e
 */
package metier;

/**
 * Repr�sentation de graphe orient�
 * Impl�mentation de la fonctionnalit� permettant de determiner
 * les diff�rents niveaux du graphe
 * @author Quentin MS, Robin Henry, Florent Mamprin
 * @version 1.0
 */
public class Graphe {

	/** Nombre de sommet du graphe */
	private int sommet;

	/** Matrice d'adjacence du graphe*/
	private int matriceAdjacence[][];

	/**
	 * Impl�mentation d'un graphe en ne d�finissant que son nombre de soomet
	 * Les ar�tes ne sont pas d�finis
	 * @param nbsommet nombre de sommet composant le graphe
	 * @throws IllegalArgumentException nombre de sommet n�gatif ou null
	 */
	public Graphe (int nbSommet) {
		// v�rification du nombre de sommet pass� en param�tre
		if (nbSommet <= 0 ) {
			throw new IllegalArgumentException("Le graphe doit poss�der au moins 1 sommet");
		}
		this.sommet = nbSommet;

		this.matriceAdjacence = new int[nbSommet][nbSommet];

	}

	/**
	 * Impl�mentation d'un graphe en d�finissant ses sommets
	 * ainsi que ses ar�tes
	 * @param nbSommet nombre de sommet composant le graphe
	 * @param matrice  matrice d'ajacence permettant de connaitre comment sont li�s les sommets
	 */
	public Graphe (int nbSommet, int matrice[][]) {
		// v�rification du nombre de sommet pass� en param�tre
				if (nbSommet <= 0 ) {
					throw new IllegalArgumentException("Le graphe doit poss�der au moins 1 sommet");
				}
				this.sommet = nbSommet;

				this.matriceAdjacence = matrice;
	}

}
