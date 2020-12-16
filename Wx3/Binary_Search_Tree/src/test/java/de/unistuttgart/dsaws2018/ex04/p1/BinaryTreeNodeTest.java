package de.unistuttgart.dsaws2018.ex04.p1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.dsass2018.ex03.p3.BinaryTreeNode;
import de.unistuttgart.dsass2018.ex03.p3.IBinaryTreeNode;

public class BinaryTreeNodeTest {

	// START SOLUTION
	@Rule
    public Timeout globalTimeout = new Timeout(10000); // 10 seconds max per method tested
	
	@Test
	public void testBinaryTreeNode02pt() {
		IBinaryTreeNode<Integer> bstRootNode = new BinaryTreeNode<>();
		bstRootNode.setValue(5);
		
		IBinaryTreeNode<Integer> bstLeftNode = new BinaryTreeNode<>();
		bstLeftNode.setValue(3);
		
		IBinaryTreeNode<Integer> bstRightNode = new BinaryTreeNode<>();
		bstRightNode.setValue(7);
		
		bstRootNode.setLeftChild(bstLeftNode);
		bstRootNode.setRightChild(bstRightNode);
		
		assertEquals(new Integer(5), bstRootNode.getValue());
		assertEquals(bstLeftNode, bstRootNode.getLeftChild());
		assertEquals(bstRightNode, bstRootNode.getRightChild());
	}
	
	@Test
	public void testStringNode0Xpt() {
		IBinaryTreeNode<String> bstRootNode = new BinaryTreeNode<>();
		bstRootNode.setValue("Root");
		
		IBinaryTreeNode<String> bstLeftNode = new BinaryTreeNode<>();
		bstLeftNode.setValue("Left");
		
		IBinaryTreeNode<String> bstRightNode = new BinaryTreeNode<>();
		bstRightNode.setValue("Right");
		
		bstRootNode.setLeftChild(bstLeftNode);
		bstRootNode.setRightChild(bstRightNode);
		
		assertTrue(bstRootNode.getValue().equals("Root"));
		assertEquals(bstLeftNode, bstRootNode.getLeftChild());
		assertTrue(bstLeftNode.getValue().equals("Left"));
		assertEquals(bstRightNode, bstRootNode.getRightChild());
		assertTrue(bstRightNode.getValue().equals("Right"));
	}
	// END SOLUTION

}
