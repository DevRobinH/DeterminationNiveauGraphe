/*
 * Sommet.java                            21/01/2019
 * 3il 2nd année
 */
package metier;

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


}
