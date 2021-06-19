package banana.positionallist;

/**
 * {@code RuntimeException} subclass thrown when an invalid position is
 * used as argument to a method.
 *
 * @author Gilbert Ssenyonjo
 * @see PositionalList
 * @see Position
 * @since 1.0
 */
public class InvalidPosition extends BananaException {
    public InvalidPosition(String message) {
        super(message);
    }

}
