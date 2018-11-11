package com.kamal.main;

import com.kamal.implementation.BinarySearchTreeImpl;

public class MainClass {
	public static void main(String[] args) {
		int[] input = { 5, 10, 15, 2, 6, 12, 7, 9, 16, 4, 3 };
		BinarySearchTreeImpl btree = new BinarySearchTreeImpl();
		for (int i = 0; i < input.length; i++)
			btree.addNode(input[i]);

		btree.printBSTInfix();
		System.out.println();
		System.out.println(btree.deleteNode(5));
		System.out.println();
		btree.printBSTInfix();

		System.out.println(btree.containsValue(10) + " " + btree.containsValue(5) + " " + btree.containsValue(21));
		System.out.println("Tree depth is " + btree.getTreeDepth());
	}
}
