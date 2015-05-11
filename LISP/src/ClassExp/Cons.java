package ClassExp;

public class Cons extends Subr {

	public static Cons cons = new Cons();
	private Cons(){};
	
	@Override
	public SExpr apply(SCons e) throws LispException{
		SExpr a = e.Car();
		SExpr b = e.Cdr();
		if (b instanceof SCons && ((SCons) b).Cdr() instanceof NIL) {
			return new SCons(a,((SCons)b).Car());
		}
		
		throw new LispException("Erreur Cons");
	}
	
	
	public String toString(){
		return "cons";
		}

}
