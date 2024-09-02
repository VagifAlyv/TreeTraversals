package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import tr.edu.iyte.ceng112.queue.*;
import java.util.NoSuchElementException;


import tr.edu.iyte.ceng112.tree.BinaryNode;

public class LevelOrderIterator<T> implements Iterator<T> {

    private QueueInterface<BinaryNode<T>> nodeQueue;

    public LevelOrderIterator(BinaryNode<T> root) {
        nodeQueue = new ArrayQueue<>();
        if (root != null) {
            nodeQueue.enqueue(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !nodeQueue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        BinaryNode<T> nextNode = null;
		try {
			nextNode = nodeQueue.dequeue();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
        assert nextNode != null;

        if (nextNode.getLeftChild() != null) {
            nodeQueue.enqueue(nextNode.getLeftChild());
        }
        if (nextNode.getRightChild() != null) {
            nodeQueue.enqueue(nextNode.getRightChild());
        }

        return nextNode.getData();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
