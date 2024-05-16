package aula14;

public class ArvoreBinaria {
    public No noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void inserirNo(No noAtual, int elemento) {
        if (this.noRaiz == null) {
            this.noRaiz = new No(elemento);
        } else if (elemento < noAtual.elemento) {
            if (noAtual.esquerda == null) {
                noAtual.esquerda = new No(elemento);
            } else {
                inserirNo(noAtual.esquerda, elemento);
            }
        } else {
            if (noAtual.direita == null) {
                noAtual.direita = new No(elemento);
            } else {
                inserirNo(noAtual.direita, elemento);
            }
        }
    }

    public int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            int alturaEsquerda = altura(no.esquerda);
            int alturaDireita = altura(no.direita);

            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

 public boolean isEstritamenteBinaria(No no) {
        if (no == null) {
            return true;
        }
        if ((no.esquerda == null && no.direita != null) || (no.esquerda != null && no.direita == null)) {
            return false;
        }
        return isEstritamenteBinaria(no.esquerda) && isEstritamenteBinaria(no.direita);
    }

    public boolean isArvoreBinariaCompleta(No no, int index, int numeroNos) {
        if (no == null) {
            return true;
        }
        if (index >= numeroNos) {
            return false;
        }
        return isArvoreBinariaCompleta(no.esquerda, 2 * index + 1, numeroNos) &&
               isArvoreBinariaCompleta(no.direita, 2 * index + 2, numeroNos);
    }

    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public boolean isArvoreBinariaCheia(No no) {
        if (no == null) {
            return true;
        }
        if (no.esquerda == null && no.direita == null) {
            return true;
        }
        if (no.esquerda != null && no.direita != null) {
            return isArvoreBinariaCheia(no.esquerda) && isArvoreBinariaCheia(no.direita);
        }
        return false;
    }
}
