package aula05;

public class PilhaDinamica {
	
	private No topo;
	public PilhaDinamica() {
		this.topo = null;
	
	}
	public void push(int elemento) {
		No noAux = new No(elemento);
		noAux.setProximo(this.topo);
		this.topo = noAux;
	
	}
	public void pop() {
		No noAux = this.topo;
		this.topo = noAux.getProximo();
		noAux.setProximo(null);
		
	}
	
	public void imprimir() {
	    if (this.topo == null) {
	        return;
	    }

	    No aux = this.topo;
	    
	    while (aux != null) {
	        System.out.print(aux.getElemento() + " ");
	        aux = aux.getProximo();
	    }
	    System.out.println();
	}


}
