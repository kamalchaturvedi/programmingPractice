package com.kamal.implementation;

import com.kamal.node.Node;

public abstract class BinarySearchTree {
	Node root;

	abstract void addNode(int value);

	abstract int deleteNode(int value);

	abstract int getTreeDepth();
	
	abstract boolean containsValue(int value);
	
	abstract void printBSTInfix();
	
	abstract void printBSTPostfix();
}
