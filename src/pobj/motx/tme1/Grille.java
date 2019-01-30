package pobj.motx.tme1;

public class Grille {
	private int hauteur;
	private int largeur;
	private Case[][] grille;
	
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
	public Case getCase(int lig, int col){
		return grille[lig][col];
	}
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
	public int nbLig(){
		return this.hauteur;
	}
	public int nbCol(){
		return this.largeur;
	}
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
