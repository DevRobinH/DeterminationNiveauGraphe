/*
 * Sommet.java                            21/01/2019
 * 3il 2nd année
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation des sommets d'un graphe
 * @author Quentin MS, Robin Henry, Florent Mamprin
 * @version 1.0
 */
public class Sommet {

	/** Identifiant du sommet du graphe */
	private char id;


	/** Liste des successeurs du sommet */
	private List<Sommet> successeurs;


	/** Liste des prédécesseurs du sommet */
	private List<Sommet> predecesseurs;

	/** Attribut utilisé dans l'algorithme de determination de niveau,
	 *  à false lors de l'initialisation */
	private boolean marque;

	/**
	 * Création d'un sommet
	 * @param identifiant id du sommet
	 */
	public Sommet (char identifiant) {
		this.id = identifiant;
		this.successeurs = new ArrayList<>();
		this.predecesseurs = new ArrayList<>();
		this.marque = false;

	}

	/**
	 * Création d'un sommet en lui attribuant ses successeurs et ses predecesseurs
	 * @param identifiant id du sommet
	 * @param successeurs les successeurs du sommet
	 * @param predecesseurs les predecesseurs du sommet
	 */
	public Sommet (char identifiant,List<Sommet> successeurs,List<Sommet> predecesseurs  ) {
		this.id = identifiant;
		this.successeurs = successeurs;
		this.predecesseurs = predecesseurs;
		this.marque = false;

	}

	/**
	 * Ajout d'un sommet à la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void addSuccesseur (Sommet successeur) {
		// On verifie que le sommet à ajouter ne fait pas déjà partie de la liste
		if ((!this.successeurs.contains(successeur))) {
			this.successeurs.add(successeur);
		}
	}

	/**
	 * Ajout d'un sommet à la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void addPredecesseur (Sommet predecesseur) {
		// On verifie que le sommet à ajouter ne fait pas déjà partie de la liste
		if (!(this.predecesseurs.contains(predecesseur))) {
			this.predecesseurs.add(predecesseur);
		}
	}

	/**
	 * Ajout d'un sommet à la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void removeSuccesseur (Sommet successeur) {
		// On verifie que le sommet à supprimer est dans  la liste
		if ((this.successeurs.contains(successeur))) {
			this.successeurs.remove(successeur);
		}
	}

	/**
	 * Ajout d'un sommet à la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void removePredecesseur (Sommet predecesseur) {
		// On verifie que le sommet à supprimer est dans  la liste
		for(int i = 0 ; i < this.predecesseurs.size(); i ++) {

			if (predecesseur.getId() == this.predecesseurs.get(i).getId()) {
				this.predecesseurs.remove(this.predecesseurs.get(i));
			}
		}

	}

	/**
	 * @return the id
	 */
	public char getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(char id) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Id du sommet :" + this.id + "\nPredecesseur :");
		// Affichage de tous ses prédecesseurs
		for(int i = 0; i < this.predecesseurs.size(); i++ ) {
			chaine.append(predecesseurs.get(i).getId());
			if (i < predecesseurs.size()-1) {
				chaine.append(", ");
			}
		}
		chaine.append("\nSucesseurs : ");
		// Affichage de tous ses sucesseurs
		for(int i = 0; i < this.successeurs.size(); i++ ) {
			chaine.append(successeurs.get(i).getId());
			if (i != successeurs.size()) {
				chaine.append(", ");
			}
		}
		chaine.append("\n");
		return chaine.toString();
	}


}
