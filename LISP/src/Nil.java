

public class Nil extends Atome implements Slist{

	public static Sexpr NIL = new Nil();


	private Nil(){}


	@Override
	public Sexpr car() {
		return this;
	}

	@Override
	public Sexpr cdr() {
		return this;
	}


}
