package ClassExp;

public class Car extends Subr {
	public static Car car = new Car();
	private Car(){};
	
	public SExpr apply(SCons e) throws ListException{
		SExpr a = e.Car();
		SExpr b = e.Cdr();
		if (b instanceof NIL && a instanceof SCons) {
			return ((SCons) a).Car();
		}
		
		throw new ListException("Erreur Car");
	}
	
	public String toString(){
		return "car";
	}
}
