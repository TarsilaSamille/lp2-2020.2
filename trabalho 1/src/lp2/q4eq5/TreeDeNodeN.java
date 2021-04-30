package lp2.q4eq5;

import java.util.Objects;

public class TreeDeNodeN {

    public static void main(String[] args) {
        NodeN node2 = new NodeN(2);
        NodeN node3 = new NodeN(3);
        NodeN nn4 = new NodeN(4);
        NodeN nn5 = new NodeN(5);
        NodeN nn6 = new NodeN(6);
        NodeN nn7 = new NodeN(7);
        NodeN nn8 = new NodeN(8);
        NodeN nn9= new NodeN(9);
        node2.setChild(nn4);
        node2.setChild(nn5);
        node3.setChild(nn6);
        node3.setChild(nn7);
        nn5.setChild(nn8);
        nn8.setChild(nn9);

        TreeDeNodeN tree = new TreeDeNodeN(1, node2, node3);
        //questão 4
//        PilhaNodeN p = tree.todosEmUm();
//        System.out.print("\nTamanho:" + p.tamanho() + "\n");
//        while(!p.pilhaVazia()){
//            System.out.print(p.exibeUltimoValor());
//            p.desempilhar();
//        }
        //questão 5
        System.out.print(NodeN.paraBinario(tree.root) + "\n");
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

    public PilhaNodeN todosEmUm() {
         return todosEmUm(root);
    }

    private PilhaNodeN todosEmUm(NodeN root) {
        PilhaNodeN p = new PilhaNodeN();
        if (root != null) {
            p.empilhar(root);
            while(!root.children.pilhaVazia()) {
                p.empilharPilha(todosEmUm(root.children.exibeUltimoValor()));
                root.children.desempilhar();
            }
        }
        return p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeDeNodeN that = (TreeDeNodeN) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}