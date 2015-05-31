import java.util.Collections;
import java.util.*;

class Arvore{

	public Nodo Raiz;

	public Arvore(){

		this.Raiz = null;

	}

	public void insert(int chave){

  	Raiz = NovoNodo(chave,this.Raiz);

  }

	public Nodo NovoNodo(int chave, Nodo N){

		Nodo Novo = new Nodo();

		if( Raiz == null ){

			Raiz = Novo;

			Novo.NovoElemento(chave);

		} else if (N.filho[0] != null) {

			System.out.println("-=-=-=-=-=-=-=-= chave: " + chave);

		} else if (N.lista.size() < N.limite){

			N.NovoElemento(chave);

		} else {

			Repartir(N.lista,Novo.lista);

			Nodo Pai = new Nodo();

			Pai.lista = CriaPai(Novo.lista, N.lista);

			Novo.pai = Pai;

			N.pai = Pai;

			Pai.filho[0] = Novo;

			Pai.filho[1] = N;

			NovoNodo(chave, Pai);
/*
			System.out.println(Pai.filho[0].lista + "<-Esquerda");

			System.out.println("\t\t" + Novo.pai.lista + "<-Pai");

			System.out.println(Pai.filho[1].lista + "<-Direita");
*/
		}

		return Raiz;

	}

	public List CriaPai(List A, List B){

		List Pai = new LinkedList();

		Pai.add(A.get(A.size()-1));

		Pai.add(B.get(0));

		A.remove(A.size()-1);

		B.remove(0);

		return Pai;
	}

	public void Repartir(List A, List B){

		for(int k = 0; k < A.size()/2; k++){

			B.add(A.get(k));

		}
		for(int k = 0; k < B.size(); k++){

			for(int i = 0; i < A.size(); i++){

				if(B.get(k) == A.get(i))

					A.remove(i);

			}

		}

	}

}
