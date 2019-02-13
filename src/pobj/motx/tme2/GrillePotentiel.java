package pobj.motx.tme2;

import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces gp;
	private Dictionnaire dic;
	private List<Dictionnaire> motPot;
	private List<IContrainte> contraintes;
	private List<CroixContrainte> listcontr;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicComplet) {
		
		listcontr= new ArrayList<>();
		
		this.gp = grille;
		this.dic = dicComplet;
		motPot = new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<>();
		for (Emplacement emp : gp.getPlaces()) {
			Dictionnaire d = dic.copy();
			d.filtreLongueur(emp.size());
			motPot.add(d);
			for(int i=0; i<emp.size(); i++) {
				if(!emp.getCase(i).isVide()){ 
					motPot.get(gp.getPlaces().indexOf(emp)).filtreParLettre(emp.getCase(i).getChar(), emp.indexOf(emp.getCase(i)));
				}
			}
			
		}
//filtretr par contrainte
		for(Emplacement emp : gp.getPlaces()) {
			if(gp.getPlaces().indexOf(emp)<gp.getNbHorizontal()) 
				for(int i=0;i<emp.size();i++) 
					for(int j=gp.getNbHorizontal();j<gp.getPlaces().size();j++) 
						for(int k=0;k< gp.getPlaces().get(j).size();k++) 
							if((emp.getCase(i).isVide())&&(emp.getCase(i)==gp.getPlaces().get(j).getCase(k))) {
								CroixContrainte cc =  new CroixContrainte(gp.getPlaces().indexOf(emp), i, j, k);
								contraintes.add(cc);
								cc.reduce(this);
							}
		}
		
		propage();
	
	}
	public boolean isDead() {
		for (Emplacement emp : gp.getPlaces()) 
			if(motPot.get(gp.getPlaces().indexOf(emp)).size()==0)
				return true;
		return false;
	}
	public List<Dictionnaire> getMotsPot(){
		return this.motPot;
	}
	public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(gp.fixer(m, soluce).getGrilPCopy(), dic);
	}
	
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	private boolean propage() {
		int k=0;
		while(true) {
			for(int i=0; i<contraintes.size();i++) {
				k+=contraintes.get(i).reduce(this);
		}
			if(this.isDead())
				return false;
			if(k==0)
				return true;
			k=0;
		}	
	}
	public List<Emplacement> getGP() {
		return gp.getPlaces();
	}
}