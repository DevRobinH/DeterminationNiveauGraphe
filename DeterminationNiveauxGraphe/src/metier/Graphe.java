/*
 * Graphe.java                            21/01/2019
 * 3il 2nd année
 */
package metier;

/**
 * Représentation de graphe orienté
 * Implémentation de la fonctionnalité permettant de determiner
 * les différents niveaux du graphe
 * @author Quentin MS, Robin Henry, Florent Mamprin
 * @version 1.0
 */
public class Graphe {

	/** Nombre de sommet du graphe */
	private int sommet;

	/** Matrice d'adjacence du graphe*/
	private int matriceAdjacence[][];

	/**
	 * Implémentation d'un graphe en ne définissant que son nombre de soomet
	 * Les arêtes ne sont pas définis
	 * @param nbsommet nombre de sommet composant le graphe
	 * @throws IllegalArgumentException nombre de sommet négatif ou null
	 */
	public Graphe (int nbSommet) {
		// vérification du nombre de sommet passé en paramètre
		if (nbSommet <= 0 ) {
			throw new IllegalArgumentException("Le graphe doit posséder au moins 1 sommet");
		}
		this.sommet = nbSommet;

		this.matriceAdjacence = new int[nbSommet][nbSommet];

	}

	/**
	 * Implémentation d'un graphe en définissant ses sommets
	 * ainsi que ses arêtes
	 * @param nbSommet nombre de sommet composant le graphe
	 * @param matrice  matrice d'ajacence permettant de connaitre comment sont liés les sommets
	 */
	public Graphe (int nbSommet, int matrice[][]) {
		// vérification du nombre de sommet passé en paramètre
				if (nbSommet <= 0 ) {
					throw new IllegalArgumentException("Le graphe doit posséder au moins 1 sommet");
				}
				this.sommet = nbSommet;

				this.matriceAdjacence = matrice;
	}

}
