import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Arvore{

    public Nodo Raiz;
    public int limite;

    public Arvore(){

        limite = 3;
        Raiz = null;

    }

    public void Adiciona(Nodo N, Integer k){
        Nodo Novo = new Nodo();
        if (Raiz == null){
            Novo.NovoElemento(k);
            Raiz = Novo;
        } else if (!N.filho.isEmpty()){ // ja tem filhos
            int a;
            for(a = 0; a < N.lista.size(); a++){
                if(N.lista.get(a) > k){
                    break;
				}
			}
			if (a != 0) a--;// caso seja o indice um;
            int NumeroElemento = N.lista.get(a);
            //System.out.printl" + N.filho.get(NumeroElemento).lista);
            Adiciona(N.filho.get(NumeroElemento),k);
        } else if ( N.getTamanho() < (limite - 1) ) { // 4 nodos por folha
            N.NovoElemento(k);
            //System.out.println(N.getTamanho() + ", chave: " + k);
        } else if (N.pai != null){
            Nodo Pai = N.pai;
            Dividir(N,Novo);
            Pai.filho.put( Novo.lista.get(0) , Novo );// Raiz recebe o primeiro valor de novo e ele apontara para novo
            Novo.pai = Pai;
            Pai.NovoElemento(Novo.lista.get(0));
            Adiciona(Pai,k);
        } else { // primeira vez q estora um nodo
            //System.out.println(N.getTamanho() + ", passou o limite" + ", chave: " + k);
            /*Dividir(N, Novo);
            Nodo Pai = new Nodo();
			Pai.lista = CriaPai(N.lista, Novo.lista);
            Novo.pai = Pai;
            N.pai = Pai;
            Pai.filho.put( Pai.lista.get(0) , N );
			Pai.filho.put( Pai.lista.get(1) , Novo );
            //System.out.println("PAI: " + Pai.lista);
        //    System.out.println("[1]:" + Pai.filho.get(Pai.lista.get(0)).lista);
            //System.out.println("[2]:" + Pai.filho.get(Pai.lista.get(1)).lista);
            Adiciona(Pai,k);
            Raiz = Pai;*/
            GeraNovaRaiz(N,Novo);
            Adiciona(Raiz,k);
        }
        if (Raiz.getTamanho() > limite - 1){
            GeraNovaRaiz(N,Novo);
            Adiciona(Raiz,k);
        }

    }

    public void GeraNovaRaiz(Nodo N, Nodo Novo){
        //System.out.println(N.getTamanho() + ", passou o limite" + ", chave: " + k);
        Dividir(N, Novo);
        Nodo Pai = new Nodo();
        Pai.lista = CriaPai(N.lista, Novo.lista);
        Novo.pai = Pai;
        N.pai = Pai;
        Pai.filho.put( Pai.lista.get(0) , N );
        Pai.filho.put( Pai.lista.get(1) , Novo );
        //System.out.println("PAI: " + Pai.lista);
    //    System.out.println("[1]:" + Pai.filho.get(Pai.lista.get(0)).lista);
        //System.out.println("[2]:" + Pai.filho.get(Pai.lista.get(1)).lista);
        Raiz = Pai;
    }

    public List CriaPai(List A, List B){

        List Pai = new LinkedList();
        Pai.add(A.get(0));
        Pai.add(B.get(0));
        return Pai;

    }

    public void Dividir(Nodo Antigo, Nodo Novo){
        for (int k = 0; k < Antigo.lista.size(); k++){
			if(k > (Antigo.lista.size()/2) - 1){
				//System.out.println(Antigo.lista.get(k));
                Novo.NovoElemento(Antigo.lista.get(k));
				if ( Antigo.filho.get(Antigo.lista.get(k)) != null ){
					//System.out.println(Antigo.filho.get(Antigo.lista.get(k)).lista);
                    Novo.filho.put(Antigo.lista.get(k), Antigo.filho.get(Antigo.lista.get(k)));
                    //Antigo.filho.get(Antigo.lista.get(k)).pai = N
                    Antigo.filho.remove(Antigo.lista.get(k));
				}
                Antigo.lista.remove(k);
				k--;
			}
		}
    }

    public void Imprimir(Nodo N){

        if(!N.filho.isEmpty()){
            for (int k = 0; k < N.lista.size(); k++){
                if(N.filho.get(N.lista.get(k)) != null)
                    Imprimir(N.filho.get(N.lista.get(k)));
            }
        }

        if(N.pai == null){
            System.out.println("Lista: " + N.lista);
        } else {
            for (int a = 0; a < N.pai.lista.size(); a++){
                if (N.pai.filho.get(N.pai.lista.get(a)) == N){
                    System.out.println("P: " + N.pai.lista.get(a) + ", lista: " + N.lista);
                }
            }
        }
	}

}
