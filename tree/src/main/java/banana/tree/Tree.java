package banana.tree;

import banana.positionallist.Position;

import java.util.Iterator;


/**
 * Interface for the Tree Abstract Data Type
 * Goodrich Page 313
 * Nodes can have an arbitrary number of children
 *
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p) throws IllegalArgumentException;
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
    int depth(Position<E> p);
    int height(Position<E> p);
    int height();

}