package ClassExp;

public class Expr extends Fonction {
	
	public static final Expr expr = new Expr();
	private Expr() {};
	
	protected SExpr evalList(SExpr args) {
		
		//return SCons(Car(args),evalList(Cdr(args));
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SExpr apply(SCons e) {
		// TODO Auto-generated method stub
		return null;
	}

}
