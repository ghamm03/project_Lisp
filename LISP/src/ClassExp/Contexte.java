package ClassExp;
import java.util.*;

public class Contexte {
	public static HashMap<String,SExpr> tab = new HashMap<String,SExpr>();
	private static Stack<HashMap<String,SExpr> >pile = new Stack<HashMap<String,SExpr>>() ;
	

	public static Contexte cont = new Contexte();
	private Contexte() {};
	
	public void ajouter(String s, SExpr e){
		tab.put(s,e);
	}
	
	public void empiler(){
		pile.push(new HashMap<String,SExpr>(tab));
	}
	
	public void depiler(){
		tab = pile.pop();
	}
	
	public SExpr get(String s){
		return tab.get(s);
	}
	
}
