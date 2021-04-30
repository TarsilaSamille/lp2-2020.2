package aula03;
import com.sun.source.util.Trees;

import java.util.ArrayList;
import java.util.Objects;
public class NodeN {

    int value;
    PilhaNodeN children;

    public NodeN(int value) {
        this.value = value;
        this.children = new PilhaNodeN();
    }

    public void setChild(NodeN n) {
        this.children.empilhar(n);
    }

    public boolean hasChild() {
        return !this.children.pilhaVazia();
    }


    public Tree paraBinario() {
        Tree tb = new Tree(this.value);
        int numeroDeFilhos = this.children.tamanho();
        if (numeroDeFilhos > 0) {
            Tree fe = this.children.exibeUltimoValor().paraBinario();
            ArrayList<Tree> trees = new ArrayList<>(0);
            if (numeroDeFilhos >= 2){
                this.children.desempilhar();
                while(!this.children.pilhaVazia()){
                    trees.add(this.children.exibeUltimoValor().paraBinario());
                    this.children.desempilhar();
                }
                for (int i = trees.size()-1; i >= 1 ; i--) {
                    trees.get(i-1).right = trees.get(i);
                }
                fe.right = trees.get(0);
            }
            tb.left = fe;

        }


//        int numeroDeFilhos = this.children.tamanho();
//        if (numeroDeFilhos > 0) {
//            Tree rigth, rigth2, left2;
//            NodeN ultimoValor = this.children.exibeUltimoValor();
//            Tree left = new Tree(ultimoValor.value);
//            System.out.println(tree+"aaaaaaaaaaaaaaaaaaaaa");
////
////            if(hasChild()){
////                rigth =  new Tree(this.value);
////                rigth.setChilds(ultimoValor.paraBinario(),null);
////            }
//            tree.setChilds(left, ultimoValor.paraBinario());
//            //left2 = ultimoValor.paraBinario().hasLeft() ? ultimoValor.paraBinario().left : null;
//
//            this.children.desempilhar();
//            System.out.println(tree+"aaaa");

//            for (int i = 2; i < numeroDeFilhos; i++) {
//                left2 = ultimoValor.paraBinario().hasLeft() ? ultimoValor.paraBinario().left : null;
//                this.children.desempilhar();
//                rigth =  new Tree(ultimoValor.value);
//                System.out.println(left2+"bbb");
//
//                left.setChilds(left2,rigth);
//                this.children.desempilhar();
//
//                ultimoValor = this.children.exibeUltimoValor();
//
//               // left.setChilds(rigth2.left ,rigth2);
//               left = left.right;
//
//            }
           // tree.setChilds(left, null);
        //}

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

    @Override
    public String toString() {
        return "NodeN{" +
                "value=" + value +
                ", children=" + children.exibeUltimoValor() +
                '}';
    }
}


