package ClassExp;

public class ListException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListException(String s)
	{
	    System.out.println("Erreur dans la commande Lisp : "+s);
	}
}
