package aluno20190046339;

public class TreeV1 extends Tree {

	public static void main(String [] args) {
		Tree tree2 = new Tree();
		tree2.insert(12);
		tree2.insert(10);
		tree2.insert(11);
		tree2.insert(15);
		tree2.insert(13);
		tree2.insert(14);
		tree2.insert(16);
		tree2.insert(8);
		tree2.insert(7);
		tree2.insert(9);
		tree2.insert(5);
		tree2.insert(4);
		tree2.insert(3);
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(24);
		tree2.insert(23);
		tree2.insert(22);
		tree2.insert(21);
		System.out.println(tree2);
		System.out.println("---------------");


		TreeV1 tree = new TreeV1();
		tree.insert(12);
		tree.insert(10);
		tree.insert(11);
		tree.insert(15);
		tree.insert(13);
		tree.insert(14);
		tree.insert(16);
		tree.insert(8);
		tree.insert(7);
		tree.insert(9);
		tree.insert(5);
		tree.insert(4);
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		tree.insert(24);
		tree.insert(23);
		tree.insert(22);
		tree.insert(21);
		System.out.println(tree);
		System.out.println("---------------");


	//	tree2.remove(8);
		System.out.println("TREE");
		System.out.println(tree2.equals(tree));
		System.out.println(tree.equals(tree2));

	}

	public boolean insert(int value) {
		if(root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}

	private boolean insert(Node node, int value) {
		boolean nobreak = true;
		while(nobreak){
			if(value==node.value) return false;
			if(value > node.value) {
				if(node.hasRight()) {
					node = node.right;
				} else {
					node.right = new Node(value);
					nobreak = false;
				}
			} else {
				if(node.hasLeft()) {
					node = node.left;
				} else {
					node.left = new Node(value);
					nobreak = false;
				}
			}
		}
		return true;
	}


}
