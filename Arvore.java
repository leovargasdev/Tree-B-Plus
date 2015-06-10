import java.util.Collections;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Arvore{

	public Nodo Raiz;

	public Arvore(){

		this.Raiz = null;

	}

	public void insert(Integer chave){

  	NovoNodo(chave,this.Raiz);

  }

	public void NovoNodo(Integer chave, Nodo N){

		Nodo Novo = new Nodo();

		if( Raiz == null ){

			this.Raiz = Novo;

			Novo.NovoElemento(chave);

		} else if (N.lista.size() < N.limite){

			/*if (N.filho.size() != 0) {

				int k = 0;

				for(k = 0; k < N.lista.size(); k++){

					if(N.lista.get(k) > chave){

						break;
					}

				}

				if (k == N.lista.size()) k--;

				for(int j = 0; j < N.lista.size(); j++){

					if(N.lista.get(j) == N.lista.get(k)){

						//NovoNodo(chave,N.filho.get(k));

					}

				}

			} else {*/

				N.NovoElemento(chave);

			//}

		} else {

			Repartir(N.lista,Novo.lista);

			Nodo Pai = new Nodo();

			Pai.lista = CriaPai(Novo.lista, N.lista);

			Novo.pai = Pai;

			N.pai = Pai;

			//Pai.filho[0] = Novo;

			System.out.println("-=-=-=-=-=-=-=-=-=-=-");

			Pai.filho.put( 1 , Novo );

			//Pai.filho[1] = N;

			Pai.filho.put( 2 , N );


			this.Raiz = Pai;

			System.out.println(Pai.filho.get(1).lista + "<-Esquerda");

			System.out.println("\t\t" + Novo.pai.lista + "<-Pai");

			System.out.println(Pai.filho.get(2).lista + "<-Direita");

		}

	}

	public List CriaPai(List A, List B){

		List Pai = new LinkedList();

		Pai.add(A.get(A.size()-1));

		Pai.add(B.get(0));

		//A.remove(A.size()-1);

		//B.remove(0);

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

	/*public void Imprimir(Nodo N){

		for( int k = 0; k < N.limite; k++){

			if(N.filho[k] != null){

				Imprimir(N.filho[k]);

			}

		}

		if (N == this.Raiz) System.out.println(N.lista + " <---- Raiz");
		else System.out.println(N.lista);

	}*/

}
