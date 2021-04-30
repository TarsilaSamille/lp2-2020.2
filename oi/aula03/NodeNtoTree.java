package aula03;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class NodeNtoTree{

    public static void main(String[] args) {
        NodeN nn1 = new NodeN(1);
        NodeN nn2 = new NodeN(2);
        NodeN nn3 = new NodeN(3);
        NodeN nn4 = new NodeN(4);
        NodeN nn5 = new NodeN(5);
        NodeN nn6 = new NodeN(6);
        NodeN nn7 = new NodeN(7);
        NodeN nn8 = new NodeN(8);
        NodeN nn9 = new NodeN(9);
        NodeN nn10 = new NodeN(10);
        NodeN nn11 = new NodeN(11);
        NodeN nn12 = new NodeN(12);
        nn4.setChild(nn6);
        nn2.setChild(nn7);
        nn2.setChild(nn8);
        nn1.setChild(nn5);
        nn1.setChild(nn4);
        nn1.setChild(nn3);
        nn1.setChild(nn2);


       // TreeAggregation tree_a = new TreeAggregation(nn1.paraBinario());
       // tree_a.preOrder();
       // System.out.println(nn1.children.exibeUltimoValor());

        System.out.println(nn1.paraBinario());

    }
}