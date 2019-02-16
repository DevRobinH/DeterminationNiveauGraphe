/*
 * Graphe.java                            21/01/2019
 * 3il 2nd ann�e
 */
package metier;

import java.util.ArrayList;
import java.util.HashMap;
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
			sommets.add(new Sommet((char)(i+65)));
			for (int j = 0; j < matrice[i].length; j++) {
				// s'il y a un 1 dans la matrice
				if (matrice[i][j] == 1) {
					sommets.get(i).addSuccesseur(new Sommet((char)(j+65)));
				}
			}
			// parcours des colonnes afin de d�terminer les pr�decesseurs
			for (int k = 0; k < matrice.length; k++) {
				if (matrice[k][i] == 1) {
					sommets.get(i).addPredecesseur(new Sommet((char)(k+65)));
				}
			}
		}
		return sommets;

	}


	/**
	 * D�termination des diff�rents niveaux d'un graphe orient�e
	 */
	public HashMap<String,ArrayList<Sommet>> determinationNiveau () {
		//niveau du graphe
		int niveau = 0;
		// liste de sommet marqu�s
		ArrayList<Sommet> listeMarques =  new ArrayList<Sommet>();
		// Map avec pour cl� le niveau 
		// Et pour valeur la liste de sommet correspondant au niveau
		// A retourner
        HashMap<String,ArrayList<Sommet>> niveaux = new HashMap<>();
		
		// Marquage des sommets sans pr�decesseurs
		listeMarques =  marquageSommet(niveau);

		System.out.println("il y a " + listeMarques.size() + " sommets marqu�s");

		while (!listeSommet.isEmpty()) {
			// pour chaque sommet marqu� 
			for(int i = 0; i < listeMarques.size(); i++) {
				//affichage de son id 
				System.out.println("id du sommet marqu� : " + listeMarques.get(i).getId());

				System.out.print("id des sommets du graphe : ");
				// on parcourt la liste des sommets du graphe
				for(int j = 0; j < listeSommet.size(); j++) {
					// affichage de l'id des sommets 
					System.out.print(listeSommet.get(j).getId() + " ");

					System.out.print("id de ses predecesseurs : ");
					// on parcourt les pr�decesseurs de chaque sommet
					for(int k = 0; k < listeSommet.get(j).getPredecesseurs().size(); k++) {
						// affichage de l'id des predecesseurs 
						System.out.println(listeSommet.get(j).getPredecesseurs().get(k).getId());

						// on supprime le predecesseur s'il possede le m�me
						// id que le sommet marqu�
						if(listeMarques.get(i).getId() == listeSommet.get(j).getPredecesseurs().get(k).getId()) {
							System.out.print("   il faut le supprim�!\n");
							listeSommet.get(j).getPredecesseurs().remove(k);
						}
						// 
					}
					System.out.println("\n");
				}
			}
			for (int i = 0; i < listeMarques.size(); i++ ) {
				// on enl�ve de la liste des sommets le sommet ancinnement marqu�
				for(int j = 0; j < listeSommet.size(); j++) {
					if (listeMarques.get(i).getId()==listeSommet.get(j).getId()) {
						listeSommet.remove(j);
					}
				}
			}
			
			// on remplit la hashMap 
			niveaux.put(Integer.toString(niveau), (ArrayList<Sommet>)listeMarques.clone());
			niveau ++;
			listeMarques.clear();
			listeMarques =  marquageSommet(niveau);

		}
		return niveaux;

	}

	/**
	 * Marquage des sommet ne poss�dant pas de pr�decesseurs
	 * @param niveau niveau de d�composition du graphe
	 * @return liste de sommet marqu�
	 */
	private ArrayList<Sommet> marquageSommet(int niveau) {
		ArrayList<Sommet> marques = new ArrayList<Sommet>();
		System.out.print("Niveau " +  niveau + " : ");
		// Acc�der � la liste de sommet
		for(int i = 0; i < listeSommet.size(); i++) {
			// Affiche les sommets sans pr�d�cesseurs
			if (listeSommet.get(i).getPredecesseurs().isEmpty()) {
				System.out.print(listeSommet.get(i).getId()+ "  ");
				// on marque le sommet
				listeSommet.get(i).setMarque(true);
				// insertion du sommet marqu� � la liste
				marques.add(listeSommet.get(i));
			}
		}
		System.out.println("\n");
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
