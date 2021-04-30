package aula02;

import aula03.Tree;

public class Example08 {

	public static void main(String [] args) {
		//1234567
		
		//     4
		//   /   \
		//  2     6
		// / \   / \
		//1   3 5   7
		
		Tree node1 = new Tree(1);
		Tree node2 = new Tree(2);
		Tree node3 = new Tree(3);
		Tree node4 = new Tree(4);
		Tree node5 = new Tree(5);
		Tree node6 = new Tree(6);
		Tree node7 = new Tree(7);
		
		Tree root = node4;
		node4.setChilds(node2, node6);
		node2.setChilds(node1, node3);
		node6.setChilds(node5, node7);
		
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		posOrder(root);
	}
	
	public static void preOrder(Tree tree) {
		if(tree != null) {
			System.out.print(tree);
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	public static void inOrder(Tree tree) { // Como imprimir em ordem decrescente?
		if(tree != null) {
			inOrder(tree.left);
			System.out.print(tree);
			inOrder(tree.right);			
		}
	}
	
	public static void posOrder(Tree tree) {
		if(tree != null) {
			posOrder(tree.left);
			posOrder(tree.right);
			System.out.print(tree);
		}
	}
}
