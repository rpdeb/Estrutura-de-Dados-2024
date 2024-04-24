package Aula12;

public class ArvoreBinaria {
    public No noRaiz;

    public ArvoreBinaria(){
        this.noRaiz = null;
    }
    public void inserirNo(No noAtual, int elemento ){

        if(this.noRaiz == null){
            this.noRaiz = new No(elemento);
        }
        else if (elemento < noAtual.elemento)
        {
            if(noAtual.esquerda == null){
                noAtual.esquerda = new No(elemento);
            }
            else{
                noAtual = noAtual.esquerda;
                inserirNo(noAtual, elemento);
            }
        }
    }
}
