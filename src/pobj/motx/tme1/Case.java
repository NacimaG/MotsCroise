package pobj.motx.tme1;

public class Case {
	private int ligne;
	private int colonne;
	private char ch;

	public Case(int lig, int col, char c){
		ligne = lig;
		colonne = col;
		ch =c;
	}
	
	public int getLig(){
		return ligne;
	}
	
	public int getCol(){
		return colonne;
	}
	
	public char getChar(){
		return ch;
	}
	
	public void setChar(char c){
		ch = c;
	}
	
	public boolean isVide(){
		return (ch ==' ');
	}
	
	public boolean isPleine(){
		return (ch == '*');
	}
}
