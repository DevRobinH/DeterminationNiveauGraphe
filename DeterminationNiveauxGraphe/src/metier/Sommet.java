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
	private String id;


	/** Liste des successeurs du sommet */
	private List<Sommet> successeurs;


	/** Liste des prédécesseurs du sommet */
	private List<Sommet> predecesseurs;


	/**
	 * Création d'un sommet
	 * @param identifiant id du sommet
	 */
	public Sommet (String identifiant) {
		this.id = identifiant;
		successeurs = new ArrayList<>();
		predecesseurs = new ArrayList<>();

	}

	/**
	 * Création d'un sommet en lui attribuant ses successeurs et ses predecesseurs
	 * @param identifiant id du sommet
	 * @param successeurs les successeurs du sommet
	 * @param predecesseurs les predecesseurs du sommet
	 */
	public Sommet (String identifiant,List<Sommet> successeurs,List<Sommet> predecesseurs  ) {
		this.id = identifiant;
		successeurs = successeurs;
		predecesseurs = predecesseurs;

	}

	/**
	 * Ajout d'un sommet à la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void addSuccesseur (Sommet successeur) {
		// On verifie que le sommet à ajouter ne fait pas déjà partie de la liste
		if (this.successeurs.contains(successeur)) {
			throw new IllegalArgumentException("Sommet déjà contenu dans la liste");
		}

		this.successeurs.add(successeur);
	}

	/**
	 * Ajout d'un sommet à la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void addPredecesseur (Sommet predecesseur) {
		// On verifie que le sommet à ajouter ne fait pas déjà partie de la liste
		if (this.predecesseurs.contains(predecesseur)) {
			throw new IllegalArgumentException("Sommet déjà contenu dans la liste");
		}

		this.predecesseurs.add(predecesseur);
	}

	/**
	 * Ajout d'un sommet à la liste des successeurs du sommet courant
	 * @param successeur
	 */
	public void removeSuccesseur (Sommet successeur) {
		// On verifie que le sommet à supprimer n'est pas existant dans la liste
		if (!(this.predecesseurs.contains(successeur))) {
			throw new IllegalArgumentException("Sommet n'est pas dans la liste");
		}
		this.successeurs.remove(successeur);
	}

	/**
	 * Ajout d'un sommet à la liste des predecesseurs du sommet courant
	 * @param sucesseur
	 */
	public void removePredecesseur (Sommet predecesseur) {
		// On verifie que le sommet à supprimer n'est pas existant dans la liste
		if (!(this.predecesseurs.contains(predecesseur))) {
			throw new IllegalArgumentException("Sommet n'est pas dans la liste");
		}
		this.predecesseurs.remove(predecesseur);
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





}
