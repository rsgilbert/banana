package banana.positionallist;


/**
 * Interface for PositionalList ADT.
 * A positional list is a collection of {@link Position}s each of which stores an element.
 *
 * @param <E> type of element contained by {@link Position}s in the list
 * @see Position
 * @author Gilbert Ssenyonjo
 * @since 1.0
 */
public interface PositionalList<E> {
    /**
     * Produces the number of {@link Position}s in the list.
     *
     * @return number of {@link Position}s in the list.
     */
    int size();

    /**
     * Produces {@code true} if the list has no {@link Position}s.
     *
     * @return {@code true} if the list has no {@link Position}s.
     */
    boolean isEmpty();

    /**
     * Produces the first {@link Position} in the list or null if the list is empty.
     *
     * @return the first {@link Position} in the list or null if the list is empty.
     */
    Position<E> first();

    /**
     * Produces the last {@link Position} in the list or null if the list is empty.
     *
     * @return the last {@link Position} in the list or null if the list is empty.
     */
    Position<E> last();

    /**
     * Produces the {@link Position} immediately before {@link Position} p or null if p is the first {@link Position} in the list.
     *
     * @param p {@link Position} whose before-position is to be produced.
     * @return {@link Position} immediately before {@link Position} p or null if p is the first {@link Position} in the list.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    Position<E> before(Position<E> p);

    /**
     * Produces the {@link Position} immediately after {@link Position} p or null if p is the last {@link Position} in the list.
     *
     * @param p {@link Position} whose after-position is to be produced.
     * @param p {@link Position} whose after-position is to be produced.
     * @return {@link Position} immediately after {@link Position} p.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    Position<E> after(Position<E> p);

    /**
     * Inserts element e to the start of the list and produces its new {@link Position}.
     *
     * @param e element to be inserted to the start of the list.
     * @return {@link Position} of element e after it has been inserted to the start of the list.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts element e to the end of the list and produces its new {@link Position}.
     *
     * @param e element to be inserted to the end of the list.
     * @return {@link Position} of element e after it has been inserted to the end of the list.
     */
    Position<E> addLast(E e);

    /**
     * Inserts element e immediately after {@link Position} p and produces {@link Position} of e.
     *
     * @param p {@link Position} before which element e will be inserted.
     * @param e element to be inserted.
     * @return e's new {@link Position}.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    Position<E> addBefore(Position<E> p, E e);

    /**
     * Inserts element e immediately after {@link Position} p and produces {@link Position} of e.
     *
     * @param p {@link Position} after which element e will be inserted.
     * @param e element to be inserted.
     * @return e's new {@link Position}.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    Position<E> addAfter(Position<E> p, E e);

    /**
     * Replaces the element stored at {@link Position} p and produces the replaced element.
     *
     * @param p {@link Position} whose element is to be replaced/set.
     * @param e new element to be set in {@link Position} p.
     * @return replaced element.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    E set(Position<E> p, E e);

    /**
     * Removes {@link Position} p from the list and produces the element stored at {@link Position} p.
     * <p> Once {@link Position} p has been removed from the list, p is invalidated to make it unusable in other operations/methods on the list.
     *
     * @param p {@link Position} to be removed from the list.
     * @throws InvalidPosition if {@link Position} p does not belong to this list.
     */
    E remove(Position<E> p);

    /**
     * Produces an iterable of the list's {@link Position}s.
     *
     * @return an iterable of the list's {@link Position}s.
     */
    Iterable<Position<E>> positions();
}

