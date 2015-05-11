package ClassExp;

public class Symbole extends Atome {
	
	private String ch;
	
	public String toString(){
		return ch;
	}
	
	public SExpr eval () throws ListException {
		SExpr res= Contexte.tab.get(ch);
		if (res==null){
			throw new ListException("Erreur symbole");
		}
		return res;
	}
	
	public Symbole (String s) { 
		ch=s;
	}


}
