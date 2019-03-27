package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	private Grille grille;
	private List<Emplacement> places;
	private  int nbhorizontal;
	/**
	 * 
	 * @param grille 
	 * création et initialisation de la grille d'emplacement
	 * Recherche et  détection des emplacemnts disponibles (horizontal et vertical) et les ajouter dand la liste places
	 * 
	 */
	public GrillePlaces(Grille grille) {
		places = new ArrayList<Emplacement>();
		//places= this.initPlaces(grille);
		this.grille=grille;
		
		for(int i=0; i<this.grille.nbLig();i++) 
			chercherPlaces(getLig(i));
		
		this.nbhorizontal = places.size();
		
		
		
		for(int j=0; j<this.grille.nbCol();j++) 
			chercherPlaces(getCol(j));
		
	}
	/**
	 * 
	 * @return liste des emplacements
	 */
	
	public List<Emplacement> getPlaces(){
		return this.places;
	}
	/**
	 * 
	 * @return nombre de mot en horizontal
	 */
	public int getNbHorizontal() {
		return nbhorizontal;
		
		
	}
	/**
	 * 
	 * @param lig une ligne de la grille
	 * @return les cases qui consituent une ligne (Lig) dans la grille
	 */
	private List<Case> getLig(int lig){
		
		List<Case> caseLigne = new ArrayList<Case>();
		
		for(int j=0;j<this.grille.nbCol();j++) {
			caseLigne.add(this.grille.getCase(lig, j));
		}
		return caseLigne;
	}
	/**
	 * 
	 * @param col une colonne de la grille
	 * @return les cases constituant une colonne (Col) dans la grille
	 */
	
	private List<Case> getCol(int col){
		
		List<Case> caseCol = new ArrayList<Case>();
			for(int i=0;i<grille.nbLig();i++) {
				caseCol.add(grille.getCase(i, col));
			}
		return caseCol;
	}
	
	/**
	 * 
	 * 
	 * @param cases liste de case 
	 * Recherche les cases qui sont des emplacement possible de mot dans une liste de case et les ajouter à la liste places
	 */
	private void chercherPlaces(List<Case> cases) {
		Emplacement e=new Emplacement();
		
		for(Case c: cases) {
			
			if(!c.isPleine()) 
				e.AjoutCase(c);
			else {
			
			if(e.size()>1) 
				this.places.add(e);
			
				e=new Emplacement();			
					}
		}
		if(e.size()>1)
			this.places.add(e);
	}
	
	/**
	 * affichage de la grille
	 */
	public String toString() {
		StringBuilder  sb= new StringBuilder();
		for(int i=0;i<grille.nbLig();i++){
			for(int j=0;j<grille.nbCol();j++){
				sb.append(" "+(grille.getCase(i, j).getChar()));
				
			}
			sb.append("\n");
			
		}
		
		
		return sb.toString();
	}
	public GrillePlaces getGrilPCopy() {
		return new GrillePlaces(this.grille.copy());
		
	}
	public GrillePlaces fixer(int m, String soluce) {
		for (int i=0; i<getPlaces().get(m).size(); i++)
			getPlaces().get(m).getCase(i).setChar(soluce.charAt(i));
		return this;
	}
	
	
	
}
