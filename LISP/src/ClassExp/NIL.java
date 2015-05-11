package ClassExp;

public class NIL extends Atome implements Liste {
	public static final NIL nil = new NIL();
	private NIL() {};
	public SExpr Car() {return this;}
	public SExpr Cdr() {return this;}
	public SExpr eval(){return nil;};
	public String toString(){
		return "()";
	}
	
}
