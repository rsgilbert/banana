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
     * @throws InvalidPosition if the {@link Position} is no longer valid.
     */
    E getElement();

//    /**
//     * Produces {@code true} if this {@link Position} is valid and belongs to a list.
//     *
//     * @return {@code true} if this {@link Position} is valid and belongs to a list
//     */
//    boolean isValid();
//
//    /**
//     * Produces the enclosing {@link PositionalList} that this {@link Position} is part of.
//     *
//     * @return the enclosing {@link PositionalList} that this {@link Position} is part of
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    PositionalList<E> getPositionalList();
//
//    /**
//     * Produces the {@link Position} immediately before this {@link Position} or null if this {@link Position} is the first {@link Position} in the list.
//     *
//     * @return the {@link Position} immediately before this {@link Position} or null if this {@link Position} is the first {@link Position} in the list.
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    Position<E> before();
//
//    /**
//     * Produces the {@link Position} immediately after this {@link Position} or null if this {@link Position} is the last {@link Position} in the list.
//     *
//     * @return the {@link Position} immediately after this {@link Position} or null if this {@link Position} is the last {@link Position} in the list.
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    Position<E> after();
//
//
//    /**
//     * Inserts element e immediately before this {@link Position} and produces {@link Position} of e.
//     *
//     * @param e element to be inserted
//     * @return e's new {@link Position}
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    Position<E> addBefore(E e);
//
//    /**
//     * Inserts element e immediately after this {@link Position} and produces {@link Position} of e.
//     *
//     * @param e element to be inserted
//     * @return e's new {@link Position}
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    Position<E> addAfter(E e);
//
//    /**
//     * Replaces the element stored at this {@link Position} and produces the replaced element.
//     *
//     * @param e new element to be set in this {@link Position}
//     * @return replaced element
//     * @throws InvalidPosition if this {@link Position} is invalid
//     */
//    E set(E e);
//
//    /**
//     * Removes this {@link Position} from the list and produces the element stored at this {@link Position}.
//     * <p> Once this {@link Position} has been removed from the list, it is invalidated to make it unusable in other operations/methods.
//     *
//     * @return element at the this position
//     * @throws InvalidPosition if this {@link Position} is already invalid/was already removed from its enclosing list
//     */
//    E remove();

}

