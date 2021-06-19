package banana.positionallist;

/**
 * Base exception for all exceptions thrown by Banana library.
 *
 * @author Gilbert Ssenyonjo
 * @see InvalidPosition
 * @since 1.0
 */
public class BananaException extends RuntimeException {
    public BananaException(String message) {
        super(message);
    }
}
