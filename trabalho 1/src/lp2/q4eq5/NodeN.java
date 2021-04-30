package lp2.q4eq5;

import lp2.q2.Tree;

import java.util.ArrayList;
import java.util.Objects;
public class NodeN {

    int value;
    PilhaNodeN children;

    public NodeN(int value) {
        this.value = value;
        this.children = new PilhaNodeN();
    }

    public NodeN(NodeN n) {
        this.value = n.value;
        this.children = n.children;
    }


    public void setChild(NodeN n) {
        this.children.empilhar(n);
    }

    public boolean hasChild() {
        return !this.children.pilhaVazia();
    }

    public Tree paraBinario() {
        return NodeN.paraBinario(this);
    }

    public static Tree paraBinario(NodeN node) {
        Tree tb = new Tree(node.value);
        int numeroDeFilhos = node.children.tamanho();
        if (numeroDeFilhos > 0) {
            Tree fe = paraBinario(node.children.exibeUltimoValor());
            ArrayList<Tree> trees = new ArrayList<>(0);
            if (numeroDeFilhos >= 2){
                node.children.desempilhar();
                while(!node.children.pilhaVazia()){
                    trees.add(paraBinario(node.children.exibeUltimoValor()));
                    node.children.desempilhar();
                }
                for (int i = trees.size()-1; i >= 1 ; i--) {
                    trees.get(i-1).right = trees.get(i);
                }
                fe.right = trees.get(0);
            }
            tb.left = fe;
        }
        return tb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeN nodeN = (NodeN) o;
        return value == nodeN.value && Objects.equals(children, nodeN.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }

    public String toString() {
        return value + " ";
    }
}


