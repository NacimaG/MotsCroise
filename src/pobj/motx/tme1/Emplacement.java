package pobj.motx.tme1;

import java.util.*;


public class Emplacement {
	private List<Case> lettres;
	/**
	 * liste de Cases 
	 */
	public Emplacement() {
		this.lettres=  new ArrayList<>();
	}
	/**
	 * 
	 * 
	 * @param lettres construire un emplacement à partir d'une liste de Case où il ya au moins 2 cases vides
	 */
	public Emplacement(List<Case> lettres){
		this.lettres=lettres;
	}
	
	public int indexOf(Case box) {
		return lettres.indexOf(box); 
	}
	/**
	 * affichage de la grille
	 */
	public String toString(){
		StringBuilder s=new StringBuilder();
		for(int i=0; i<lettres.size();i++){
			s.append(lettres.get(i).getChar());
		}
		return s.toString();
	}
	/**
	 * 
	 * @return la taille d'un emplacement
	 */
	public int size(){
		return this.lettres.size();
	}
	/**
	 * 
	 * @param c ajouter une case à un emplacement
	 */
	public void AjoutCase(Case c) {
		this.lettres.add(c);
	}
	/**
	 * 
	 * @param i la postion de la case dans la liste de cases "lettres"
	 * @return la case n° i de la liste
	 */
	public Case getCase(int i) {
		return this.lettres.get(i);
	}
}
