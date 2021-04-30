package lp2.q4eq5;

public class PilhaNodeN {

    public NodeN[] pilha;
    public int posicaoPilha;

    public PilhaNodeN() {
        this.posicaoPilha = -1;
        this.pilha = new NodeN[1000];
    }

    public boolean pilhaVazia() {
        return this.posicaoPilha == -1;
    }

    public int tamanho() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public NodeN exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public NodeN desempilhar() {
        if (pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(NodeN valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }

    public void empilharPilha(PilhaNodeN pilha) {
        while(!pilha.pilhaVazia()){
            if (this.posicaoPilha < this.pilha.length - 1) {
                this.pilha[++posicaoPilha] = pilha.exibeUltimoValor();
            }
            pilha.desempilhar();
        }
    }
}
