package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable{
	
	private int indice;
	private GrillePotentiel gp;
	public DicoVariable(int indice, GrillePotentiel gp) {
		this.gp = gp; this.indice = indice;
	}
	public List<String> getDomain(){
		return gp.getMotsPot().get(indice).getMots();
	}
	public String toString() {
		List<String> mots = this.getDomain();
		StringBuilder sb = new StringBuilder();
		for (String s : mots) {
			sb.append(s+"\n");
		}
		return sb.toString();
	}
	public int getIndice() {
		return indice;
	}
}
