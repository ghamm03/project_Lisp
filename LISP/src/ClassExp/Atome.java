package ClassExp;

public abstract class Atome implements SExpr {
	
	public SExpr eval() throws LispException {
		return this;		
	}
	public boolean Atom(){
		return true;
	}
	
	public boolean EQ(SExpr e){
		return this.equals(e);
	}
	
	public SExpr Cons(SExpr e){
		return new SCons(this,e);
	}
	
}
