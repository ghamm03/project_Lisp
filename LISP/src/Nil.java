

public class Nil implements Slist{

	public static Sexpr NIL = new Nil();


	private Nil(){}

	@Override
	public Sexpr car() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Sexpr cdr() {
		// TODO Auto-generated method stub
		return this;
	}


}
