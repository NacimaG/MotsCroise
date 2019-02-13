package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	private List<Character> lettres;
	
	public EnsembleLettre() {
		lettres = new ArrayList<Character>();
		
	}
	public EnsembleLettre(List<Character> liste) {
		this.lettres = liste;
	}
	public int size() {
		return lettres.size();
	}
	public void add(char c) {
		if(!lettres.contains(c))
			lettres.add(c);
	}
	public boolean contains(char c) {
		for(char ch : lettres)
			if(ch==c)
				return true;
		return false;
	}
	public char getChar(int i) {
		return lettres.get(i);
	}
	public EnsembleLettre intersection(EnsembleLettre l2) {
		List<Character> list = new ArrayList<>();
		for(int i=0; i<l2.size();i++) {
			if(this.contains(l2.getChar(i)))
				list.add(l2.getChar(i));
		}
		return new EnsembleLettre(list);
	
	}
	
}