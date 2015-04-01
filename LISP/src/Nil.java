import java.util.ArrayList;


public class Nil extends Atome{

	private final ArrayList<Sexpr> list;

	public Nil(){
		this.list = new ArrayList<Sexpr>();
	}

	public ArrayList<Sexpr> getList() {
		return this.list;
	}



}
