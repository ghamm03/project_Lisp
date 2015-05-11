package ClassExp;

public class Symbole extends Atome {
	
	private String ch;
	
	public String toString(){
		return ch;
	}
	
	public SExpr eval () throws LispException {
		SExpr res= Contexte.tab.get(ch);
		if (res==null){
			throw new LispException("Erreur symbole");
		}
		return res;
	}
	
	public Symbole (String s) { 
		ch=s;
	}


}
