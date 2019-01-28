/*
 * Graphe.java                            21/01/2019
 * 3il 2nd ann�e
 */
package metier;

import java.util.ArrayList;
import java.util.List;

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

	/** Liste des sommets du graphe */
	private List<Sommet> listeSommet;

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

		this.listeSommet = new ArrayList<Sommet>();

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

		this.listeSommet = new ArrayList<>();
		listeSommet = initListeSommet(matrice);


	}

	/**
	 * Lecture de la matrice d'adjacence
	 * Et traduction en liste de sommet avec leur ar�tes
	 * @param matrice Matrice d'adjacence du graphe
	 * @return la liste des sommets du graphe
	 */
	public ArrayList<Sommet> initListeSommet (int matrice[][]) {
		ArrayList<Sommet> sommets = new ArrayList<>();
		// D�termination des successeurs et des predecesseur de chaque sommet
		// Parcours des lignes
		for (int i = 0; i < matrice.length; i++) {
			// parcours des �l�ments de la ligne afin de d�terminer les successeurs
			sommets.add(new Sommet(Integer.toString(i)));
			for (int j = 0; j < matrice[i].length; j++) {
				// s'il y a un 1 dans la matrice
				if (matrice[i][j] == 1) {
					sommets.get(i).addSuccesseur(new Sommet(Integer.toString(j)));
				}
			}
			// parcours des colonnes afin de d�terminer les pr�decesseurs
			for (int k = 0; k < matrice.length; k++) {
				if (matrice[k][i] == 1) {
					sommets.get(i).addPredecesseur(new Sommet(Integer.toString(k)));
				}
			}
		}
		return sommets;

	}


	/**
	 * D�termination des diff�rents niveaux d'un graphe orient�e
	 */
	public void determinationNiveau () {
		// Supprimer les sommets sans predecesseurs de la liste
		int j = 0;
		// On ex�cute l'algo tant qu'il y a des sommet dans la liste
		while (!(this.listeSommet.isEmpty())) {
			int i = 0;
			// System.out.println(i);
			// Acc�der � la liste de sommet
			for( ; i < listeSommet.size(); i++) {
				// Affiche les sommets sans pr�d�cesseurs
				if (listeSommet.get(i).getPredecesseurs().isEmpty()) {
					System.out.println("Niveau " +  j + " : " + listeSommet.get(i).getId());
					// on marque le sommet
					listeSommet.get(i).setMarque(true);
				}
			}
			// Acc�der � la liste de sommet
			for( ; i < listeSommet.size(); i++) {
				// Pour tout les sommets on va supprimer des liste de successeurs et de predecessuers les sommets marqu�s
				if(listeSommet.get(i).isMarque()) {

				}
			}

			for (int k = 0 ; k < listeSommet.get(k).getPredecesseurs().size(); k++  ) {

				if(listeSommet.get(k).getPredecesseurs().contains(listeSommet.get(i))) {
					System.out.println("je supprimme le sommet " + listeSommet.get(i).getId() );
					listeSommet.get(k).removePredecesseur(listeSommet.get(i));
				}

				if(listeSommet.get(k).getSuccesseurs().contains(listeSommet.get(i))) {
					System.out.println("je supprimme le sommet " + listeSommet.get(i).getId() );
					listeSommet.get(k).removeSuccesseur(listeSommet.get(i));
				}

				if (listeSommet.get(i).getPredecesseurs().isEmpty()) {
					System.out.println("je supprimme le sommet de la liste de sommet " + listeSommet.get(i).getId() );
					listeSommet.remove(listeSommet.get(i));
				}

				j++;
			}
		}

	}

	/**
	 * @return the sommet
	 */
	public int getSommet() {
		return sommet;
	}

	/**
	 * @param sommet the sommet to set
	 */
	public void setSommet(int sommet) {
		this.sommet = sommet;
	}

	/**
	 * @return the matriceAdjacence
	 */
	public int[][] getMatriceAdjacence() {
		return matriceAdjacence;
	}

	/**
	 * @param matriceAdjacence the matriceAdjacence to set
	 */
	public void setMatriceAdjacence(int[][] matriceAdjacence) {
		this.matriceAdjacence = matriceAdjacence;
	}

	/**
	 * @return the listeSommet
	 */
	public List<Sommet> getListeSommet() {
		return listeSommet;
	}

	/**
	 * @param listeSommet the listeSommet to set
	 */
	public void setListeSommet(List<Sommet> listeSommet) {
		this.listeSommet = listeSommet;
	}

}
