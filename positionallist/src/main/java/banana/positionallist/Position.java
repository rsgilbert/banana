package banana.positionallist;

/**
 * Interface for Position ADT.
 * A position is an abstraction for the location of an element within a structure.
 * A position acts like a marker of an element within a {@link PositionalList} and it does not
 * change when insertions or deletions happen else where in the list or when the element it wraps changes.
 *
 * @param <E> type of element wrapped by position.
 * @author Gilbert Ssenyonjo
 * @see PositionalList
 * @since 1.0
 */
public interface Position<E> {
    /**
     * Produces the element stored at this position.
     *
     * @return the stored element.
     * @throws InvalidPosition if the {@link banana.positionallist.Position} is no longer valid.
     */
    E getElement();
}

