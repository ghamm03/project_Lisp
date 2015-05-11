package ClassExp;

public class SCons implements Liste {

	private final  SExpr tete,queue;

	public SCons(SExpr car,SExpr cdr) {
		this.tete=car;
		this.queue=cdr;
	}

	public SCons(SExpr car){
		this.tete = car;
		this.queue = NIL.nil;
	}

	@Override
	public String toString(){
		if (this.queue instanceof NIL) {
			return "(".concat(this.tete.toString()).concat(")");
		}
		else if (this.queue instanceof Symbole) {
			return "(".concat(this.tete.toString()).concat(" . ").concat(this.queue.toString()).concat(")");
		}
		return "(".concat(this.tete.toString()).concat(" ").concat(this.afficher(((SCons)this.queue)));
	}

	public String afficher(SCons e) {
		if (e.queue instanceof NIL) {
			return e.tete.toString().concat(")");
		}
		else if (e.queue instanceof Symbole) {
			return "(".concat(e.tete.toString()).concat(".").concat(e.queue.toString()).concat(")");
		}
		return e.tete.toString().concat(" ").concat(this.afficher(((SCons)e.queue)));
	}


	@Override
	public SExpr eval() throws ListException {
		Evaluator evaluator;
		SExpr arg = this.queue;
		SExpr rescar = this.tete.eval();
		SExpr param=null; // initialisation pour enlever erreur
		SExpr forme=NIL.nil; // initialisation pour enlever erreur
		if (rescar instanceof Symbole || rescar instanceof NIL)
			throw new ListException("12");
		else if (rescar instanceof Primitive)
			evaluator =((Primitive) rescar);
		else {
			SExpr ident= ((SCons)rescar).tete;
			param= ((SCons)(((SCons)rescar).queue)).tete;
			forme=((SCons)(((SCons)rescar).queue)).queue;
			if (ident instanceof Symbole){
				if (ident.toString()=="flambda")
					evaluator = FExpr.fexpr;
				else if (ident.toString()=="lambda")
					evaluator = Expr.expr;
				else
					throw new ListException("1"); // evaluer ident??

			}
			else {
				throw new ListException("2");
			}
		}

		// step 2
		if (evaluator instanceof Subr || evaluator instanceof Expr ){
			arg = ((SCons)arg).evalListe();
		}
		else {
			arg = ((SCons)arg).evalListe2();
		}


		//step 3
		if (evaluator instanceof Fonction) {
			Contexte.cont.empiler();
			this.associerContexte(param,arg);
			SExpr res = forme.eval();
			Contexte.cont.depiler();
			return res;
		}
		else {
			return evaluator.apply((SCons)arg);
		}

	}

	public void associerContexte(SExpr param,SExpr arg) throws ListException{
		if (param instanceof SCons && arg instanceof SCons){
			Contexte.cont.ajouter(((SCons)param).tete.toString(),((SCons)param).tete); // vérifier qu'on a bien un Symbole à droite
			this.associerContexte(((SCons)param).queue,((SCons)arg).queue);
		}
		else if (!(param instanceof NIL) || !(arg instanceof NIL))
			throw new ListException("3");

	}

	public SCons evalListe () throws ListException{
		if (this.queue==NIL.nil)
			return new SCons(this.tete.eval(),NIL.nil);
		else if (this.queue instanceof Symbole)
			throw new ListException("4");
		else
			return new SCons(this.tete.eval(),((SCons)this.queue).evalListe());
	}

	public SCons evalListe2 () throws ListException{
		if (this.queue==NIL.nil)
			return new SCons(this.tete,NIL.nil);
		else if (this.queue instanceof Symbole)
			throw new ListException("5");
		else
			return new SCons(this.tete,((SCons)this.queue).evalListe2());
	}

	public SExpr Cons(SExpr car,SExpr cdr) {
		return new SCons(car,cdr);
	}

	@Override
	public boolean Atom() {return false;}


	public SExpr Car() {
		return this.tete;
	}


	public SExpr Cdr() {
		return this.queue;
	}

	@Override
	public boolean EQ(SExpr e) {
		return this==e;
	}

}
