package pobj.motx.tme1;

public class Grille {
	private int hauteur;
	private int largeur;
	private Case[][] grille;
	/**
	 * 
	 * @param hauteur  de la grille
	 * @param largeur de la grille
	 * 
	 * initialisation de la liste des cases contenues dans la grille à des cases vides (' ')
	 */
	
	public Grille(int hauteur, int largeur){
		this.hauteur = hauteur;
		this.largeur= largeur;
		grille = new Case[hauteur][largeur];
		for(int i=0; i<hauteur; i++){
			for(int j=0; j<largeur; j++){
				grille[i][j]= new Case(i,j,' ');
			}
		}
	}
	/**
	 * 
	 * @param lig 
	 * @param col
	 * @return retourner une case dans la grille de numéroro de ligne "lig" et numéro de colonne "col" 
	 */
	public Case getCase(int lig, int col){
		return grille[lig][col];
	}
	/**
	 * affichage de la grille
	 */
	public String toString(){
		StringBuilder  sb= new StringBuilder();
		for(int i=0;i<hauteur;i++){
			for(int j=0;j<largeur;j++){
				sb.append(" "+(grille[i][j]).getChar());
				
			}
			sb.append("\n");
			
		}
		
		
		return sb.toString();
	}
	/**
	 * 
	 * @return nombre de ligne de la grille
	 */
	public int nbLig(){
		return this.hauteur;
	}
	/**
	 
	 * @return nombre de colonne de la grille
	 */
	public int nbCol(){
		return this.largeur;
	}
	/**
	 * 
	 * @return une copie d ela grille (avec des copies de cases (les deuxx pointent des cases différentes masi avec des mêmes valeurs)
	 */
	public Grille copy(){
		Grille g;
		g = new Grille(this.hauteur, this.largeur);
		for(int i=0;i<hauteur;i++){
			for(int j=0;j<largeur;j++){
				g.grille[i][j]= new Case(this.grille[i][j].getLig(),this.grille[i][j].getCol(),this.grille[i][j].getChar());
				
			}
		}
		return g;
	}
}
