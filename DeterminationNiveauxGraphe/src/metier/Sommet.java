/*
 * Sommet.java                            21/01/2019
 * 3il 2nd ann�e
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Repr�sentation des sommets d'un graphe
 * @author Quentin MS, Robin Henry, Florent Mamprin
 * @version 1.0
 */
public class Sommet {

	/** Identifiant du sommet du graphe */
	private String id;


	/** Liste des successeurs du sommet */
	private List<Sommet> successeurs;


	/** Liste des pr�d�cesseurs du sommet */
	private List<Sommet> predecesseurs;

	/** Attribut utilis� dans l'algorithme de determination de niveau,
	 *  � false lors de l'initialisation */
	private boolean marque;

	/**
	 * Cr�ation d'un sommet
	 * @param identifiant id du sommet
	 */
	public Sommet (String identifiant) {
		this.id = identifiant;
		this.successeurs = new ArrayList<>();
		this.predecesseurs = new ArrayList<>();
		this.marque = false;

	}

	/**
	 * Cr�ation d'un sommet en lui attribuant ses successeurs et ses predecesseurs
	 * @param identifiant id du sommet
	 * @param successeurs les successeurs du sommet
	 * @param predecesseurs les predecesseurs du sommet
	 */
	public Sommet (String identifiant,List<Sommet> successeurs,List<Sommet> predecesseurs  ) {
		this.id = identifiant;
		this.successeurs = successeurs;
		this.predecesseurs = predecesseurs;
		this.marque = false;

	}

	/**
	 * Ajout d'un sommet � la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void addSuccesseur (Sommet successeur) {
		// On verifie que le sommet � ajouter ne fait pas d�j� partie de la liste
		if (this.successeurs.contains(successeur)) {
			throw new IllegalArgumentException("Sommet d�j� contenu dans la liste");
		}

		this.successeurs.add(successeur);
	}

	/**
	 * Ajout d'un sommet � la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void addPredecesseur (Sommet predecesseur) {
		// On verifie que le sommet � ajouter ne fait pas d�j� partie de la liste
		if (this.predecesseurs.contains(predecesseur)) {
			throw new IllegalArgumentException("Sommet d�j� contenu dans la liste");
		}

		this.predecesseurs.add(predecesseur);
	}

	/**
	 * Ajout d'un sommet � la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void removeSuccesseur (Sommet successeur) {
		// On verifie que le sommet � supprimer est dans  la liste
		if ((this.successeurs.contains(successeur))) {
			this.successeurs.remove(successeur);
		}

	}

	/**
	 * Ajout d'un sommet � la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void removePredecesseur (Sommet predecesseur) {
		// On verifie que le sommet � supprimer est dans  la liste
		if ((this.predecesseurs.contains(predecesseur))) {
			this.predecesseurs.remove(predecesseur);
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the successeurs
	 */
	public List<Sommet> getSuccesseurs() {
		return successeurs;
	}

	/**
	 * @param successeurs the successeurs to set
	 */
	public void setSuccesseurs(List<Sommet> successeurs) {
		this.successeurs = successeurs;
	}

	/**
	 * @return the predecesseurs
	 */
	public List<Sommet> getPredecesseurs() {
		return predecesseurs;
	}

	/**
	 * @param predecesseurs the predecesseurs to set
	 */
	public void setPredecesseurs(List<Sommet> predecesseurs) {
		this.predecesseurs = predecesseurs;
	}

	/**
	 * @return the marque
	 */
	public boolean isMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(boolean marque) {
		this.marque = marque;
	}


}
