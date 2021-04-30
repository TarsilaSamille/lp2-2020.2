package aula03;

import java.io.File;

public class Tree {

    public int value;

    public Tree left;
    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public void setChilds(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }
    public void setRight(Tree a) {
        this.right = a;
    }

//    public String toString() {
//        return value + " ";
//    }

    public String toString() {
        return  toString(this, 0, "\n") ;
    }

    public String toString(Tree r , int level, String tab) {
        if (r == null)
            return "";
        String ll = toString(r.left, level + 1, tab + "\t");
        String rr = toString(r.right, level + 1, tab + "\t") ;
        return  rr + tab + r.value + " [Level:" + level +"] " + ll;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tree other = (Tree) obj;
        if (value != other.value)
            return false;
        return true;
    }

}
