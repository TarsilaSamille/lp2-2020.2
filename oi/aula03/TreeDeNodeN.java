package aula03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TreeDeNodeN {

    public static void main(String[] args) {
        NodeN node1 = new NodeN(2);
        NodeN node2 = new NodeN(3);

        NodeN nn3 = new NodeN(4);
        NodeN nn4 = new NodeN(5);
        NodeN nn5 = new NodeN(6);
        NodeN nn6 = new NodeN(7);
        NodeN nn7 = new NodeN(8);

        node1.setChild(nn3);
        node1.setChild(nn4);
        node2.setChild(nn6);
        node2.setChild(nn5);

        TreeDeNodeN tree = new TreeDeNodeN(1, node1, node2);
        tree.preOrder();
    }
    private NodeN root;

    public TreeDeNodeN(int r, NodeN left, NodeN rigth) {
        root = new NodeN(r);
        root.setChild(rigth);
        root.setChild(left);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(NodeN root) {
        PilhaNodeN temp = new PilhaNodeN();
        if (root != null) {
            System.out.print(root);
            while(!root.children.pilhaVazia()){
                preOrder(root.children.exibeUltimoValor());
                temp.empilhar(root.children.exibeUltimoValor());
                root.children.desempilhar();
            }
            while(!temp.pilhaVazia()){
                root.children.empilhar(temp.exibeUltimoValor());
                temp.desempilhar();
            }
        }
    }
}