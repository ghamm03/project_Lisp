package ClassExp;

public interface Evaluator {
	public SExpr apply(SCons e) throws ListException;
}
