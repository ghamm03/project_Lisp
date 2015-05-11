package ClassExp;

public class Main {
	public static void main (String [] args) {
		SExpr a = new Symbole("a");
		SExpr b = new Symbole("b");
		SExpr c = new Symbole("c");
		SExpr d = new Symbole("d");

		SExpr quote = new Symbole("quote");
		SExpr car = new Symbole("car");
		SExpr cdr = new Symbole("cdr");
		SExpr cons = new Symbole("cons");
		SExpr lambda = new Symbole("lambda");

		SExpr nil = NIL.nil;


		SExpr liste = new SCons(a,nil/*new SCons(b,new SCons(c,new SCons(d,nil)))*/);
		SExpr liste2 = new SCons(b,nil/*new SCons(b,nil)/*new SCons(a,new SCons(d,nil)))*/);

		//EXEMPLE 1
		SExpr param1 = new SCons(quote,new SCons(a));
		SExpr param2 = new SCons(quote,new SCons(b));
		SExpr param3 = new SCons(cons,new SCons(param1,new SCons(param2)));

		SExpr exp2 = new SCons(cons,new SCons(param1,new SCons(param3)));
		SExpr exp = new SCons(cdr,new SCons(exp2,nil));

		Contexte.cont.ajouter("quote", Quote.quote);
		Contexte.cont.ajouter("cdr", Cdr.cdr);
		Contexte.cont.ajouter("car", Car.car);
		Contexte.cont.ajouter("cons", Cons.cons);

		System.out.println(exp2.toString());

		try { System.out.println(exp2.eval().toString());}
		catch (LispException e){
			System.out.println("expt");
		}
	}



}
