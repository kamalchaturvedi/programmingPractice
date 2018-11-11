package com.kamal.implementation;

import com.kamal.node.Node;

public class BinarySearchTreeImpl extends BinarySearchTree {

	public void addNode(int value) {
		if (root == null) {
			root = new Node();
			root.setValue(value);
		} else {
			Node tempNode = root;
			while (true) {
				if (value > tempNode.getValue()) {
					if (tempNode.getRight() != null)
						tempNode = tempNode.getRight();
					else
						break;
				} else {
					if (tempNode.getLeft() != null)
						tempNode = tempNode.getLeft();
					else
						break;
				}
			}
			Node currentNode = new Node();
			currentNode.setValue(value);
			if (value > tempNode.getValue())
				tempNode.setRight(currentNode);
			else
				tempNode.setLeft(currentNode);
		}
	}

	public int deleteNode(int value) {
		if (root == null)
			return -1;
		else {
			int nodeValueToReturn = -1;
			Node tempNode = root;
			Node parentNode = null;
			while (true) {
				if (value == tempNode.getValue()) {
					rightShiftOperation(tempNode, parentNode);
					nodeValueToReturn = tempNode.getValue();
					break;
				} else if (tempNode.getLeft() != null && value < tempNode.getValue()) {
					parentNode = tempNode;
					tempNode = tempNode.getLeft();
				} else if (tempNode.getRight() != null && value > tempNode.getValue()) {
					parentNode = tempNode;
					tempNode = tempNode.getRight();
				} else {
					break;
				}
			}
			return nodeValueToReturn;
		}
	}

	private void rightShiftOperation(Node tempNode, Node parentNode) {
		Node tempRightNode = (tempNode.getRight() != null ? tempNode.getRight() : null);
		Node tempLeftNode = (tempNode.getLeft() != null ? tempNode.getLeft() : null);
		Node traversalNode = tempLeftNode;
		while (traversalNode.getRight() != null)
			traversalNode = traversalNode.getRight();
		traversalNode.setRight(tempRightNode);
		if (parentNode == null) {
			root = tempLeftNode;
		} else if (tempNode.getValue() > parentNode.getValue()) {
			parentNode.setRight(tempLeftNode);
		} else {
			parentNode.setLeft(tempLeftNode);
		}
	}

	public int getTreeDepth() {
		int depth = 0;
		return getRecursiveTreeDepth(root, depth);
	}

	private int getRecursiveTreeDepth(Node currentNode, int depth) {
		if (currentNode == null)
			return depth;
		else
			return Math.max(getRecursiveTreeDepth(currentNode.getLeft(), depth + 1),
					getRecursiveTreeDepth(currentNode.getRight(), depth + 1));
	}

	public boolean containsValue(int value) {
		return containsValueRecursiveCheck(value, root);
	}

	private boolean containsValueRecursiveCheck(int value, Node tempNode) {
		if (tempNode == null)
			return false;
		if (tempNode.getValue() == value)
			return true;
		else if (value < tempNode.getValue())
			return containsValueRecursiveCheck(value, tempNode.getLeft());
		else
			return containsValueRecursiveCheck(value, tempNode.getRight());
	}

	public void printBSTInfix() {
		Node tempNode = root;
		printBSTInfixImpl(tempNode);
	}

	private void printBSTInfixImpl(Node tempNode) {
		if (tempNode != null) {
			printBSTInfixImpl(tempNode.getLeft());
			System.out.println(tempNode.getValue());
			printBSTInfixImpl(tempNode.getRight());
		}
	}

	public void printBSTPostfix() {
		Node tempNode = root;
		printBSTPostfixImpl(tempNode);
	}

	private void printBSTPostfixImpl(Node tempNode) {
		if (tempNode != null) {
			printBSTInfixImpl(tempNode.getLeft());
			printBSTInfixImpl(tempNode.getRight());
			System.out.println(tempNode.getValue());
		}
	}
}
