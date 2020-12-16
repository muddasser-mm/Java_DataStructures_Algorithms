package de.unistuttgart.dsaws2018.ex04.p1;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.dsass2018.ex03.p3.BinarySearchTree;
import de.unistuttgart.dsass2018.ex03.p3.IBinarySearchTree;
import de.unistuttgart.dsass2018.ex03.p3.IBinaryTreeNode;

public class BinarySearchTreeTest {

	// START SOLUTION
	@Rule
	public Timeout globalTimeout = new Timeout(10000); // 10 seconds max per
														// method tested

	@Test
	public void testInsert04pt() {
		IBinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);
		bst.insert(3);

		IBinaryTreeNode<Integer> rootNode = bst.getRootNode();
		assertEquals(new Integer(2), rootNode.getLeftChild().getValue());
		assertEquals(new Integer(8), rootNode.getRightChild().getValue());
		assertEquals(new Integer(1), rootNode.getLeftChild().getLeftChild()
				.getValue());
		assertEquals(new Integer(3), rootNode.getLeftChild().getRightChild()
				.getValue());
		// Allows both "null node" and "nullNode"
		// assertTrue("There should be no duplicates in BST",
		// (rootNode.getLeftChild().getRightChild().getRightChild() == null) ||
		// (rootNode.getLeftChild().getRightChild().getLeftChild().getValue() ==
		// null) ||
		// (rootNode.getLeftChild().getRightChild().getRightChild().getValue()
		// == null));
		assertTrue(
				"There should be no duplicates in BST",
				((rootNode.getLeftChild().getRightChild().getLeftChild() == null) && (rootNode
						.getLeftChild().getRightChild().getRightChild() == null))
						|| ((rootNode.getLeftChild().getRightChild()
								.getLeftChild().getValue() == null) && (rootNode
								.getLeftChild().getRightChild().getRightChild()
								.getValue() == null)));
	}

	@Test
	public void testIsFull04pt() {
		IBinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);

		assertTrue("The tree should be full", bst.isFull());

		bst.insert(4);

		assertFalse("The tree should not be full", bst.isFull());
	}


	@Test
	public void testFullWithDuplicates() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		tree.insert(new Integer(5)); // Wurzel
		assertTrue(tree.isFull());

		tree.insert(new Integer(10)); // rechts
		assertFalse(tree.isFull());

		tree.insert(new Integer(3)); // links
		assertTrue(tree.isFull());

		tree.insert(new Integer(2)); // links links
		tree.insert(new Integer(4)); // links rechts
		assertTrue(tree.isFull());
		tree.insert(new Integer(3)); // ignore
		assertTrue(tree.isFull());

		tree.insert(new Integer(1111)); // rechts rechts
		assertFalse(tree.isFull()); // NICHTMEHR FULL
		tree.insert(new Integer(9)); // rechts links
		assertTrue(tree.isFull()); // wieder full
	}

	@Test
	public void testInsert() {
		IBinarySearchTree<String> bst = new BinarySearchTree<>();
		assertEquals(null, bst.getRootNode());
		bst.insert("Hallo");
		IBinaryTreeNode<String> rootNode = bst.getRootNode();
		assertTrue("Hallo".equals(rootNode.getValue()));
		bst.insert("Esel");
		assertTrue("Esel".equals(rootNode.getLeftChild().getValue()));

		bst.insert("Yellow");
		assertTrue("Yellow".equals(rootNode.getRightChild().getValue()));
		assertFalse("Yellow".equals(rootNode.getLeftChild().getValue()));

		bst.insert("Apfel");
		assertTrue("Apfel".equals(rootNode.getLeftChild().getLeftChild()
				.getValue()));
		// assertFalse("Apfel".equals(rootNode.getLeftChild().getRightChild().getValue()));
		// // fuehrt zur nullpointerexception

		bst.insert("Falle");
		assertTrue("Falle".equals(rootNode.getLeftChild().getRightChild()
				.getValue()));
		assertFalse("Falle".equals(rootNode.getLeftChild().getLeftChild()
				.getValue()));

		// H
		// E Y
		// A F
	}

	/**
	 * needs working insert method!!
	 */
	@Test
	public void testIsFull() {
		IBinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertTrue("An empty tree should be full", bst.isFull());
		bst.insert(10);
		assertTrue("The tree with one Element should be full", bst.isFull());
		bst.insert(5);
		assertFalse("The tree  should NOT be full", bst.isFull());
		bst.insert(20);
		assertTrue("The tree should be full", bst.isFull());
		bst.insert(-3);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(7);
		assertTrue("The tree should be full", bst.isFull());
		bst.insert(6);
		bst.insert(8);
		assertTrue("The tree should be full", bst.isFull());
		bst.insert(100);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(70);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(110);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(15);
		assertTrue("The tree should be full", bst.isFull());
		bst.insert(145);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(105);
		assertTrue("The tree should be full", bst.isFull());
		bst.insert(1);
		assertFalse("The tree should NOT be full", bst.isFull());
		bst.insert(-5);
		assertTrue("The tree should be full", bst.isFull());

		// 10
		// 5 20
		// -3 7 15 100
		// -5 1 6 8 70 110
		// 105 145
	}

	@Test
	public void testStringIsFull() {
		IBinarySearchTree<String> bst = new BinarySearchTree<>();
		bst.insert("Hallo");
		assertTrue("The tree should be full", bst.isFull());
		bst.insert("Esel");
		assertFalse("The tree should not be full", bst.isFull());

		bst.insert("Yellow");
		assertTrue("The tree should be full", bst.isFull());

		bst.insert("Apfel");
		assertFalse("The tree should be full", bst.isFull());

		bst.insert("Falle");
		assertTrue("The tree should be full", bst.isFull());

		// H
		// E Y
		// A F
	}

	@Test
	public void testRandomThing() {
		Solution_BinarySearchTree<Integer> bst = new Solution_BinarySearchTree<>();
		for (int i = 0; i < 1000; i++) {
			int random = (int) (Math.random() * 1337);
			bst.insert(random);
			bst.insert_solution(random);
			assertTrue(bst.compareTrees());
		}
	}
	// END SOLUTION

	// solutionclass
	/**
	 * 
	 * Solution Class: It inherits from BinarySearchTree, so all Methods that
	 * should be implemented can be checked with the solution
	 * No Method will be overwritten, so the solution of the student will be checked.
	 * 
	 * @author Jens
	 *
	 * @param <T> Generic Parameter
	 */
	private static class Solution_BinarySearchTree<T extends Comparable<T>>
			extends BinarySearchTree<T> {

		private volatile IBinaryTreeNode<T> solution_root;


		public Solution_BinarySearchTree() {

			this.solution_root = null;
		}

		public void insert_solution(T t) {
			this.solution_root = this.insert_solution(this.solution_root, t);
		}

		private IBinaryTreeNode<T> insert_solution(IBinaryTreeNode<T> node, T t) {
			if (node == null) {
				IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
				newNode.setValue(t);
				return newNode;
			}
			if (t.compareTo(node.getValue()) < 0) {
				// Go left
				node.setLeftChild(this.insert_solution(node.getLeftChild(), t));
			} else if (t.compareTo(node.getValue()) > 0) {
				// Go right
				node.setRightChild(this.insert_solution(node.getRightChild(), t));
			}
			return node;
		}

		public IBinaryTreeNode<T> getRootNode_solution() {
			return this.solution_root;
		}

		public boolean isFull_solution() {
			return this.isFull_solution(this.solution_root);
		}

		private boolean isFull_solution(IBinaryTreeNode<T> node) {
			if (node == null) {
				return true;
			} else if ((node.getLeftChild() == null)
					&& (node.getRightChild() == null)) {
				return true;
			} else if ((node.getLeftChild() == null)
					|| (node.getRightChild() == null)) {
				return false;
			}
			return this.isFull_solution(node.getLeftChild())
					&& this.isFull_solution(node.getRightChild());
		}


		/**
		 * Compares the level-Order of the tree and the solution tree
		 * 
		 * @return true if other tree equals solution tree
		 */
		public boolean compareTrees() {
			LevelorderIterator tree = new LevelorderIterator(this.getRootNode());
			LevelorderIterator solutionTree = new LevelorderIterator(
					this.solution_root);

			while (tree.hasNext()) {
				if (!solutionTree.hasNext()) {
					return false;
				}
				if (tree.next().compareTo(solutionTree.next()) != 0) {
					return false;
				}
			}
			if (tree.hasNext() != solutionTree.hasNext()) {
				return false;
			}
			return true;
		}

		/**
		 * Levelorder Iterator for a tree
		 *
		 */
		private class LevelorderIterator implements Iterator<T> {

			Queue<IBinaryTreeNode<T>> queue = new LinkedList<>();

			/**
			 * Constructor which needs the root node to start the levelorder from.
			 * 
			 * @param root (node where to start the levelorder)
			 */
			public LevelorderIterator(IBinaryTreeNode<T> root) {
				if (root != null) {
					this.queue.add(root);
				}
			}

			@Override
			public boolean hasNext() {
				return !this.queue.isEmpty();
			}

			@Override
			public T next() {
				IBinaryTreeNode<T> node = this.queue.remove();
				if (node.getLeftChild() != null) {
					this.queue.add(node.getLeftChild());
				}
				if (node.getRightChild() != null) {
					this.queue.add(node.getRightChild());
				}
				return node.getValue();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		}
	}
	// END SOLUTION
}
