package ClassExp;

public interface SExpr {

	public boolean Atom();
	public boolean EQ(SExpr e);
	public SExpr eval() throws LispException ;
}
