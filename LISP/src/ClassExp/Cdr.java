package ClassExp;

public class Cdr extends Subr {
	public static Cdr cdr = new Cdr();
	private Cdr(){};
	
	public SExpr apply(SCons e) throws LispException{
		SExpr a = e.Car();
		SExpr b = e.Cdr();
		if (b instanceof NIL && a instanceof SCons) {
			return ((SCons) a).Cdr();
		}
		
		throw new LispException("Erreur Cdr");
	}
	
	public String toString(){
		return "cdr";
	}
}
