package ClassExp;

public class Quote extends FSubr {
	
	public static Quote quote = new Quote();
	private Quote(){};
	
	public SExpr apply(SCons e) throws ListException{
		SExpr a = e.Car();
		SExpr b = e.Cdr();
		if (b instanceof NIL) {
			return a;
		}
		
		throw new ListException("Erreur quote");
	}
	
	public String toString(){
		return "quote";
	}

}
