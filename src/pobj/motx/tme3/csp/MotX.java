package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.GrillePotentiel;

public class MotX implements ICSP{
	
	private List<IVariable> listDicoVar;
	private GrillePotentiel gp;
	
	public MotX(GrillePotentiel gp) {
		listDicoVar = new ArrayList<>();
		for (Emplacement emp : gp.getGP()) {
			if(emp.hasCaseVide())
				listDicoVar.add(new DicoVariable(gp.getGP().indexOf(emp), gp));
		}
		this.gp = gp;
	}
	
	@Override
	public List<IVariable> getVars() {
		
				
		return listDicoVar;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		if (vi instanceof DicoVariable) {
			DicoVariable var = (DicoVariable)vi;
			GrillePotentiel res = gp.fixer(var.getIndice(), val);
			return new MotX(res);
		}

		return null;
	}
	public String toString() {
		return gp.toString();
	}
	
	

}
