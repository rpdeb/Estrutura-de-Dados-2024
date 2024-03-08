package aula05;

public class Principal {
	
	public static void main(String[] args) {
		
		PilhaDinamica pilha = new PilhaDinamica();
		pilha.push(20);
		pilha.push(30);
		pilha.push(40);
		
		pilha.imprimir();
	}

}
