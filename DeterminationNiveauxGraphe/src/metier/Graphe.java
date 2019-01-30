/*
 * Graphe.java                            21/01/2019
 * 3il 2nd année
 */
package metier;

import java.util.ArrayList;
import java.util.List;

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

	/** Liste des sommets du graphe */
	private List<Sommet> listeSommet;

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

		this.listeSommet = new ArrayList<Sommet>();

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

		this.listeSommet = new ArrayList<>();
		listeSommet = initListeSommet(matrice);


	}

	/**
	 * Lecture de la matrice d'adjacence
	 * Et traduction en liste de sommet avec leur arêtes
	 * @param matrice Matrice d'adjacence du graphe
	 * @return la liste des sommets du graphe
	 */
	public ArrayList<Sommet> initListeSommet (int matrice[][]) {
		ArrayList<Sommet> sommets = new ArrayList<>();
		// Détermination des successeurs et des predecesseur de chaque sommet
		// Parcours des lignes
		for (int i = 0; i < matrice.length; i++) {
			// parcours des éléments de la ligne afin de déterminer les successeurs
			sommets.add(new Sommet(Integer.toString(i)));
			for (int j = 0; j < matrice[i].length; j++) {
				// s'il y a un 1 dans la matrice
				if (matrice[i][j] == 1) {
					sommets.get(i).addSuccesseur(new Sommet(Integer.toString(j)));
				}
			}
			// parcours des colonnes afin de déterminer les prédecesseurs
			for (int k = 0; k < matrice.length; k++) {
				if (matrice[k][i] == 1) {
					sommets.get(i).addPredecesseur(new Sommet(Integer.toString(k)));
				}
			}
		}
		return sommets;

	}


	/**
	 * Détermination des différents niveaux d'un graphe orientée
	 */
	public void determinationNiveau () {
		//niveau du graphe
		int niveau = 0;
		// liste de sommet marqués
		ArrayList<Sommet> listeMarques =  new ArrayList<Sommet>();

		// Marquage des sommets sans prédecesseurs
		listeMarques =  marquageSommet(niveau);

		// Pour chaque sommet marqué
		for(int i = 0; i < listeMarques.size(); i++) {
			// On va le supprimer de la liste des prédecesseurs et successeur de chaque sommet
			// (s'il y sont présent)

			for (int j = 0; j < this.listeSommet.size(); j++) {
				listeSommet.get(j).removePredecesseur(listeMarques.get(i));
				listeSommet.get(j).removeSuccesseur(listeMarques.get(i));
				System.out.println(listeSommet.get(j).toString());
			}

		}

		// pour chaque sommet on va supprimer le ou les sommets marqués de leurs liste
		//de prédeccesseurs ou sucesseur

	}


	/**
	 * Marquage des sommet ne possédant pas de prédecesseurs
	 * @param niveau niveau de décomposition du graphe
	 * @return liste de sommet marqué
	 */
	private ArrayList<Sommet> marquageSommet(int niveau) {
		ArrayList<Sommet> marques = new ArrayList<Sommet>();
		// Accéder à la liste de sommet
		for(int i = 0; i < listeSommet.size(); i++) {
			// Affiche les sommets sans prédécesseurs
			if (listeSommet.get(i).getPredecesseurs().isEmpty()) {
				System.out.println("Niveau " +  niveau + " : " + listeSommet.get(i).getId());
				// on marque le sommet
				listeSommet.get(i).setMarque(true);
				// insertion du sommet marqué à la liste
				marques.add(listeSommet.get(i));
			}
		}
		return marques;
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
