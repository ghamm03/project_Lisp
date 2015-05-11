package ClassExp;

public class Main {
	public static void main (String [] args) {
	SExpr a = new Symbole("a");
	SExpr b = new Symbole("b");
	SExpr c = new Symbole("c");
	SExpr d = new Symbole("d");
	SExpr quote = new Symbole("quote");
	SExpr car = new Symbole("car");
	SExpr nil = NIL.nil;
	SExpr listeab = new SCons(a,new SCons(b,nil));
	SExpr quotel = new SCons(quote,new SCons(listeab,nil));
	SExpr exp = new SCons(car,new SCons(quotel,nil));
	Contexte.cont.ajouter("quote", Quote.quote);
	Contexte.cont.ajouter("cdr", Cdr.cdr);
	Contexte.cont.ajouter("car", Car.car);
	System.out.println(quotel.toString());
	try { System.out.println(quotel.eval().toString());}
	catch (ListException e){
		System.out.println("expt");
	}
	}
	
	
	
}
