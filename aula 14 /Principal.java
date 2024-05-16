package aula14;

public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserirNo(arvore.noRaiz, 10);
        arvore.inserirNo(arvore.noRaiz, 5);
        arvore.inserirNo(arvore.noRaiz, 3);

       System.out.println("Altura da árvore: " + arvore.altura(arvore.noRaiz));

        if (arvore.isEstritamenteBinaria(arvore.noRaiz)) {
            System.out.println("A árvore é estritamente binária.");
        } else {
            System.out.println("A árvore não é estritamente binária.");
        }

        int numeroNos = arvore.contarNos(arvore.noRaiz);
        if (arvore.isArvoreBinariaCompleta(arvore.noRaiz, 0, numeroNos)) {
            System.out.println("A árvore é completa.");
        } else {
            System.out.println("A árvore não é completa.");
        }

        if (arvore.isArvoreBinariaCheia(arvore.noRaiz)) {
            System.out.println("A árvore é cheia.");
        } else {
            System.out.println("A árvore não é cheia.");
        }
    }
}
