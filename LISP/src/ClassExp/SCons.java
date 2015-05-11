package ClassExp;

public class SCons implements Liste {
	
	private SExpr car,cdr;
	
	public SCons(SExpr car,SExpr cdr) {
		this.car=car;
		this.cdr=cdr;
	}
	
	public String toString(){
		if (cdr instanceof NIL) {
			return "(".concat(car.toString()).concat(")");
		}
		else if (cdr instanceof Symbole) {
			return "(".concat(car.toString()).concat(" . ").concat(cdr.toString()).concat(")");
		}
		return "(".concat(car.toString()).concat(" ").concat(afficher(((SCons)cdr)));
	}
	
	public String afficher(SCons e) {
		if (e.cdr instanceof NIL) {
			return e.car.toString().concat(")");
		}
		else if (e.cdr instanceof Symbole) {
			return "(".concat(e.car.toString()).concat(".").concat(e.cdr.toString()).concat(")");
		}
		return e.car.toString().concat(" ").concat(afficher(((SCons)e.cdr)));
	} 
	

	public SExpr eval() throws ListException {
		Evaluator evaluator;
		SExpr arg = cdr;
		SExpr rescar = car.eval();
		SExpr param=null; // initialisation pour enlever erreur
		SExpr forme=NIL.nil; // initialisation pour enlever erreur
		if (rescar instanceof Symbole || rescar instanceof NIL)
			throw new ListException("12");
		else if (rescar instanceof Primitive)
			evaluator =((Primitive) rescar);
		else {
			 SExpr ident= ((SCons)rescar).car;
			 param= ((SCons)(((SCons)rescar).cdr)).car;
			 forme=((SCons)(((SCons)rescar).cdr)).cdr;
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
			associerContexte(param,arg);
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
			Contexte.cont.ajouter(((SCons)param).car.toString(),((SCons)param).car); // vérifier qu'on a bien un Symbole à droite 
			associerContexte(((SCons)param).cdr,((SCons)arg).cdr);
		}
		else if (!(param instanceof NIL) || !(arg instanceof NIL))
			throw new ListException("3");
			
	}
	
	public SCons evalListe () throws ListException{
		if (cdr==NIL.nil)
			return new SCons(car.eval(),NIL.nil);
		else if (cdr instanceof Symbole)
			throw new ListException("4");
		else
			return new SCons(car.eval(),((SCons)cdr).evalListe());
	}
	
	public SCons evalListe2 () throws ListException{
		if (cdr==NIL.nil)
			return new SCons(car,NIL.nil);
		else if (cdr instanceof Symbole)
			throw new ListException("5");
		else
			return new SCons(car,((SCons)cdr).evalListe2());
	}
	
	public SExpr Cons(SExpr car,SExpr cdr) {
		return new SCons(car,cdr);
	}	
	
	public boolean Atom() {return false;}


	public SExpr Car() {
		return car;
	}


	public SExpr Cdr() {
		return cdr;
	}

	public boolean EQ(SExpr e) {
		return this==e;
	}

}
