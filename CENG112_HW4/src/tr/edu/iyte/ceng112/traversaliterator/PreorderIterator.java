package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.tree.BinaryNode;

public class PreorderIterator<T> implements Iterator<T> {
    private ArrayStack<BinaryNode<T>> nodeStack;

    public PreorderIterator(BinaryNode<T> root) {
    	nodeStack = new ArrayStack<>();
        if (root != null) {
        	nodeStack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        BinaryNode<T> current = nodeStack.pop();
        if (current.getRightChild() != null) {
        	nodeStack.push(current.getRightChild());
        }
        if (current.getLeftChild() != null) {
        	nodeStack.push(current.getLeftChild());
        }

        return current.getData();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
