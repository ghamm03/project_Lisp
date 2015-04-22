

public class Scons implements Slist {

	private Sexpr prem;
	private Sexpr sec;


	//ACCESSEURS
	protected Sexpr getPrem() {
		return prem;
	}

	protected void setPrem(Sexpr prem) {
		this.prem = prem;
	}

	protected Sexpr getSec() {
		return sec;
	}

	protected void setSec(Sexpr sec) {
		this.sec = sec;
	}



	//CONSTRUCTORS
	public Scons(Sexpr tete, Sexpr queue){
		this.setPrem(tete);
		this.setSec(queue);
	}

	@Override
	public Sexpr car() {
		// TODO Auto-generated method stub
		return this.getPrem();
	}

	@Override
	public Sexpr cdr() {
		// TODO Auto-generated method stub
		return this.getSec();
	}



}
