package pobj.motx.tme2;

public class CroixContrainte implements IContrainte {
	private int m1,m2,c1,c2;
	/**
	 * 
	 * @param m1
	 * @param c1
	 * @param m2
	 * @param c2
	 */
	public CroixContrainte(int m1, int c1, int m2,int c2) {
		this.m1=m1;
		this.c1=c1;
		this.m2=m2;
		this.c2=c2;
	}
	
	/**
	 * 
	 */
	@Override
	
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre l1 =grille.getMotsPot().get(m1).calcul(c1);
		EnsembleLettre l2 =grille.getMotsPot().get(m2).calcul(c2);
		EnsembleLettre s = l1.intersection(l2);
		int k1=0,k2=0;
		if(l1.size()>s.size()) 
			 k1=grille.getMotsPot().get(m1).filtre(c1, s);
		if(l2.size()>s.size())
			 k2=grille.getMotsPot().get(m2).filtre(c2, s);
		
		return k1+k2;
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if((other==null)||(other.getClass()!=this.getClass()))
			return false;
		CroixContrainte cse = (CroixContrainte) other;
		return((this.c1==cse.c1)&&(this.m1==cse.m1)&&(this.c2==cse.c2)&&(this.m2==cse.m2));
	}

}