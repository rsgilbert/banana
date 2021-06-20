package banana.positionallist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Concrete implementation of a {@link PositionalList} using a doubly linked list.
 *
 * @param <E> type of elements that will be stored in {@link Position}s of this list.
 * @author Gilbert Ssenyonjo
 * @since 1.0
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
    // -------------- nested Node class --------------

    /**
     * Concrete implementation of a {@code Node} that holds the element as well as
     * references to the next and previous {@code Node}s.
     * <p>The Node class implements the {@link Position} interface.
     *
     * @param <E> type of element stored by the node.
     */
    private class Node<E> implements Position<E> {
        /**
         * Element stored at this node
         */
        E element;

        /**
         * Previous node in the list
         */
        Node<E> prev;

        /**
         * Subsequent node in the list
         */
        Node<E> next;


        /**
         * Constructs a new node storing element e and having previous node p and
         * next node n.
         *
         * @param e element that will be stored at this node
         * @param p previous node in the list
         * @param n next node in the list
         */
        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        /**
         * Produces the element stored at this node.
         *
         * @return element stored at this node.
         * @throws InvalidPosition if the {@link Position} is no longer valid.
         */
        @Override
        public E getElement() {
            // Convention for defunct node
            if (next == null) {
                throw new InvalidPosition("Position is no longer valid");
            }
            return element;
        }

        /**
         * Produces previous node
         *
         * @return previous node
         */
        Node<E> getPrev() {
            return prev;
        }

        /**
         * Produces next node
         *
         * @return next node
         */
        Node<E> getNext() {
            return next;
        }

        /**
         * Sets/replaces the element at this node with element e.
         *
         * @param e new element to be stored at this node.
         */
        void setElement(E e) {
            element = e;
        }

        /**
         * Sets/replaces previous node with node p.
         *
         * @param p new previous node.
         */
        void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets/replaces next node with node n.
         *
         * @param n new next node.
         */
        void setNext(Node<E> n) {
            next = n;
        }
    }
    // -------------- end of nested Node class ----------------

    /*
     * Instance variables of the LinkedPositionalList
     */
    // header sentinel
    private Node<E> header;
    // trailer sentinel
    private Node<E> trailer;
    // number of elements in the list
    private int size = 0;

    /**
     * Constructs a new empty list.
     */
    public LinkedPositionalList() {
        // create header
        header = new Node<>(null, null, null);
        // trailer is preceded by header
        trailer = new Node<>(null, header, null);
        // header is followed by trailer
        header.setNext(trailer);
    }

    // ----- private utilities -----------

    /**
     * Validates {@link Position} p and produces it as a node if it is valid.
     * <p>An invalid {@link Position} is one which has been previously removed from the list.
     *
     * @param p {@link Position} to be validated
     * @return node at {@link Position} p
     * @throws IllegalArgumentException if {@link Position} p is not a {@link Node}.
     * @throws InvalidPosition          if {@link Position} p is invalid.
     */
    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) throw new IllegalArgumentException("p must be a node");
        // safe cast
        Node<E> node = (Node<E>) p;
        // convention for defunct node
        if (node.getNext() == null) {
            throw new InvalidPosition("p is invalid as it was removed from this list");
        }
        return node;
    }

    /**
     * Produces the {@link Position} of the given {@link Node} node or null if node is a sentinel node.
     *
     * @param node {@link Node} whose {@link Position} is to be produced.
     * @return {@link Position} of the given {@link Node} node or null if node is a sentinel node.
     */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            // do not expose user to the sentinels
            return null;
        }
        return node;
    }

    // ---------------- end of private utilities ----------------------

    // ---------------- public accessor methods -----------------------

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // ----------- end of public accessor utilities ----------------

    // ----------- private utilities -------------------------------

    /**
     * Adds element e to the list between the predecessor node and the successor node and returns the new {@link Position} of the element added.
     *
     * @param e           element to be added
     * @param predecessor {@link Position} that should come before the element's new {@link Position}
     * @param successor   {@link Position} that should come after the element's new {@link Position}
     * @return new {@link Position} of element e
     */
    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // Create and link a new node
        Node<E> newest = new Node<E>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
    }

    // ------------ end of private utilities -----------------------

    // ------------ public update methods --------------------------

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        // get removed node
        E removedElement = node.getElement();
        // convention for defunct node
        node.setNext(null);
        // help with garbage collection
        node.setElement(null);
        node.setPrev(null);
        size--;
        return removedElement;
    }

    // ---------------- nested PositionIterator class ---------------------------

    /**
     * {@link Iterator} class that provides an iterator over the list's {@link Position}s.
     */
    private class PositionIterator implements Iterator<Position<E>> {
        // position of the next element to report
        private Position<E> cursor = first();
        // position of last reported element
        private Position<E> recent = null;

        /**
         * Produces {@code true} if the iterator has a next {@link Position}.
         *
         * @return {@code true} if the iterator has a next {@link Position}
         */
        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * Produces the next position in the iterator.
         *
         * @return next {@link Position} in the iterator
         * @throws NoSuchElementException if the iterator has no more {@link Position}s
         */
        public Position<E> next() {
            if (cursor == null) throw new NoSuchElementException("No more positions");
            // element at this position might later be removed
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes the {@link Position} produced by the most recent call to {@link #next()}
         */
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("No position to remove");
            // remove from outer list
            LinkedPositionalList.this.remove(recent);
            // Do not allow remove again until next is called
            recent = null;
        }
    }
    // ---------------------- end of nested PositionIterator class -------------------


    // --------------------- nested PositionIterable class --------------------------

    /**
     * {@link Iterable} class that provides an iterable of {@link Position}s.
     */
    private class PositionIterable implements Iterable<Position<E>> {
        /**
         * Produces an iterator of {@link Position}s.
         *
         * @return an iterator of {@link Position}s
         */
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }

        /**
         * Produces a string made by concatenating elements in all positions separated by a space.
         * @return a string made by concatenating elements in all positions separated by a space
         */
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (Position<E> p : this)
                result.append(" ").append(p.getElement());
            return result.toString();
        }
    }
    // -------------------- end of nested PositionIterable class --------------------


    @Override
    public Iterable<Position<E>> positions() {
        // creates a new instance of the new PositionIterable class
        return new PositionIterable();
    }

    //  ---------------- nested ElementIterator class ----------

    /**
     * Adapts the iteration produced by {@link #positions()} to return elements instead.
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = new PositionIterator();

        /**
         * Produces true if the iterator has a next element.
         * @return true if the iterator has a next element
         */
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        /**
         * Produces the next element in the iterator.
         * @return the next element in the iterator
         * @throws NoSuchElementException if there is no more elements.
         */
        public E next() {
            return positionIterator.next().getElement();
        }

        /**
         * Removes the position of the element produced by the most recent call to {@link #next()} from the list.
         */
        public void remove() {
            positionIterator.remove();
        }

    }

    // ------------- end of nested ElementIterator class ---------

    /**
     * Produces an iterator that iterates over elements
     *
     * @return an iterator that iterates over elements
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
