public class ListaDuplamenteEncadeada {
    class No {
        int dado;
        No anterior;
        No proximo;

        No(int dado) {
            this.dado = dado;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No cabeca;
    private No cauda;
    private int tamanho;

    ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void inserirInicio(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void inserirFim(int dado) {
        No novoNo = new No(dado);
        if (cauda == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
        tamanho++;
    }

    public void inserirMeio(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else if (cabeca.dado >= dado) {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        } else if (cauda.dado <= dado) {
            novoNo.anterior = cauda;
            cauda.proximo = novoNo;
            cauda = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null && atual.proximo.dado < dado) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public int removerInicio() {
        if (cabeca == null) {
            return -1; // ou lançar exceção
        }
        int dado = cabeca.dado;
        cabeca = cabeca.proximo;
        if (cabeca != null) {
            cabeca.anterior = null;
        } else {
            cauda = null;
        }
        tamanho--;
        return dado;
    }

    public int removerFim() {
        if (cauda == null) {
            return -1; // ou lançar exceção
        }
        int dado = cauda.dado;
        cauda = cauda.anterior;
        if (cauda != null) {
            cauda.proximo = null;
        } else {
            cabeca = null;
        }
        tamanho--;
        return dado;
    }

    public int removerMeio(int dado) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.dado == dado) {
                if (atual == cabeca) {
                    return removerInicio();
                } else if (atual == cauda) {
                    return removerFim();
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                    tamanho--;
                    return dado;
                }
            }
            atual = atual.proximo;
        }
        return -1; // ou lançar exceção
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimirLista() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.inserirFim(5);
        lista.inserirFim(7);
        lista.inserirFim(9);
        lista.inserirInicio(3);
        lista.inserirInicio(1);
        lista.inserirMeio(6);
        lista.removerFim();
        lista.removerInicio();
        lista.removerMeio(6);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("A lista está vazia? " + lista.estaVazia());
        System.out.print("Dados da lista: ");
        lista.imprimirLista();
    }
}
