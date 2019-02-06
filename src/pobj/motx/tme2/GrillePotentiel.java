package pobj.motx.tme2;

import java.util.*;

import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces gp;
	private Dictionnaire dic;
	private List<Dictionnaire> motPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicComplet) {
		this.gp = grille;
		this.dic = dicComplet;
		
		motPot = new ArrayList<Dictionnaire>();
		
		for (Emplacement emp : gp.getPlaces()) {
			Dictionnaire d = dic.copy();
			d.filtreLongueur(emp.size());
			
			
			motPot.add(d);
			
			
			}
		for (Emplacement emp : gp.getPlaces()) {
			for(int i=0; i<emp.size(); i++) {
				if(!emp.getCase(i).isVide()){
					if (gp.getPlaces().indexOf(emp)<gp.getNbHorizontal()) 
						motPot.get(gp.getPlaces().indexOf(emp)).filtreParLettre(emp.getCase(i).getChar(), emp.getCase(i).getCol());
					
					else
						motPot.get(gp.getPlaces().indexOf(emp)).filtreParLettre(emp.getCase(i).getChar(), emp.getCase(i).getLig());
					
				}
			}
		}
	}
	/*
	public GrillePotentiel(GrillePlaces grilleP, List<Dictionnaire> dicP, Dictionnaire dic) {
		this.gp = grilleP;
		this.motPot = dicP;
		this.dic = dic;
	}*/
		
	public boolean isDead() {

		for (Emplacement emp : gp.getPlaces()) 
			if(emp.size()==0)
				return true;
			
		return false;
	}
	public List<Dictionnaire> getMotsPot(){
		return this.motPot;
	}
	public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(gp.fixer(m, soluce).getGrilPCopy(), dic);
	}
	
}
