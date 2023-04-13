package Symbol.Excuses;

public class ExcuseNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcuseNotFoundException(int httpCode) {
		 super("Je ne trouve pas l'excuse " + httpCode+ " !");
	}
}
