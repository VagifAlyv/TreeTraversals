package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

public class PostorderIterator<T> implements Iterator<T> {

    private StackInterface<BinaryNode<T>> nodeStack;
    private BinaryNode<T> currentNode;

    public PostorderIterator(BinaryNode<T> root) {
        nodeStack = new ArrayStack<>();
        currentNode = root;
    }

    @Override
    public boolean hasNext() {
        return !nodeStack.isEmpty() || currentNode != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (currentNode != null) {
            nodeStack.push(currentNode);
            if (currentNode.getLeftChild() != null) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        BinaryNode<T> nextNode = nodeStack.pop();
        T data = nextNode.getData();

        if (!nodeStack.isEmpty()) {
            BinaryNode<T> topNode = nodeStack.peek();

            if (nextNode == topNode.getLeftChild()) {
                currentNode = topNode.getRightChild();
            }
        }

        return data;
    }
    public void remove() {
		throw new UnsupportedOperationException();
	}
}
