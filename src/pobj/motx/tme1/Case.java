package pobj.motx.tme1;

public class Case {
	private int ligne;
	private int colonne;
	private char ch;
	/**
	 * Représentation d'une case dans la grille 
	 * 
	 * @param lig numéro de ligne
	 * @param col numéro de colonne
	 * @param c lettre contenu dans la case
	 */

	public Case(int lig, int col, char c){
		ligne = lig;
		colonne = col;
		ch =c;
	}
	/**
	 * 
	 * @return  numéro de la ligne de la case 
	 *
	 **/
	
	public int getLig(){
		return ligne;
	}
	/**
	 * 
	 * @return numero de colonne de la case
	 */
	public int getCol(){
		return colonne;
	}
	/**
	 * 
	 * @return le caractère contenu dans la case
	 */
	
	public char getChar(){
		return ch;
	}
	/**
	 * 
	 * @param "c" pour modifier ( mise à jour) la valeur de la lettre de la case(en remplissant la grille)
	 */
	public void setChar(char c){
		ch = c;
	}
	/**
	 * 
	 * @return true si la case est vide et false sinon
	 **/
	
	public boolean isVide(){
		return (ch ==' ');
	}
	/**
	 * 
	 * @return vrai si la case est pleine
	 */
	public boolean isPleine(){
		return (ch == '*');
	}
}
